package com.staskokoc.giphydevcomposekoin.di

import com.staskokoc.giphydevcomposekoin.domain.usecases.SearchGifsUsecase
import com.staskokoc.giphydevcomposekoin.domain.usecases.GetTrendingGifsUsecase
import org.koin.dsl.module

val domainModule = module {

    factory<SearchGifsUsecase> {
        SearchGifsUsecase(giphySearchRepository = get())
    }

    factory<GetTrendingGifsUsecase> {
        GetTrendingGifsUsecase(giphyTrendingRepository = get())
    }
}