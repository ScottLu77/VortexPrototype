package com.vivotek.myprototype.uicomponent.settings

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vivotek.myprototype.R
import com.vivotek.myprototype.uicomponent.common.Divider
import com.vivotek.myprototype.uicomponent.common.StateSwitch
import com.vivotek.myprototype.uicomponent.common.clickable2
import com.vivotek.myprototype.uicomponent.font.Body1
import com.vivotek.myprototype.uicomponent.font.Subtitle2


@Composable
fun SettingsHeader(
    text: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
    ) {
        Text(
            text,
            modifier = Modifier.align(Alignment.BottomStart),
            style = Subtitle2,
            color = colorResource(R.color.text05),
        )
    }
}

@Composable
fun SettingsRowItem(
    text: String,
    valueText: String? = null,
    valueColor: Int? = null,
    testTag: String = "",
    enabled: Boolean = true,
    showDivider: Boolean = true,
    onClick: () -> Unit,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(colorResource(R.color.surface03))
            .semantics { testTagsAsResourceId = true }
    ) {
        Button(
            onClick = onClick,
            enabled = enabled,
            modifier = Modifier
                .alpha(if (enabled) 1.0f else 0.5f)
                .fillMaxWidth()
                .height(48.dp)
                .background(colorResource(R.color.transparent))
                .testTag(testTag),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.transparent),
                contentColor = colorResource(R.color.transparent),
                disabledContainerColor = colorResource(R.color.transparent),
                disabledContentColor = colorResource(R.color.transparent),
            ),
            border = null,
            elevation = null,
            contentPadding = PaddingValues(0.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Text(
                    text,
                    modifier = Modifier.weight(1f),
                    style = Body1,
                    color = colorResource(R.color.text02),
                    maxLines = 1,
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                )
                if (valueText != null) {
                    Text(
                        valueText,
                        modifier = Modifier.testTag("description"),
                        style = Body1,
                        color = colorResource(R.color.text03),
                        textAlign = TextAlign.End,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                } else if (valueColor != null) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .padding(8.dp)
                            .border(1.dp, colorResource(R.color.outline01), shape = CircleShape)
                            .background(colorResource(valueColor), shape = CircleShape),
                    )
                }
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(R.drawable.icon_general_arrow_right_solid),
                    colorFilter = ColorFilter.tint(colorResource(R.color.icon02)),
                    contentDescription = "",
                )
            }
        }

        if (showDivider) {
            Divider(padding = 16.dp)
        }
    }
}

@Composable
fun SettingsWithSwitch(
    text: String,
    icon: Int? = null,
    checked: Boolean = false,
    enabled: Boolean = true,
    testTag: String = "",
    showDivider: Boolean = true,
    onCheckedChange: (Boolean) -> Unit,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(colorResource(R.color.surface03))
            .semantics { testTagsAsResourceId = true }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            if (icon != null) {
                Image(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(icon),
                    colorFilter = ColorFilter.tint(colorResource(if (enabled) R.color.icon02 else R.color.icon01)),
                    contentDescription = "",
                )
            }
            Text(
                text,
                modifier = Modifier.weight(1f),
                style = Body1,
                color = colorResource(if (enabled) R.color.text02 else R.color.text06),
                maxLines = 1,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis,
            )
            StateSwitch(
                checked = checked,
                enabled = enabled,
                testTag = testTag,
                onCheckedChange = onCheckedChange,
            )
        }

        if (showDivider) {
            Divider(padding = 16.dp)
        }
    }
}

@Composable
fun SettingsButton(
    text: String,
    textColor: Int,
    testTag: String = "",
    showDivider: Boolean = true,
    onClick: () -> Unit,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(colorResource(R.color.surface03))
            .semantics { testTagsAsResourceId = true }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(colorResource(R.color.surface03))
                .testTag(testTag)
                .clickable2(onClick),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = text,
                style = Body1,
                color = colorResource(textColor),
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        if (showDivider) {
            Divider(padding = 16.dp)
        }
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Composable
fun PreviewSettingsRowItem() {
    Column(
        modifier = Modifier.background(colorResource(R.color.surface02))
    ) {
        SettingsHeader(stringResource(R.string.Device))
        SettingsRowItem(stringResource(R.string.device_name), "UAT") { }
        SettingsRowItem(stringResource(R.string.firmware_version), showDivider = false) { }
        SettingsHeader(stringResource(R.string.Attribute_search))
        SettingsRowItem(stringResource(R.string.Gender), "Any") { }
        SettingsRowItem(stringResource(R.string.Upper_body_clothing_color), valueColor = R.color.Orange, showDivider = false) { }
        SettingsHeader(stringResource(R.string.Search_accessories))
        SettingsWithSwitch(stringResource(R.string.Backpack), R.drawable.icon_general_bag_line, true) { }
        SettingsWithSwitch(stringResource(R.string.Hat), R.drawable.icon_general_hat_line, showDivider = false) { }
        Spacer(modifier = Modifier.height(56.dp))
        SettingsButton("Reboot this device", R.color.text_primary) {}
        SettingsButton("Restore settings to factory default", R.color.danger, showDivider = false) {}
    }
}