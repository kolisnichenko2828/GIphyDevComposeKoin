package com.staskokoc.giphydevcomposekoin.domain.usecases

import com.staskokoc.giphydevcomposekoin.domain.models.Gifs
import com.staskokoc.giphydevcomposekoin.domain.repositories.GiphyTrendingRepository

class GetTrendingGifsUsecase(private val giphyTrendingRepository: GiphyTrendingRepository) {
    suspend fun execute(): Gifs {
        val gifs = giphyTrendingRepository.getTrendingGifs()

        return gifs
    }
}