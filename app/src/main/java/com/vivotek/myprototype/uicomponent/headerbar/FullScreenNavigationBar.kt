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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vivotek.myprototype.R
import com.vivotek.myprototype.uicomponent.font.H6
import com.vivotek.myprototype.uicomponent.icon.GeneralIcon


@Composable
fun FullScreenLiveViewNavigationBarWithMenus(
    title: String,
    closeIcon: Int = R.drawable.icon_general_cross_line,
    showLiveIcon: Boolean = false,
    menuItems: List<MenuButton>,
    onClose: () -> Unit,
) {
    FullScreenLiveViewNavigationBar(
        title = title,
        closeIcon = closeIcon,
        showLiveIcon = showLiveIcon,
        actionView = {
            menuItems.forEach {
                GeneralIcon(
                    modifier = Modifier.padding(start = 8.dp),
                    icon = it.icon,
                    enabled = it.enabled,
                    specialColor = R.color.icon05,
                    onClick = it.onClick
                )
            }
        },
        onClose = onClose,
    )
}

@Composable
fun FullScreenLiveViewNavigationBar(
    title: String,
    closeIcon: Int = R.drawable.icon_general_cross_line,
    showLiveIcon: Boolean = false,
    actionView: (@Composable () -> Unit)? = null,
    onClose: () -> Unit,
) {
    Row(
        modifier = Modifier
            .height(38.dp)
            .fillMaxWidth()
            .semantics { testTagsAsResourceId = true }
            .background(colorResource(R.color.bars_navbar_landscape_h6))
            .padding(horizontal = 60.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        GeneralIcon(
            modifier = Modifier.padding(end = 8.dp),
            icon = closeIcon,
            onClick = onClose,
            specialColor = R.color.icon05
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
            color = colorResource(R.color.white),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        actionView?.invoke()
    }
}


@Preview(showBackground = true, device = Devices.NEXUS_6P, widthDp = 1024, apiLevel = 33)
@Composable
fun PreviewFullScreenLiveViewNavigationBarWithMenus() {
    FullScreenLiveViewNavigationBarWithMenus(
        title = ".VIVOTEK USA VORTEX Connect NY",
        showLiveIcon = true,
        menuItems = listOf(
            MenuButton(R.drawable.icon_general_exports_archive_line, true, onClick = {}),
            MenuButton(R.drawable.icon_general_more_solid, true, onClick = {}),
        ),
        onClose = {}
    )
}