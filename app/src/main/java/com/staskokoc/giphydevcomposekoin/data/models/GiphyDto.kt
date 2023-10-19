package com.staskokoc.giphydevcomposekoin.data.models

import com.staskokoc.giphydevcomposekoin.domain.models.Gifs
import kotlinx.serialization.Serializable

@Serializable
data class Data(val images: Images)
@Serializable
data class Images(val fixed_height_small: FixedHeightSmall?, val original: Original)
@Serializable
data class FixedHeightSmall(val url: String?)
@Serializable
data class Original(val url: String)

@Serializable
data class GiphyDto(val `data`: List<Data>) {
    fun giphyDtoToGifs(): Gifs {
        val urlsPreview = data.map {
            it.images.fixed_height_small?.url ?: it.images.original.url
        }
        val urlsLarge = data.map {
            it.images.original.url
        }

        return Gifs(
            listOfUrlsPreviewGifs = urlsPreview,
            listOfUrlsLargeGifs = urlsLarge
        )
    }
}