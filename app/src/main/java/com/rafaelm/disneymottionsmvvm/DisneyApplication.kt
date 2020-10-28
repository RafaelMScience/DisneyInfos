package com.rafaelm.disneymottionsmvvm

import android.app.Application
import com.rafaelm.disneymottionsmvvm.di.networkModule
import com.rafaelm.disneymottionsmvvm.di.persistenceModule
import com.rafaelm.disneymottionsmvvm.di.repositoryModule
import com.rafaelm.disneymottionsmvvm.di.viewModelModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class DisneyApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@DisneyApplication)
            modules(networkModule)
            modules(persistenceModule)
            modules(repositoryModule)
            modules(viewModelModule)
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}