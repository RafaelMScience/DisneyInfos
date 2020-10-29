package com.rafaelm.disneymottionsmvvm.di

import com.rafaelm.disneymottionsmvvm.repository.DetailRepository
import com.rafaelm.disneymottionsmvvm.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { MainRepository(get(), get()) }

    single { DetailRepository(get()) }
}
