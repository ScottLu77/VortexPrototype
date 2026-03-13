package com.vivotek.myprototype.uicomponent.button

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vivotek.myprototype.R
import com.vivotek.myprototype.uicomponent.common.Divider
import com.vivotek.myprototype.uicomponent.common.ProgressSmall
import com.vivotek.myprototype.uicomponent.font.Button

@Composable
fun ButtonSolidLargePrimary(
    modifier: Modifier = Modifier,
    text: String,
    progressText: String = text,
    enabled: Boolean = true,
    progressing: Boolean = false,
    onClick: () -> Unit
) {
    val backgroundColor = when {
        progressing -> colorResource(R.color.primary_active)
        enabled -> colorResource(R.color.primary)
        else -> colorResource(R.color.surface06)
    }
    val textColor = if (enabled) colorResource(R.color.text09) else colorResource(R.color.text07)
    val displayText = if (progressing) progressText else text

    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        enabled = enabled && !progressing,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, SolidColor(backgroundColor)),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor,
            disabledContainerColor = backgroundColor,
            disabledContentColor = textColor
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        )
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = displayText,
                style = Button,
                textAlign = TextAlign.Center,
                color = textColor,
            )
            if (progressing) {
                ProgressSmall(
                    modifier = Modifier
                        .padding(end = 13.dp)
                        .align(Alignment.CenterEnd),
                    color = colorResource(id = R.color.loading01).copy(alpha = 0.8f),
                )
            }
        }
    }
}

@Composable
fun ButtonGhostLargeSecondary(
    modifier: Modifier = Modifier,
    text: String,
    progressText: String = text,
    enabled: Boolean = true,
    progressing: Boolean = false,
    onClick: () -> Unit
) {
    val borderColor = when {
        progressing -> colorResource(R.color.outline18)
        enabled -> colorResource(R.color.outline01)
        else -> colorResource(R.color.outline04)
    }
    val textColor = if (enabled) colorResource(R.color.text01) else colorResource(R.color.text06)
    val displayText = if (progressing) progressText else text

    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        enabled = enabled && !progressing,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, SolidColor(borderColor)),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = textColor,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = textColor
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        )
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = displayText,
                style = Button,
                textAlign = TextAlign.Center,
                color = textColor
            )
            if (progressing) {
                ProgressSmall(
                    modifier = Modifier
                        .padding(end = 13.dp)
                        .align(Alignment.CenterEnd),
                    color = colorResource(id = R.color.loading01).copy(alpha = 0.8f),
                )
            }
        }
    }
}

@Composable
fun ButtonIconGhostLargeSecondary(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes iconRes: Int = R.drawable.icon_general_plus_line,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val borderColor = if (enabled) colorResource(R.color.outline01) else colorResource(R.color.surface04)
    val textColor = if (enabled) colorResource(R.color.text01) else colorResource(R.color.text06)

    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, borderColor),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = textColor,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = textColor
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        )
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(iconRes),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = textColor
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = text,
                    style = Button,
                    textAlign = TextAlign.Center,
                    color = textColor
                )
            }
        }
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Composable
fun PreviewButtons01() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        ButtonSolidLargePrimary(
            text = "Button",
            progressText = "Loading",
            onClick = {},
        )
        ButtonSolidLargePrimary(
            text = "Button",
            progressText = "Loading",
            enabled = false,
            onClick = {},
        )
        Spacer(Modifier.height(6.dp))
        Divider(padding = 0.dp)
        Spacer(Modifier.height(6.dp))
        ButtonGhostLargeSecondary(
            text = "Button",
            progressText = "Loading",
            onClick = {},
        )
        ButtonGhostLargeSecondary(
            text = "Button",
            progressText = "Loading",
            enabled = false,
            onClick = {},
        )
        Spacer(Modifier.height(6.dp))
        Divider(padding = 0.dp)
        Spacer(Modifier.height(6.dp))
        ButtonIconGhostLargeSecondary(
            text = "Button",
            onClick = {},
        )
        ButtonIconGhostLargeSecondary(
            text = "Button",
            enabled = false,
            onClick = {},
        )
    }
}