package com.vivotek.myprototype.uicomponent.common

import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import com.vivotek.myprototype.R


@Composable
fun StateSwitch(
    checked: Boolean = false,
    enabled: Boolean = true,
    testTag: String = "",
    onCheckedChange: (Boolean) -> Unit,
) {
    Switch(
        modifier = Modifier.testTag(testTag),
        checked = checked,
        enabled = enabled,
        onCheckedChange = onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedThumbColor = colorResource(id = R.color.primary),
            checkedTrackColor = colorResource(id = R.color.primary_track),
            uncheckedThumbColor = colorResource(id = R.color.thumb_tint_unchecked),
            uncheckedTrackColor = colorResource(id = R.color.track_tint_unchecked),
            disabledCheckedThumbColor = colorResource(id = R.color.switch_surface01),
            disabledCheckedTrackColor = colorResource(id = R.color.primary).copy(alpha = 0.18f),
            disabledUncheckedThumbColor = colorResource(id = R.color.switch_surface02),
            disabledUncheckedTrackColor = colorResource(id = R.color.surface19).copy(alpha = 0.18f),
        ),
    )
}