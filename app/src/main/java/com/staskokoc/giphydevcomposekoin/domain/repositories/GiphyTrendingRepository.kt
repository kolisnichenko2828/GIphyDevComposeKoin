package com.staskokoc.giphydevcomposekoin.domain.repositories

import com.staskokoc.giphydevcomposekoin.domain.models.Gifs

interface GiphyTrendingRepository {
    suspend fun getTrendingGifs(): Gifs
}