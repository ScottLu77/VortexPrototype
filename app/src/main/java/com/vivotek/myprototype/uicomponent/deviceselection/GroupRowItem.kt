package com.vivotek.myprototype.uicomponent.deviceselection

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vivotek.myprototype.R
import com.vivotek.myprototype.common.SiteState
import com.vivotek.myprototype.common.SiteType
import com.vivotek.myprototype.uicomponent.common.Divider
import com.vivotek.myprototype.uicomponent.common.StateCheckBox
import com.vivotek.myprototype.uicomponent.common.clickable2
import com.vivotek.myprototype.uicomponent.font.H6
import com.vivotek.myprototype.uicomponent.icon.GeneralIcon


@Composable
fun GroupRowItem(
    group: SiteState,
    onClick: () -> Unit,
    specialIcon: Int? = null,
    toggleState: State<ToggleableState>? = null,
    onToggleClick: (() -> Unit)? = null,
    showExpandIcon: Boolean = true,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(61.dp)
            .semantics { testTagsAsResourceId = true },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(R.color.surface02))
                .padding(top = 8.dp)
                .clickable2(onClick),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // Checkbox for multi-select mode, or spacer for simple mode
            if (toggleState != null) {
                StateCheckBox(
                    modifier = Modifier.padding(start = 8.dp),
                    state = toggleState.value,
                    onClick = onToggleClick,
                )
            } else {
                Spacer(Modifier.width(8.dp))
            }

            val groupIcon = specialIcon ?: group.icon
            Image(
                painter = painterResource(groupIcon),
                contentDescription = null,
                modifier = Modifier
                    .size(44.dp)
                    .padding(8.dp),
                colorFilter = ColorFilter.tint(colorResource(R.color.icon03))
            )

            val groupName = group.nameRes?.let { stringResource(it) } ?: group.name
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .testTag("groupName")
                    .weight(1f),
                text = groupName,
                style = H6,
                color = colorResource(R.color.text02),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            if (showExpandIcon) {
                val expandIcon = if (group.isExpand.value) {
                    R.drawable.icon_general_arrow_top_solid
                } else {
                    R.drawable.icon_general_arrow_bottom_solid
                }
                GeneralIcon(
                    modifier = Modifier.padding(end = 8.dp),
                    icon = expandIcon,
                ) {
                    group.isExpand.value = !group.isExpand.value
                }
            }
        }
        Divider(padding = 0.dp)
        Spacer(modifier = Modifier.height(8.dp))
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Composable
private fun PreviewGroupRowItemSimple() {
    val group = remember {
        SiteState(
            id = "group1",
            name = "Living Room Cameras",
            type = SiteType.Device,
            icon = R.drawable.icon_general_group_solid,
        )
    }
    GroupRowItem(
        group = group,
        onClick = {},
        specialIcon = R.drawable.icon_general_layout_4ch_line,
    )
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Composable
private fun PreviewGroupRowItemWithCheckbox() {
    val group = remember {
        SiteState(
            id = "group2",
            name = "Office Cameras with a Very Long Name That Should Truncate",
            type = SiteType.Device,
            icon = R.drawable.icon_general_group_solid,
        )
    }
    val toggleState = remember { mutableStateOf(ToggleableState.Indeterminate) }
    GroupRowItem(
        group = group,
        onClick = {},
        toggleState = toggleState,
        onToggleClick = {},
    )
}