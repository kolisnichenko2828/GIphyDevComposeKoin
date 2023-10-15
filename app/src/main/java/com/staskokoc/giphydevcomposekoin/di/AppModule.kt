package com.staskokoc.giphydevcomposekoin.di

import com.staskokoc.giphydevcomposekoin.presentation.activities.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(getGifsUsecase = get())
    }
}