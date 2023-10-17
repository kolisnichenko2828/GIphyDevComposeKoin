package com.staskokoc.giphydevcomposekoin.domain.usecases

import com.staskokoc.giphydevcomposekoin.domain.repositories.GiphySearchRepository
import com.staskokoc.giphydevcomposekoin.domain.models.Gifs

class SearchGifsUsecase(private val giphySearchRepository: GiphySearchRepository) {
    suspend fun execute(q: String): Gifs {
        val gifs = giphySearchRepository.getGifs(q = q)

        return gifs
    }
}