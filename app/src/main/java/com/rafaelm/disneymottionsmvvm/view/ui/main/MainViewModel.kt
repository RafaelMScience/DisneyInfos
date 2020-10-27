package com.rafaelm.disneymottionsmvvm.view.ui.main

import com.rafaelm.disneymottionsmvvm.base.LiveCoroutinesViewModel
import com.rafaelm.disneymottionsmvvm.repository.MainRepository

class MainViewModel constructor(
    private val mainRepository: MainRepository
) : LiveCoroutinesViewModel() {

}