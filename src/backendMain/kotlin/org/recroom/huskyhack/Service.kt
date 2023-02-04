package org.recroom.huskyhack

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual class PingService : IPingService {

    override suspend fun grabVideo(searchTerm: String): List<Video> {
        val videos: List<Video> = listOf(
            Video("Mulan", "Danielle"),
            Video("Tomatoes", "Isa"),
            Video("Everything Everywhere All At Once", "Matthew")
        )
        return videos
    }
}
