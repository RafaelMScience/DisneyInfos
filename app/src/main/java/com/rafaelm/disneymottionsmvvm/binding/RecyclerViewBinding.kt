package com.rafaelm.disneymottionsmvvm.binding

import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rafaelm.disneymottionsmvvm.model.Poster
import com.rafaelm.disneymottionsmvvm.view.adapter.PosterAdapter
import com.rafaelm.disneymottionsmvvm.view.adapter.PosterCircleAdapter
import com.rafaelm.disneymottionsmvvm.view.adapter.PosterLineAdapter
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.whatif.whatIfNotNullOrEmpty

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: BaseAdapter) {
    view.adapter = baseAdapter
}

@BindingAdapter("toast")
fun bindToast(view: RecyclerView, text: String?) {
    text.whatIfNotNullOrEmpty {
        Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
    }
}

@BindingAdapter("adapterPosterList")
fun bindAdapterPosterList(view: RecyclerView, posters: List<Poster>?) {
    posters.whatIfNotNullOrEmpty {
        (view.adapter as? PosterAdapter)?.addPosterList(it)
    }
}

@BindingAdapter("adapterPosterLineList")
fun bindAdapterPosterLineList(view: RecyclerView, posters: List<Poster>?) {
    posters.whatIfNotNullOrEmpty {
        (view.adapter as? PosterLineAdapter)?.addPosterList(it)
    }
}

@BindingAdapter("adapterPosterCircleList")
fun bindAdapterPosterCircleList(view: RecyclerView, posters: List<Poster>?) {
    posters.whatIfNotNullOrEmpty {
        (view.adapter as? PosterCircleAdapter)?.addPosterList(it)
    }
}

