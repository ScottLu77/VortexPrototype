package com.vivotek.myprototype.uicomponent.button

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vivotek.myprototype.R
import com.vivotek.myprototype.uicomponent.font.Button
import com.vivotek.myprototype.uicomponent.common.ProgressSmall


@Composable
fun ButtonSolidMediumPrimary(
    modifier: Modifier = Modifier,
    text: String,
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

    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(36.dp),
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
            if (progressing) {
                ProgressSmall(
                    modifier = Modifier
                        .align(Alignment.Center),
                    color = colorResource(id = R.color.loading01).copy(alpha = 0.8f),
                )
            } else {
                Text(
                    text = text,
                    style = Button,
                    textAlign = TextAlign.Center,
                    color = textColor,
                )
            }
        }
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Composable
fun PreviewButtons03() {
    Column(
        modifier = Modifier.width(136.dp).padding(8.dp)
    ) {
        ButtonSolidMediumPrimary(
            text = "Button",
            onClick = {},
        )
        Spacer(Modifier.height(6.dp))
        ButtonSolidMediumPrimary(
            text = "Button",
            progressing = true,
            onClick = {},
        )
        Spacer(Modifier.height(6.dp))
        ButtonSolidMediumPrimary(
            text = "Button",
            enabled = false,
            onClick = {},
        )
    }
}