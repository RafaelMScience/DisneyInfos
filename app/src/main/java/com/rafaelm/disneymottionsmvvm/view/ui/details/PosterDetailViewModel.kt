package com.rafaelm.disneymottionsmvvm.view.ui.details

import com.rafaelm.disneymottionsmvvm.base.LiveCoroutinesViewModel
import com.rafaelm.disneymottionsmvvm.repository.DetailRepository

class PosterDetailViewModel (
    private val repository: DetailRepository
): LiveCoroutinesViewModel(){
    fun getPoster(id: Long) = repository.getPosterById(id)
}