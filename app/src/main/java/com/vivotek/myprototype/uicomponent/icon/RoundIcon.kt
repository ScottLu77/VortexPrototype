package com.vivotek.myprototype.uicomponent.icon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vivotek.myprototype.R


fun defaultIconColor(enabled: Boolean) = if (enabled) R.color.icon05 else R.color.icon02

@Composable
fun RoundIcon(
    icon: Int,
    size: Int = 44,
    padding: Int = 10,
    enabled: Boolean = true,
    iconColor: Int = remember(enabled) { defaultIconColor(enabled) },
    backgroundColor: Int = R.color.over_video_surface01,
    onClick: () -> Unit,
) {
    Button(
        enabled = enabled,
        onClick = onClick,
        modifier = Modifier
            .size(size.dp),
        shape = CircleShape,
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(backgroundColor),
        ),
        contentPadding = PaddingValues(padding.dp),
    ) {
        Icon(painterResource(icon), null, tint = colorResource(iconColor))
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewRoundIcon() {
    Row(
        modifier = Modifier
            .height(96.dp)
            .padding(6.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        RoundIcon(
            icon = R.drawable.icon_general_microphone_solid,
            backgroundColor = R.color.danger,
            onClick = {}
        )

        RoundIcon(
            icon = R.drawable.icon_general_fullscreen_1st_solid,
            onClick = {}
        )

        RoundIcon(
            icon = R.drawable.icon_general_play_1st_solid,
            size = 64,
            padding = 12,
            onClick = {}
        )

        RoundIcon(
            icon = R.drawable.icon_general_info_solid,
            32,
            8,
            iconColor = R.color.icon15,
            backgroundColor = R.color.surface02
        ) { }
    }
}