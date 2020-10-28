package com.rafaelm.disneymottionsmvvm.view.adapter

import android.view.View
import com.rafaelm.disneymottionsmvvm.R
import com.rafaelm.disneymottionsmvvm.model.Poster
import com.rafaelm.disneymottionsmvvm.view.ui.viewholder.PosterViewHolder
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow

class PosterAdapter : BaseAdapter() {

    init {
        addSection(arrayListOf<Poster>())
    }

    fun addPosterList(posters: List<Poster>) {
        sections().first().run {
            clear()
            addAll(posters)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_poster

    override fun viewHolder(layout: Int, view: View) = PosterViewHolder(view)
}
