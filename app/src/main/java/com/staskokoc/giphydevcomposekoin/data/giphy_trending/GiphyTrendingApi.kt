package com.staskokoc.giphydevcomposekoin.data.giphy_trending

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class GiphyTrendingApi {
    suspend fun getTrendingGifsDto(
        apiKey: String,
        limit: Int,
        offset: Int,
        rating: String,
        bundle: String): GifsTrendingDto {

        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }

        val url = "https://api.giphy.com/v1/gifs/trending?" +
                "api_key=$apiKey" +
                "&limit=$limit" +
                "&offset=$offset" +
                "&rating=$rating" +
                "&bundle=$bundle"

        val gifsTrendingDto: GifsTrendingDto = client.get(url).body()

        return gifsTrendingDto
    }
}