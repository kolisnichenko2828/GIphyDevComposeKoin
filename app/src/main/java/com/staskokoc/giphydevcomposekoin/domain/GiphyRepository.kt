package com.staskokoc.giphydevcomposekoin.domain

import com.staskokoc.giphydevcomposekoin.domain.models.Gifs

interface GiphyRepository {
    suspend fun getGifs(q: String): Gifs
}