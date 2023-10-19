package com.staskokoc.giphydevcomposekoin.domain.repositories

import com.staskokoc.giphydevcomposekoin.domain.models.Gifs

interface GiphySharedPrefRepository {
    suspend fun saveGifsModel(gifs: Gifs?)
    suspend fun getGifsModel(): Gifs?
}