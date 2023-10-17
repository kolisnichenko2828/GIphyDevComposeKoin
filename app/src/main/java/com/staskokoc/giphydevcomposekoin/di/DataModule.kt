package com.staskokoc.giphydevcomposekoin.di

import com.staskokoc.giphydevcomposekoin.data.giphy_search.GiphySearchApi
import com.staskokoc.giphydevcomposekoin.data.giphy_search.GiphySearchRepositoryImpl
import com.staskokoc.giphydevcomposekoin.data.giphy_trending.GiphyTrendingApi
import com.staskokoc.giphydevcomposekoin.data.giphy_trending.GiphyTrendingRepositoryImpl
import com.staskokoc.giphydevcomposekoin.domain.repositories.GiphySearchRepository
import com.staskokoc.giphydevcomposekoin.domain.repositories.GiphyTrendingRepository
import org.koin.dsl.module

val dataModule = module {

    single<GiphySearchApi> {
        GiphySearchApi()
    }

    single<GiphySearchRepository> {
        GiphySearchRepositoryImpl(giphySearchApi = get())
    }

    single<GiphyTrendingApi> {
        GiphyTrendingApi()
    }

    single<GiphyTrendingRepository> {
        GiphyTrendingRepositoryImpl(giphyTrendingApi = get())
    }
}