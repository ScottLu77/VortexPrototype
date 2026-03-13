package com.vivotek.myprototype.uicomponent.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed


fun Modifier.clickable2(onClick: (() -> Unit)?): Modifier = composed {
    if (onClick != null) {
        val interactionSource = remember { MutableInteractionSource() }
        clickable(
            onClick = onClick,
            indication = null,
            interactionSource = interactionSource,
        )
    } else {
        this
    }
}