package com.staskokoc.giphydevcomposekoin.domain.usecases

import com.staskokoc.giphydevcomposekoin.domain.GiphyRepository
import com.staskokoc.giphydevcomposekoin.domain.models.Gifs

class GetGifsUsecase(private val giphyRepository: GiphyRepository) {
    suspend fun execute(q: String): Gifs {
        val gifs = giphyRepository.getGifs(q = q)

        return gifs
    }
}