package com.staskokoc.giphydevcomposekoin.domain.usecases

import com.staskokoc.giphydevcomposekoin.domain.models.Gifs
import com.staskokoc.giphydevcomposekoin.domain.repositories.GiphySharedPrefRepository

class GetGifsUrlsSharedPrefsUsecase(private val giphySharedPrefRepository: GiphySharedPrefRepository) {
    suspend fun execute(): Gifs? {
        val gifs = giphySharedPrefRepository.getGifsModel()

        return gifs
    }
}