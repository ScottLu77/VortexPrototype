package com.vivotek.myprototype.uicomponent.common

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vivotek.myprototype.R

private const val DisabledAlpha = 0.38f

@Composable
fun CheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Checkbox(
        modifier = modifier.size(44.dp, 44.dp),
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = CheckboxDefaults.colors(
            checkedColor = colorResource(id = R.color.icon06),
            uncheckedColor = colorResource(id = R.color.icon02),
            checkmarkColor = colorResource(id = R.color.icon05),
            disabledCheckedColor = colorResource(id = R.color.icon06).copy(alpha = DisabledAlpha),
            disabledUncheckedColor = colorResource(id = R.color.icon02).copy(alpha = DisabledAlpha),
        ),
    )
}

@Composable
fun StateCheckBox(
    modifier: Modifier = Modifier,
    state: ToggleableState,
    onClick: (() -> Unit)? = null,
) {
    TriStateCheckbox(
        modifier = modifier.size(44.dp, 44.dp),
        state = state,
        onClick = onClick,
        colors = CheckboxDefaults.colors(
            checkedColor = colorResource(id = R.color.icon06),
            uncheckedColor = colorResource(id = R.color.icon02),
            checkmarkColor = colorResource(id = R.color.icon05),
            disabledCheckedColor = colorResource(id = R.color.icon06).copy(alpha = DisabledAlpha),
            disabledUncheckedColor = colorResource(id = R.color.icon02).copy(alpha = DisabledAlpha),
        ),
    )
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Composable
fun PreviewCheckBox() {
    Row(
        modifier = Modifier.background(colorResource(R.color.surface02)),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        CheckBox(checked = false) {}
        CheckBox(checked = true) {}
        StateCheckBox(state = ToggleableState.Indeterminate) {}
        StateCheckBox(state = ToggleableState.Off) {}
        StateCheckBox(state = ToggleableState.On) {}
    }
}