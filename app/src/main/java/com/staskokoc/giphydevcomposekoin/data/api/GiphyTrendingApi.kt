package com.staskokoc.giphydevcomposekoin.data.api

import com.staskokoc.giphydevcomposekoin.data.models.GiphyDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

class GiphyTrendingApi {
    @OptIn(ExperimentalSerializationApi::class)
    suspend fun getTrendingGifsDto(
        apiKey: String,
        limit: Int,
        offset: Int,
        rating: String,
        bundle: String): GiphyDto {

        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                })
            }
        }

        val url = "https://api.giphy.com/v1/gifs/trending?" +
                "api_key=$apiKey" +
                "&limit=$limit" +
                "&offset=$offset" +
                "&rating=$rating" +
                "&bundle=$bundle"

        val giphyDto: GiphyDto = client.get(url).body()

        return giphyDto
    }
}