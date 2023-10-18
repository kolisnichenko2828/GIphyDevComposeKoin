package com.staskokoc.giphydevcomposekoin.data.giphy_trending.models

import com.staskokoc.giphydevcomposekoin.domain.models.Gifs
import kotlinx.serialization.Serializable

@Serializable
data class Data(val images: Images)
@Serializable
data class Images(val fixed_height_small: FixedHeightSmall, val original: Original)
@Serializable
data class Original(val url: String)
@Serializable
data class FixedHeightSmall(val url: String)

@Serializable
data class GifsTrendingDto(val `data`: List<Data>) {
    fun gifsDtoToGifs(): Gifs {
        val urlsPreview = data.map { it.images.fixed_height_small.url }
        val urlsLarge = data.map { it.images.original.url }

        return Gifs(
            listOfUrlsPreviewGifs = urlsPreview,
            listOfUrlsLargeGifs = urlsLarge
        )
    }
}