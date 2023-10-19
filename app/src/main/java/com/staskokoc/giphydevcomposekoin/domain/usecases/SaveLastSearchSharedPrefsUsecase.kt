package com.staskokoc.giphydevcomposekoin.domain.usecases

import com.staskokoc.giphydevcomposekoin.domain.repositories.GiphySharedPrefRepository

class SaveLastSearchSharedPrefsUsecase(private val giphySharedPrefRepository: GiphySharedPrefRepository) {
    suspend fun execute(lastSearch: String?) {
        giphySharedPrefRepository.saveLastSearch(lastSearch)
    }
}