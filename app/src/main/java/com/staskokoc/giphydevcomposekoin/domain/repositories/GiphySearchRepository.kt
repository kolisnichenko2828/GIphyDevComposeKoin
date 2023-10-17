package com.staskokoc.giphydevcomposekoin.domain.repositories

import com.staskokoc.giphydevcomposekoin.domain.models.Gifs

interface GiphySearchRepository {
    suspend fun getGifs(q: String): Gifs
}