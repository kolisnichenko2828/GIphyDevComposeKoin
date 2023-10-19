package com.staskokoc.giphydevcomposekoin.domain.usecases

import com.staskokoc.giphydevcomposekoin.domain.models.Gifs
import com.staskokoc.giphydevcomposekoin.domain.repositories.GiphySharedPrefRepository

class GetLastSearchSharedPrefsUsecase(private val giphySharedPrefRepository: GiphySharedPrefRepository) {
    suspend fun execute(): String? {
        val lastSearch = giphySharedPrefRepository.getLastSearch()

        return lastSearch
    }
}