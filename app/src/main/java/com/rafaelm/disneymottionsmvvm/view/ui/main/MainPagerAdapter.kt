package com.rafaelm.disneymottionsmvvm.view.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainPagerAdapter(frag: FragmentActivity) : FragmentStateAdapter(frag) {

    private val fragmentsCreator: Map<Int, () -> Fragment> = mapOf(
        HOME to { HomeFragment() },
        LIBRARY to { LibraryFragment() },
        RADIO to { RadioFragment() }
    )

    override fun createFragment(position: Int): Fragment {
        return fragmentsCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

    override fun getItemCount(): Int = fragmentsCreator.size

    companion object {
        private const val HOME = 0
        private const val LIBRARY = 1
        private const val RADIO = 2
    }
}
