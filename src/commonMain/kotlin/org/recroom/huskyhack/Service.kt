package org.recroom.huskyhack

import io.kvision.annotations.KVService

@KVService
interface IPingService {
    suspend fun grabVideo(searchTerm: String): List<Video>
}
