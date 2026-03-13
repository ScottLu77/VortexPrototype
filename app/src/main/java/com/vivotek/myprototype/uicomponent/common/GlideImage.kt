package com.vivotek.myprototype.uicomponent.common

import android.graphics.drawable.Drawable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.vivotek.myprototype.R
import com.vivotek.myprototype.common.glide.S3CookieModel
import com.vivotek.myprototype.common.glide.S3Model
import java.io.File

@Composable
@OptIn(ExperimentalGlideComposeApi::class)
fun GlideImageView(modifier: Modifier = Modifier, model: S3Model, testTag: String = "") {
    val context = LocalContext.current
    val localeFile = remember(model.outPath) { File("${context.filesDir}/${model.outPath}") }
    var isResourceReady by remember { mutableStateOf(false) }

    GlideImage(
        model = if (localeFile.exists() && model.isLocalExpire(context).not()) localeFile else model,
        contentDescription = "",
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .testTag(testTag)
            .semantics { contentDescription = if (isResourceReady) "UAT_RESOURCE_READY" else "" },
        alignment = Alignment.Center,
        contentScale = ContentScale.Fit
    ) {
        it.error(R.drawable.thumbnail_placeholder)
            .placeholder(R.drawable.thumbnail_placeholder)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .addListener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    isResourceReady = false
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    isResourceReady = true
                    return false
                }
            })
    }
}


@Composable
@OptIn(ExperimentalGlideComposeApi::class)
fun GlideImageView(modifier: Modifier = Modifier, model: S3CookieModel, testTag: String = "") {
    val context = LocalContext.current
    val localFile = remember(model.outFilePath) { File("${context.filesDir}/${model.outFilePath}") }
    var isResourceReady by remember { mutableStateOf(false) }

    GlideImage(
        model = model,
        contentDescription = "",
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .testTag(testTag)
            .semantics { contentDescription = if (isResourceReady) "UAT_RESOURCE_READY" else "" },
        alignment = Alignment.Center,
        contentScale = ContentScale.Fit
    ) {
        it.error(R.drawable.thumbnail_placeholder)
            .placeholder(R.drawable.thumbnail_placeholder)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .addListener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    isResourceReady = false
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    isResourceReady = true
                    return false
                }
            })
    }
}