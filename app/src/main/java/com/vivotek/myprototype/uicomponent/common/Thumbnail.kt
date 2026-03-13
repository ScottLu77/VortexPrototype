package com.vivotek.myprototype.uicomponent.common

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.vivotek.myprototype.R


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Thumbnail(
    modifier: Modifier,
    model: Any
) {
    Box(
        modifier,
    ) {
        GlideImage(
            model = model,
            contentDescription = "",
            modifier = Modifier.align(Alignment.Center),
            contentScale = ContentScale.FillBounds,
            failure = placeholder(R.drawable.thumbnail_placeholder)
        )
    }
}