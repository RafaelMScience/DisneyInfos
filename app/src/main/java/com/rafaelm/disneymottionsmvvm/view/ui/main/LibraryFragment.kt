package com.rafaelm.disneymottionsmvvm.view.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rafaelm.disneymottionsmvvm.R
import com.rafaelm.disneymottionsmvvm.base.DatabindingFragment
import com.rafaelm.disneymottionsmvvm.databinding.FragmentLibraryBinding
import com.rafaelm.disneymottionsmvvm.view.adapter.PosterLineAdapter
import org.koin.android.viewmodel.ext.android.getSharedViewModel

class LibraryFragment : DatabindingFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentLibraryBinding>(inflater, R.layout.fragment_library, container).apply {
            viewModel = getSharedViewModel<MainViewModel>().apply { fetchDisneyPosterList() }
            lifecycleOwner = viewLifecycleOwner
            adapter = PosterLineAdapter()
        }.root
    }
}
