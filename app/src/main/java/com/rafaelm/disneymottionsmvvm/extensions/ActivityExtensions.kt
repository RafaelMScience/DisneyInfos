package com.rafaelm.disneymottionsmvvm.extensions

import android.content.Context
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.rafaelm.disneymottionsmvvm.R

/** get a material container arc transform. */
internal fun getContentTransform(context: Context): MaterialContainerTransform{
    return MaterialContainerTransform().apply {
        addTarget(android.R.id.content)
        duration = 450
        pathMotion = MaterialArcMotion()
        isElevationShadowEnabled = true
        startElevation = 9f
        endElevation =9f
        startContainerColor = ContextCompat.getColor(context, R.color.colorPrimary)
    }
}

/** apply material exit container transformation. */
fun AppCompatActivity.applyExitMaterialTransform() {
    window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
    setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
    window.sharedElementsUseOverlay = false
}

/** returns a long value from intent's extra data.  */
fun ComponentActivity.extraLong(key: String): Lazy<Long> {
    return lazy { requireNotNull(intent.getLongExtra(key, -1).takeIf { it != 1L }) }
}

/** apply material entered container transformation. */
fun AppCompatActivity.applyMaterialTransform(transitionName : String){
    window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
    ViewCompat.setTransitionName(findViewById(android.R.id.content), transitionName)

    // set up shared element transition
    setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
    window.sharedElementEnterTransition = getContentTransform(this)
    window.sharedElementReturnTransition = getContentTransform(this)
}