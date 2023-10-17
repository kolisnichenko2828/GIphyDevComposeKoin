package com.staskokoc.giphydevcomposekoin.data.models

import com.staskokoc.giphydevcomposekoin.domain.models.Gifs
import kotlinx.serialization.Serializable

@Serializable
data class Data(val images: Images)
@Serializable
data class Images(val downsized_large: DownsizedLarge, val preview_gif: PreviewGif)
@Serializable
data class PreviewGif(val url: String)
@Serializable
data class DownsizedLarge(val url: String)

@Serializable
data class GifsDto(val `data`: List<Data>) {
    fun gifsDtoToGifs(): Gifs {
        val urlsPreview = data.map { it.images.preview_gif.url }
        val urlsLarge = data.map { it.images.downsized_large.url }

        return Gifs(
            listOfUrlsPreviewGifs = urlsPreview,
            listOfUrlsLargeGifs = urlsLarge
        )
    }
}