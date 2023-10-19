package com.staskokoc.giphydevcomposekoin.data.repositories

import com.staskokoc.giphydevcomposekoin.data.api.GiphySearchApi
import com.staskokoc.giphydevcomposekoin.domain.repositories.GiphySearchRepository
import com.staskokoc.giphydevcomposekoin.domain.models.Gifs

class GiphySearchRepositoryImpl(val giphySearchApi: GiphySearchApi): GiphySearchRepository {
    private val api_key: String = "Ktli4o48X9FnJCb9Npp7qEg8Df8B1zXM"
    private var limit: Int = 50
    private var offset: Int = 0
    private var rating: String = "g"
    private var lang: String = "en"

    override suspend fun getGifs(q: String): Gifs {
        val formattedQ = q.replace(" ", "+")
        val giphyDto = giphySearchApi.getGifsDto(
            apiKey = api_key,
            q = formattedQ,
            limit = limit,
            offset = offset,
            rating = rating,
            lang = lang
        )
        val gifs = giphyDto.giphyDtoToGifs()

        return gifs
    }
}