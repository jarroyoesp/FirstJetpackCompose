package com.jarroyo.firstjetpackcompose.ui.compose

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.preferredSizeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.loadImageResource
import androidx.compose.ui.res.loadVectorResource
import androidx.compose.ui.unit.dp


/*
@Composable
fun ImageResource(@DrawableRes resId: Int) {
    // There are multiple methods available to load an image resource in Compose. However, it would
    // be advisable to use the loadImageResource method as it loads an image resource asynchronously
    val image = loadVectorResource(resId)
    image.resource.resource?.let {
        // Image is a pre-defined composable that lays out and draws a given [ImageAsset].
        Log.d("ImageResource", "Loading image")
        // You can think of Modifiers as implementations of the decorators pattern that are
        // used to modify the composable that its applied to. In this example, we configure the
        // Image composable to have a height of 200 dp.
        Image(asset = it,
            modifier = Modifier.preferredSizeIn(maxHeight = 200.dp)
                .fillMaxWidth())
    }
}*/
