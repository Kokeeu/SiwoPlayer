package com.kokeeu.siwoplayer.data.repository

import androidx.paging.PagingData
import com.kokeeu.siwoplayer.data.model.Song
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

interface SongRepository {
    fun getSongs(): Flow<List<Song>>
    fun getSongsByAlbum(albumId: Long): Flow<List<Song>>
    fun getSongsByArtist(artistId: Long): Flow<List<Song>>
    suspend fun searchSongs(query: String): List<Song>
    fun getSongById(songId: Long): Flow<Song?>
    fun getPaginatedSongs(sortOption: com.kokeeu.siwoplayer.data.model.SortOption, storageFilter: com.kokeeu.siwoplayer.data.model.StorageFilter): Flow<PagingData<Song>>
    @OptIn(ExperimentalCoroutinesApi::class)
    fun getPaginatedSongs(): Flow<PagingData<Song>>
    fun getPaginatedFavoriteSongs(
        sortOption: com.kokeeu.siwoplayer.data.model.SortOption,
        storageFilter: com.kokeeu.siwoplayer.data.model.StorageFilter
    ): Flow<PagingData<Song>>
    suspend fun getFavoriteSongsOnce(
        storageFilter: com.kokeeu.siwoplayer.data.model.StorageFilter
    ): List<Song>
    fun getFavoriteSongCountFlow(
        storageFilter: com.kokeeu.siwoplayer.data.model.StorageFilter
    ): Flow<Int>
}
