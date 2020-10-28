package com.rafaelm.disneymottionsmvvm.repository

import com.rafaelm.disneymottionsmvvm.database.PosterDao

class DetailRepository constructor(
    private val posterDao: PosterDao
) : Repository {
    fun getPosterById(id: Long) = posterDao.getPoster(id)
}