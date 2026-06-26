package com.kokeeu.siwoplayer.data.provider

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SharedArtworkContentProviderTest {

    @Test
    fun buildSongUri_usesDedicatedArtworkAuthority() {
        val uri = SharedArtworkContentProvider.buildSongUriString(
            packageName = "com.kokeeu.siwoplayer",
            songId = 42L
        )

        assertThat(uri).isEqualTo("content://com.kokeeu.siwoplayer.artwork/song/42")
    }

    @Test
    fun buildSongUri_preservesCacheBustToken() {
        val uri = SharedArtworkContentProvider.buildSongUriString(
            packageName = "com.kokeeu.siwoplayer",
            songId = 42L,
            cacheBustToken = "1234"
        )

        assertThat(uri)
            .isEqualTo("content://com.kokeeu.siwoplayer.artwork/song/42?t=1234")
    }

    @Test
    fun parseSongId_rejectsOtherAuthorities() {
        val songId = SharedArtworkContentProvider.parseSongId(
            uriString = "content://example.com.artwork/song/42",
            packageName = "com.kokeeu.siwoplayer"
        )

        assertThat(songId).isNull()
    }

    @Test
    fun parseSongId_readsSharedArtworkSongUri() {
        val songId = SharedArtworkContentProvider.parseSongId(
            uriString = "content://com.kokeeu.siwoplayer.artwork/song/42",
            packageName = "com.kokeeu.siwoplayer"
        )

        assertThat(songId).isEqualTo(42L)
    }
}
