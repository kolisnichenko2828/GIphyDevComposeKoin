package com.staskokoc.giphydevcomposekoin.data.giphy_sharedpref

import android.content.Context
import com.staskokoc.giphydevcomposekoin.domain.models.Gifs
import com.staskokoc.giphydevcomposekoin.domain.repositories.GiphySharedPrefRepository
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json

private const val SHARED_PREFS_NAME = "shared_prefs_gifs_model"
private const val LIST_OF_PREVIEW_URLS = "list_of_preview_urls"
private const val LIST_OF_LARGE_URLS = "list_of_large_urls"

class GiphySharedPrefRepositoryImpl(private val context: Context) : GiphySharedPrefRepository {
    private val sharedPrefs = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override suspend fun saveGifsModel(gifs: Gifs?) {
        if(gifs == null) { return }
        val jsonListOfUrlsPreviewGifs = Json.encodeToString(
            serializer = ListSerializer(String.serializer()),
            value = gifs.listOfUrlsPreviewGifs
        )
        val jsonListOfUrlsLargeGifs = Json.encodeToString(
            serializer = ListSerializer(String.serializer()),
            value = gifs.listOfUrlsLargeGifs
        )
        sharedPrefs
            .edit()
            .putString(LIST_OF_PREVIEW_URLS, jsonListOfUrlsPreviewGifs)
            .putString(LIST_OF_LARGE_URLS, jsonListOfUrlsLargeGifs)
            .apply()
    }

    override suspend fun getGifsModel(): Gifs? {
        val jsonListOfUrlsPreviewGifs = sharedPrefs.getString(LIST_OF_PREVIEW_URLS, null)
        val listOfUrlsPreviewGifs = Json.decodeFromString(
            deserializer = ListSerializer(String.serializer()),
            string = jsonListOfUrlsPreviewGifs ?: return null
        )
        val jsonListOfUrlsLargeGifs = sharedPrefs.getString(LIST_OF_LARGE_URLS, null)
        val listOfUrlsLargeGifs = Json.decodeFromString(
            deserializer = ListSerializer(String.serializer()),
            string = jsonListOfUrlsLargeGifs ?: return null
        )
        return Gifs(
            listOfUrlsPreviewGifs = listOfUrlsPreviewGifs,
            listOfUrlsLargeGifs = listOfUrlsLargeGifs
        )
    }
}