package com.staskokoc.giphydevcomposekoin.data

import com.staskokoc.giphydevcomposekoin.data.models.GifsDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class GiphyApi {
    suspend fun getGifsDto(
        apiKey: String,
        q: String,
        limit: Int,
        offset: Int,
        rating: String,
        lang: String): GifsDto {

        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }

        val url = "https://api.giphy.com/v1/gifs/search?" +
                "api_key=$apiKey" +
                "&q=$q" +
                "&limit=$limit" +
                "&offset=$offset" +
                "&rating=$rating" +
                "&lang=$lang"

        val gifsDto: GifsDto = client.get(url).body()

        return gifsDto
    }
}