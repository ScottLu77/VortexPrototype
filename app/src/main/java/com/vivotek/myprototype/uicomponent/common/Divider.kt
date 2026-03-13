package com.vivotek.myprototype.uicomponent.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vivotek.myprototype.R

@Composable
fun Divider(padding: Dp = 16.dp) {
    Divider(
        modifier = Modifier
            .background(color = colorResource(R.color.surface03))
            .padding(padding, 0.dp),
        color = colorResource(id = R.color.line01),
    )
}