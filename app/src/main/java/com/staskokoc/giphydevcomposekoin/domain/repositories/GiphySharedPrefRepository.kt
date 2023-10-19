package com.staskokoc.giphydevcomposekoin.domain.repositories

interface GiphySharedPrefRepository {
    suspend fun saveLastSearch(lastSearch: String?)
    suspend fun getLastSearch(): String?
}