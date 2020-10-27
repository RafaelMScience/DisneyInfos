package com.rafaelm.disneymottionsmvvm.view.ui.main

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import com.rafaelm.disneymottionsmvvm.base.LiveCoroutinesViewModel
import com.rafaelm.disneymottionsmvvm.model.Poster
import com.rafaelm.disneymottionsmvvm.repository.MainRepository
import timber.log.Timber

class MainViewModel constructor(
    private val mainRepository: MainRepository
) : LiveCoroutinesViewModel() {

    private var posterFetchingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    var posterListLiveData: LiveData<List<Poster>>

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _toastLiveData: MutableLiveData<String> = MutableLiveData()
    val toastLiveData: LiveData<String> get() = _toastLiveData

    init {
        Timber.d("injection MainViewModel")

        posterListLiveData = posterFetchingLiveData.switchMap {
            _isLoading.postValue(true)
            launchOnViewModelScope {
                this.mainRepository.loadDisneyPosters(
                    onSuccess = { _isLoading.postValue(true) },
                    onError = { _toastLiveData.postValue(it) }
                ).asLiveData()
            }
        }
    }

    @MainThread
    fun fetchDisneyPosterList() {
        posterFetchingLiveData.value = false
    }
}