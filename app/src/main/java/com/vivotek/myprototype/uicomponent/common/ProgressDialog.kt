package com.vivotek.myprototype.uicomponent.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.vivotek.myprototype.R
import com.vivotek.myprototype.uicomponent.font.Caption
import com.vivotek.myprototype.uicomponent.font.H6

@Composable
fun ProgressDialog(
    title: String = "",
    message: String = "",
) {
    Dialog(
        properties = DialogProperties(
            dismissOnClickOutside = false,
            dismissOnBackPress = false,
        ),
        onDismissRequest = { },
    ) {
        Column(
            modifier = Modifier
                .semantics { testTagsAsResourceId = true }
                .testTag("fullScreenLoading"),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CircularProgressIndicator(
                color = colorResource(R.color.loading01),
            )
            if (title.isNotEmpty()) {
                Text(
                    modifier = Modifier.padding(top = 24.dp),
                    text = title,
                    style = H6,
                    color = colorResource(R.color.text09),
                )
            }
            if (message.isNotEmpty()) {
                Text(
                    modifier = Modifier.padding(top = 12.dp),
                    text = message,
                    style = Caption,
                    color = colorResource(R.color.text02_tmp),
                )
            }
        }
    }
}
