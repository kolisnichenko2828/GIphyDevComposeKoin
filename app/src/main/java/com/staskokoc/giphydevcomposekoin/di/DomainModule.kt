package com.staskokoc.giphydevcomposekoin.di

import com.staskokoc.giphydevcomposekoin.domain.usecases.GetLastSearchSharedPrefsUsecase
import com.staskokoc.giphydevcomposekoin.domain.usecases.SearchGifsUsecase
import com.staskokoc.giphydevcomposekoin.domain.usecases.GetTrendingGifsUsecase
import com.staskokoc.giphydevcomposekoin.domain.usecases.SaveLastSearchSharedPrefsUsecase
import org.koin.dsl.module

val domainModule = module {

    factory<SearchGifsUsecase> {
        SearchGifsUsecase(giphySearchRepository = get())
    }

    factory<GetTrendingGifsUsecase> {
        GetTrendingGifsUsecase(giphyTrendingRepository = get())
    }

    factory<GetLastSearchSharedPrefsUsecase> {
        GetLastSearchSharedPrefsUsecase(giphySharedPrefRepository = get())
    }

    factory<SaveLastSearchSharedPrefsUsecase> {
        SaveLastSearchSharedPrefsUsecase(giphySharedPrefRepository = get())
    }
}