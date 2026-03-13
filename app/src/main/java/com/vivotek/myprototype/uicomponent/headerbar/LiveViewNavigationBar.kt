package com.vivotek.myprototype.uicomponent.headerbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vivotek.myprototype.R
import com.vivotek.myprototype.uicomponent.common.Divider
import com.vivotek.myprototype.uicomponent.font.H6
import com.vivotek.myprototype.uicomponent.icon.GeneralIcon


@Composable
fun LiveViewNavigationBarWithMenus(
    title: String,
    closeIcon: Int = R.drawable.icon_general_cross_line,
    showLiveIcon: Boolean = false,
    menuItems: List<MenuButton>,
    onClose: () -> Unit,
) {
    LiveViewNavigationBar(
        title = title,
        closeIcon = closeIcon,
        showLiveIcon = showLiveIcon,
        actionView = {
            menuItems.forEach {
                GeneralIcon(
                    modifier = Modifier.padding(start = 8.dp),
                    icon = it.icon,
                    enabled = it.enabled,
                    specialColor = it.specialColor,
                    onClick = it.onClick
                )
            }
        },
        onClose = onClose,
    )
}

@Composable
fun LiveViewNavigationBar(
    title: String,
    closeIcon: Int = R.drawable.icon_general_cross_line,
    showLiveIcon: Boolean = false,
    actionView: (@Composable () -> Unit)? = null,
    onClose: () -> Unit,
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(57.dp)
                .background(colorResource(R.color.surface03))
                .padding(horizontal = 8.dp)
                .semantics { testTagsAsResourceId = true },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            GeneralIcon(
                modifier = Modifier.padding(end = 8.dp),
                icon = closeIcon,
                onClick = onClose,
            )
            if (showLiveIcon) {
                Image(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .width(36.dp)
                        .height(18.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.icon_status_hint_live_1st_line_dark),
                    contentDescription = "",
                )
            }
            Text(
                text = title,
                modifier = Modifier.weight(1f),
                style = H6,
                color = colorResource(R.color.text01),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            actionView?.invoke()
        }
        Divider(padding = 0.dp)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewNavCloseWithMenus() {
    Column {
        LiveViewNavigationBarWithMenus(
            title = ".VIVOTEK USA VORTEX Connect NY",
            showLiveIcon = true,
            menuItems = listOf(
                MenuButton(R.drawable.icon_general_layout_4ch_line, true, onClick = {}),
                MenuButton(R.drawable.icon_general_more_solid, true, onClick = {})
            ),
            onClose = {}
        )

        LiveViewNavigationBarWithMenus(
            title = "Camera 01",
            menuItems = listOf(
                MenuButton(R.drawable.icon_general_layout_4ch_line, true, onClick = {}),
                MenuButton(R.drawable.icon_general_more_solid, true, onClick = {})
            ),
            onClose = {}
        )
    }
}