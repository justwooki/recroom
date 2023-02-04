package org.recroom.huskyhack

import kotlinx.serialization.Serializable

@Serializable
data class Video(val fileName: String, val user: String){
    val id: Int = fileName.hashCode()
}