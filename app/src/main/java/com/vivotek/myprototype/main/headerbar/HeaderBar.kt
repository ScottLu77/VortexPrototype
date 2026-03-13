package com.vivotek.myprototype.main.headerbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vivotek.myprototype.R
import com.vivotek.myprototype.common.AvatarHelper
import com.vivotek.myprototype.uicomponent.font.H6
import com.vivotek.myprototype.uicomponent.common.clickable2
import com.vivotek.myprototype.uicomponent.common.Divider
import com.vivotek.myprototype.main.view.ViewMode

sealed class ActionButton {
    data class News(val onClick: () -> Unit) : ActionButton()
    data class Add(val onClick: () -> Unit) : ActionButton()
    data class Search(val onClick: () -> Unit) : ActionButton()
    data class Mode(val mode: ViewMode, val onClick: () -> Unit) : ActionButton()
    data class Alarm(val onClick: () -> Unit) : ActionButton()
    data class Snooze(val count: Int, val onClick: () -> Unit) : ActionButton()
    data class Archiving(val onClick: () -> Unit) : ActionButton()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderBar(
    title: String,
    orgName: String,
    buttons: List<ActionButton>,
    onAvatarClick: () -> Unit,
    outdatedFirmwareBanner: (@Composable () -> Unit)? = null,
    licenseBanner: (@Composable () -> Unit)? = null,
) {
    val density = LocalDensity.current
    val expansionHeightPx = with(density) { 48.dp.toPx() }
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        rememberTopAppBarState(initialHeightOffset = -expansionHeightPx)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(R.color.surface03))
            .semantics { testTagsAsResourceId = true }
    ) {
        MediumTopAppBar(
            title = {
                Text(
                    text = title,
                    style = H6,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            },
            navigationIcon = {
                // Organization avatar button
                OrganizationAvatar(
                    organizationName = orgName,
                    onClick = onAvatarClick
                )
            },
            actions = {
                buttons.forEach { button ->
                    when (button) {
                        is ActionButton.News -> ActionIcon(R.drawable.icon_status_notified, button.onClick, Color.Unspecified, "newsButton")
                        is ActionButton.Search -> ActionIcon(R.drawable.icon_general_search_line, button.onClick, testTag = "searchButton")
                        is ActionButton.Mode -> ActionIcon(
                            if (button.mode == ViewMode.List) R.drawable.icon_general_grid_solid else R.drawable.icon_general_list_solid,
                            button.onClick,
                            testTag = "changeLayout"
                        )
                        is ActionButton.Alarm -> ActionIcon(R.drawable.icon_general_alarm_management_solid, button.onClick, testTag = "alarmSettingsButton")
                        is ActionButton.Snooze -> SnoozeActionIcon(button.count, button.onClick)
                        is ActionButton.Add -> ActionIcon(R.drawable.icon_general_plus_line, button.onClick, testTag = "addButton")
                        is ActionButton.Archiving -> ActionIcon(R.drawable.icon_status_archiving_solid_normal_dark, button.onClick, Color.Unspecified, "archivingFilesButton")
                    }
                }
            },
            scrollBehavior = scrollBehavior,
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = colorResource(R.color.surface03),
                scrolledContainerColor = colorResource(R.color.surface03),
                titleContentColor = colorResource(R.color.text01)
            )
        )

        // Display license banner if provided
        licenseBanner?.invoke()

        // Display outdated firmware banner if provided
        outdatedFirmwareBanner?.invoke()

        // Bottom divider
        Divider(padding = 0.dp)
    }
}


@Composable
fun OrganizationAvatar(
    organizationName: String,
    onClick: () -> Unit
) {
    val avatarText = if (organizationName.isEmpty()) "" else organizationName.substring(0, 1)
    val avatarColor = AvatarHelper.shared.getOrgColor(organizationName)

    Box(
        modifier = Modifier
            .padding(horizontal = 18.dp)
            .size(28.dp)
            .background(
                color = Color(avatarColor),
                shape = CircleShape
            )
            .clickable2(onClick)
            .testTag("sideMenuButton"),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = avatarText,
            color = Color.White,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun ActionIcon(
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    tint: Color = colorResource(R.color.icon03),
    testTag: String? = null
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .padding(end = 6.dp)
            .size(44.dp)
            .padding(8.dp)
            .then(testTag?.let { Modifier.testTag(it) } ?: Modifier)
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = "News",
            tint = tint,
        )
    }
}

@Composable
fun SnoozeActionIcon(
    count: Int,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .padding(end = 6.dp)
            .size(44.dp)
            .testTag("snoozeRuleButton")
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 0.dp, top = 10.dp, end = 8.dp, bottom = 8.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_general_snooze_rules),
                contentDescription = "Snooze Rules",
                tint = colorResource(R.color.icon12),
                modifier = Modifier.fillMaxSize()
            )

            // Badge (only show if count > 0)
            if (count > 0) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = 4.dp, y = (-4).dp)
                        .background(
                            color = colorResource(R.color.primary),
                            shape = MaterialTheme.shapes.small
                        )
                        .padding(horizontal = 4.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = if (count > 99) "99+" else count.toString(),
                        color = colorResource(R.color.text09),
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}