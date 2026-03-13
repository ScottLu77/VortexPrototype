package com.vivotek.myprototype.uicomponent.icon

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vivotek.myprototype.R
import com.vivotek.myprototype.uicomponent.font.Button


@Composable
fun TextIcon(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    Button(
        enabled = enabled,
        onClick = onClick,
        modifier = modifier.width(64.dp),
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            colorResource(R.color.transparent),
            colorResource(R.color.transparent),
            colorResource(R.color.transparent),
            colorResource(R.color.transparent)
        ),
        contentPadding = PaddingValues(0.dp),
    ) {
        Text(
            text = text,
            style = Button,
            color = if (enabled) colorResource(R.color.text_primary) else colorResource(R.color.text06),
        )
    }
}

@Composable
fun GeneralIcon(
    modifier: Modifier = Modifier,
    icon: Int,
    enabled: Boolean = true,
    specialColor: Int? = null,
    testTag: String = "",
    onClick: () -> Unit,
) {
    Button(
        enabled = enabled,
        onClick = onClick,
        modifier = modifier
            .size(44.dp)
            .testTag(testTag),
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            colorResource(R.color.transparent),
            colorResource(R.color.transparent),
            colorResource(R.color.transparent),
            colorResource(R.color.transparent)
        ),
        contentPadding = PaddingValues(0.dp),
    ) {
        Icon(painterResource(icon), null, Modifier.size(28.dp), colorResource(specialColor ?: R.color.icon15))
    }
}

@Composable
fun LargeIcon(
    modifier: Modifier = Modifier,
    icon: Int,
    enabled: Boolean = true,
    specialColor: Int? = null,
    testTag: String = "",
    onClick: () -> Unit,
) {
    Button(
        enabled = enabled,
        onClick = onClick,
        modifier = modifier
            .size(44.dp)
            .testTag(testTag),
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            colorResource(R.color.transparent),
            colorResource(R.color.transparent),
            colorResource(R.color.transparent),
            colorResource(R.color.transparent)
        ),
        contentPadding = PaddingValues(0.dp),
    ) {
        Icon(painterResource(icon), null, Modifier.size(36.dp), colorResource(specialColor ?: R.color.icon15))
    }
}