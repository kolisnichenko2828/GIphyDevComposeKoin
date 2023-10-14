package com.staskokoc.giphydevcomposekoin.di

import com.staskokoc.giphydevcomposekoin.domain.usecases.GetGifsUsecase
import org.koin.dsl.module

val domainModule = module {

    factory<GetGifsUsecase> {
        GetGifsUsecase(giphyRepository = get())
    }
}