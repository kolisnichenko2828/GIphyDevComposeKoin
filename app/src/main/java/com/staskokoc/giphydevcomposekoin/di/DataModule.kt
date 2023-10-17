package com.staskokoc.giphydevcomposekoin.di

import com.staskokoc.giphydevcomposekoin.data.GiphyApi
import com.staskokoc.giphydevcomposekoin.data.GiphyRepositoryImpl
import com.staskokoc.giphydevcomposekoin.domain.GiphyRepository
import org.koin.dsl.module

val dataModule = module {

    single<GiphyApi> {
        GiphyApi()
    }

    single<GiphyRepository> {
        GiphyRepositoryImpl(giphyApi = get())
    }
}