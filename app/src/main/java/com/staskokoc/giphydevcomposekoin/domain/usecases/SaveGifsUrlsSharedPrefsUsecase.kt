package com.staskokoc.giphydevcomposekoin.domain.usecases

import com.staskokoc.giphydevcomposekoin.domain.models.Gifs
import com.staskokoc.giphydevcomposekoin.domain.repositories.GiphySharedPrefRepository

class SaveGifsUrlsSharedPrefsUsecase(private val giphySharedPrefRepository: GiphySharedPrefRepository) {
    suspend fun execute(gifs: Gifs?) {
        giphySharedPrefRepository.saveGifsModel(gifs)
    }
}