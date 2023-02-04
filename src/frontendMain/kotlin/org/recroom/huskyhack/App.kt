package org.recroom.huskyhack

import io.kvision.Application
import io.kvision.CoreModule
import io.kvision.BootstrapModule
import io.kvision.BootstrapCssModule
import io.kvision.DatetimeModule
import io.kvision.RichTextModule
import io.kvision.BootstrapUploadModule
import io.kvision.FontAwesomeModule
import io.kvision.BootstrapIconsModule
import io.kvision.ChartModule
import io.kvision.TabulatorModule
import io.kvision.TabulatorCssBootstrapModule
import io.kvision.core.onEvent
import io.kvision.form.text.TextInput
import io.kvision.form.text.text
import io.kvision.form.text.textInput
import io.kvision.html.*
import io.kvision.module
import io.kvision.panel.hPanel
import io.kvision.panel.root
import io.kvision.panel.vPanel
import io.kvision.startApplication
import io.kvision.utils.ENTER_KEY
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch

val AppScope = CoroutineScope(window.asCoroutineDispatcher())

class App : Application() {

    override fun start(state: Map<String, Any>) {
        lateinit var textInput: TextInput
        val root = root("kvapp") {
            vPanel {
                hPanel {
                    textInput = textInput {
                        +"Type Something"
                    }.apply {
                        onEvent {
                            keydown = {
                                if (it.keyCode == ENTER_KEY) {
                                    println("got it")
                                    AppScope.launch {
                                        Model.grabVideo(textInput.value ?: "")
                                    }
                                }
                            }
                        }
                    }
                    button("Create Account")
                    button("Upload Video")
                    button("Your Videos")
                }
            }
        }
    }
}

fun main() {
    startApplication(
        ::App,
        module.hot,
        BootstrapModule,
        BootstrapCssModule,
        DatetimeModule,
        RichTextModule,
        BootstrapUploadModule,
        FontAwesomeModule,
        BootstrapIconsModule,
        ChartModule,
        TabulatorModule,
        TabulatorCssBootstrapModule,
        CoreModule
    )
}
