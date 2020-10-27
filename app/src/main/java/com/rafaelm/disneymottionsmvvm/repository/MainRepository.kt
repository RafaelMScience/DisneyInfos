package com.rafaelm.disneymottionsmvvm.repository

import androidx.annotation.WorkerThread
import com.rafaelm.disneymottionsmvvm.database.PosterDao
import com.rafaelm.disneymottionsmvvm.model.Poster
import com.rafaelm.disneymottionsmvvm.network.DisneyService
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import com.skydoves.whatif.whatIfNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

class MainRepository constructor(
    private val disneyService: DisneyService,
    private val posterDAO: PosterDao
) : Repository {

    init {
        Timber.d("Injection MainRepository")
    }

    @WorkerThread
    suspend fun loadDisneyPosters(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val posters: List<Poster> = posterDAO.getPosterList()
        if (posters.isEmpty()) {
            //conection api
            disneyService.fetchDisneyPosterList().apply {
                // handle the case when the API request gets a success response.
                this.suspendOnSuccess {
                    data.whatIfNotNull {
                        posterDAO.insertPosterList(it)
                        emit(it)
                        onSuccess()
                    }
                }
            }
                // handle the case when the API request gets an error response.
                // e.g. internal server error.
                .onError {
                    onError(message())
                }
                // handle the case when the API request gets an exception response.
                // e.g. network connection error.
                .onException {
                    onError(message())
                }
        } else {
            emit(posters)
            onSuccess()
        }
    }.flowOn(Dispatchers.IO)
}