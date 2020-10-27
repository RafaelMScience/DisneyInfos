package com.rafaelm.disneymottionsmvvm.view.ui.viewholder

import android.view.View
import androidx.core.view.ViewCompat
import com.rafaelm.disneymottionsmvvm.databinding.ItemPosterBinding
import com.rafaelm.disneymottionsmvvm.model.Poster
import com.skydoves.baserecyclerviewadapter.BaseViewHolder

class PosterViewHolder (view: View):BaseViewHolder(view){
    private lateinit var data: Poster
    private val binding : ItemPosterBinding by bindings(view)
    override fun bindData(data: Any) {
        if(data is Poster){
            this.data = data
            drawItemUI()
        }
    }

    private fun drawItemUI(){
        binding.apply {
            ViewCompat.setTransitionName(binding.itemContainer, data.name)
            poster = data
            executePendingBindings()
        }
    }

    override fun onClick(p0: View?) =
        PosterDetailsActivity.startActivityModel(context(), binding.itemContainer, data)

    override fun onLongClick(p0: View?) = false
}