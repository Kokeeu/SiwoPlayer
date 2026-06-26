package com.kokeeu.siwoplayer.data

import com.kokeeu.siwoplayer.shared.WearLibraryItem

data class WearLocalQueueState(
    val items: List<WearLibraryItem> = emptyList(),
    val currentIndex: Int = -1,
)
