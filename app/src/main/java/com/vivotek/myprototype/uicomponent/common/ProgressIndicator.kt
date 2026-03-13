package com.vivotek.myprototype.uicomponent.common

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.vivotek.myprototype.R


@Composable
fun ProgressLarge(
    modifier: Modifier = Modifier,
    color: Color = colorResource(id = R.color.surface02),
) {
    CircularProgressIndicator(
        modifier = modifier.size(44.dp),
        color = color,
        strokeWidth = 2.dp,
    )
}

@Composable
fun ProgressSmall(
    modifier: Modifier = Modifier,
    color: Color = colorResource(id = R.color.surface02),
) {
    CircularProgressIndicator(
        modifier = modifier.size(24.dp),
        color = color,
        strokeWidth = 2.dp,
    )
}