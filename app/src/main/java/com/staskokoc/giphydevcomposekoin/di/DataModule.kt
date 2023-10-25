package com.staskokoc.giphydevcomposekoin.di

import com.staskokoc.giphydevcomposekoin.data.api.GiphySearchApi
import com.staskokoc.giphydevcomposekoin.data.repositories.GiphySearchRepositoryImpl
import com.staskokoc.giphydevcomposekoin.data.repositories.GiphySharedPrefRepositoryImpl
import com.staskokoc.giphydevcomposekoin.data.api.GiphyTrendingApi
import com.staskokoc.giphydevcomposekoin.data.repositories.GiphyTrendingRepositoryImpl
import com.staskokoc.giphydevcomposekoin.domain.repositories.GiphySearchRepository
import com.staskokoc.giphydevcomposekoin.domain.repositories.GiphySharedPrefRepository
import com.staskokoc.giphydevcomposekoin.domain.repositories.GiphyTrendingRepository
import org.koin.dsl.module

val dataModule = module {

    single<GiphySearchApi> {
        GiphySearchApi()
    }

    single<GiphyTrendingApi> {
        GiphyTrendingApi()
    }

    single<GiphySearchRepository> {
        GiphySearchRepositoryImpl(giphySearchApi = get())
    }

    single<GiphyTrendingRepository> {
        GiphyTrendingRepositoryImpl(giphyTrendingApi = get())
    }

    single<GiphySharedPrefRepository> {
        GiphySharedPrefRepositoryImpl(context = get())
    }
}