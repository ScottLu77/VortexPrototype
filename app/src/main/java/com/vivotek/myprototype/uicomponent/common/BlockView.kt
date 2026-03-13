package com.vivotek.myprototype.uicomponent.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import com.vivotek.myprototype.R


@Composable
fun BlockView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.block_view))
            .clickable2(null)
            .semantics { testTagsAsResourceId = true }
            .testTag("fullScreenBlock"),
    )
}