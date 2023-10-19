package com.staskokoc.giphydevcomposekoin.data.repositories

import com.staskokoc.giphydevcomposekoin.data.api.GiphyTrendingApi
import com.staskokoc.giphydevcomposekoin.domain.models.Gifs
import com.staskokoc.giphydevcomposekoin.domain.repositories.GiphyTrendingRepository

class GiphyTrendingRepositoryImpl(val giphyTrendingApi: GiphyTrendingApi): GiphyTrendingRepository {
    private val api_key: String = "Ktli4o48X9FnJCb9Npp7qEg8Df8B1zXM"
    private var limit: Int = 50
    private var offset: Int = 0
    private var rating: String = "g"
    private var bundle: String = "messaging_non_clips"

    override suspend fun getTrendingGifs(): Gifs {
        val giphyDto = giphyTrendingApi.getTrendingGifsDto(
            apiKey = api_key,
            limit = limit,
            offset = offset,
            rating = rating,
            bundle = bundle
        )
        val gifs = giphyDto.giphyDtoToGifs()

        return gifs
    }
}