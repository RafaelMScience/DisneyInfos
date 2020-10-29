package com.rafaelm.disneymottionsmvvm.di

import androidx.room.Room
import com.rafaelm.disneymottionsmvvm.R
import com.rafaelm.disneymottionsmvvm.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val persistenceModule = module {

    single {
        Room
            .databaseBuilder(
                androidApplication(),
                AppDatabase::class.java,
                androidApplication().getString(R.string.database)
            )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().posterDao() }
}
