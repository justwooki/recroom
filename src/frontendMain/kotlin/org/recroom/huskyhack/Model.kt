package org.recroom.huskyhack

import io.kvision.remote.getService

object Model {

    private val pingService = getService<IPingService>()

    suspend fun grabVideo(searchTerm: String): List<Video> {
        return pingService.grabVideo(searchTerm)
    }

}
