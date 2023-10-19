package com.staskokoc.giphydevcomposekoin.di

import com.staskokoc.giphydevcomposekoin.domain.usecases.GetGifsUrlsSharedPrefsUsecase
import com.staskokoc.giphydevcomposekoin.domain.usecases.SearchGifsUsecase
import com.staskokoc.giphydevcomposekoin.domain.usecases.GetTrendingGifsUsecase
import com.staskokoc.giphydevcomposekoin.domain.usecases.SaveGifsUrlsSharedPrefsUsecase
import org.koin.dsl.module

val domainModule = module {

    factory<SearchGifsUsecase> {
        SearchGifsUsecase(giphySearchRepository = get())
    }

    factory<GetTrendingGifsUsecase> {
        GetTrendingGifsUsecase(giphyTrendingRepository = get())
    }

    factory<GetGifsUrlsSharedPrefsUsecase> {
        GetGifsUrlsSharedPrefsUsecase(giphySharedPrefRepository = get())
    }

    factory<SaveGifsUrlsSharedPrefsUsecase> {
        SaveGifsUrlsSharedPrefsUsecase(giphySharedPrefRepository = get())
    }
}