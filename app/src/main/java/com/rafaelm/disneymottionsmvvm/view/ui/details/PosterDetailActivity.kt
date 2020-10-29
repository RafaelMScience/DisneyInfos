package com.rafaelm.disneymottionsmvvm.view.ui.details

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.rafaelm.disneymottionsmvvm.R
import com.rafaelm.disneymottionsmvvm.base.DatabindingActivity
import com.rafaelm.disneymottionsmvvm.databinding.ActivityPosterDetailBinding
import com.rafaelm.disneymottionsmvvm.extensions.applyMaterialTransform
import com.rafaelm.disneymottionsmvvm.extensions.extraLong
import com.rafaelm.disneymottionsmvvm.model.Poster
import org.koin.android.viewmodel.ext.android.getViewModel

class PosterDetailActivity : DatabindingActivity() {

    private val binding: ActivityPosterDetailBinding by binding(R.layout.activity_poster_detail)
    private val posterId: Long by extraLong(posterKey)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val poster = getViewModel<PosterDetailViewModel>().getPoster(posterId)
        applyMaterialTransform(poster.name)
        binding.apply {
            this.poster = poster
            lifecycleOwner = this@PosterDetailActivity
            activity = this@PosterDetailActivity
            container = detailContainer
            fab = fabMore
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val posterKey = "posterKey"

        fun startActivityModel(context: Context?, startView: View, poster: Poster) {
            if (context is Activity) {
                val intent = Intent(context, PosterDetailActivity::class.java)
                intent.putExtra(
                    posterKey,
                    poster.id
                )
                val options = ActivityOptions.makeSceneTransitionAnimation(
                    context,
                    startView,
                    poster.name
                )
                context.startActivity(intent, options.toBundle())
            }
        }
    }
}