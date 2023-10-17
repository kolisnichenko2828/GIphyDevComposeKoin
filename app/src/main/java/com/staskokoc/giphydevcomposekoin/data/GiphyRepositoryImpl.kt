package com.staskokoc.giphydevcomposekoin.data

import com.staskokoc.giphydevcomposekoin.domain.GiphyRepository
import com.staskokoc.giphydevcomposekoin.domain.models.Gifs

class GiphyRepositoryImpl(val giphyApi: GiphyApi): GiphyRepository {
    private val api_key: String = "Ktli4o48X9FnJCb9Npp7qEg8Df8B1zXM"
    private var limit: Int = 25
    private var offset: Int = 0
    private var rating: String = "g"
    private var lang: String = "en"

    override suspend fun getGifs(q: String): Gifs {
        val gifsDto = giphyApi.getGifsDto(
            apiKey = api_key,
            q = q,
            limit = limit,
            offset = offset,
            rating = rating,
            lang = lang)
        val gifs = gifsDto.gifsDtoToGifs()

        return gifs
    }
}