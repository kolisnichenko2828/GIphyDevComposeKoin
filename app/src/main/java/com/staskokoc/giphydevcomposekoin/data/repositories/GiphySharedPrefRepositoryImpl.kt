package com.staskokoc.giphydevcomposekoin.data.repositories

import android.content.Context
import com.staskokoc.giphydevcomposekoin.domain.models.Gifs
import com.staskokoc.giphydevcomposekoin.domain.repositories.GiphySharedPrefRepository
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json

private const val SHARED_PREFS_NAME = "shared_prefs_last_search"
private const val LAST_SEARCH = "last_search"

class GiphySharedPrefRepositoryImpl(context: Context) : GiphySharedPrefRepository {
    private val sharedPrefs = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override suspend fun saveLastSearch(lastSearch: String?) {
        sharedPrefs.edit().putString(LAST_SEARCH, lastSearch).apply()
    }

    override suspend fun getLastSearch(): String? {
        val lastSearch = sharedPrefs.getString(LAST_SEARCH, null)

        return lastSearch
    }
}