package com.rafaelm.disneymottionsmvvm.di

import com.rafaelm.disneymottionsmvvm.view.ui.details.PosterDetailViewModel
import com.rafaelm.disneymottionsmvvm.view.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel(get()) }

    viewModel { PosterDetailViewModel(get()) }
}
