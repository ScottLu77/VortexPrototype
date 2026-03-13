package com.vivotek.myprototype.main.bottombar

import android.content.res.Configuration
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vivotek.myprototype.R


@Composable
fun BottomBar(
    states: List<BottomTabState>,
    selectedTab: BottomTabItem,
    onSelect: (BottomTabItem) -> Unit
) {
    val maxVisibleTabs = 4
    val visibleStates = if (states.size > maxVisibleTabs) {
        states.take(maxVisibleTabs) + BottomTabState(BottomTabItem.More, true)
    } else {
        states
    }
    val selection = if (visibleStates.any { it.tab == selectedTab }) selectedTab else BottomTabItem.More

    BottomNavigation(
        modifier = Modifier
            .height(56.dp)
            .semantics { testTagsAsResourceId = true },
        backgroundColor = colorResource(R.color.surface03),
        contentColor = colorResource(R.color.text_primary),
    ) {
        visibleStates.forEach { state ->
            val tab = state.tab
            val enabled = state.enabled
            BottomNavigationItem(
                icon = {
                    Box {
                        Icon(
                            painter = painterResource(tab.icon),
                            contentDescription = null,
                            modifier = Modifier.size(28.dp)
                        )
                        if (tab == BottomTabItem.Archive && state.showBadge) {
                            ArchivingAnimationBadge()
                        }
                    }
                },
                label = {
                    Text(
                        text = stringResource(tab.title),
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                selected = selection == tab,
                onClick = { if (enabled) onSelect(tab) },
                enabled = enabled,
                selectedContentColor = if (enabled) colorResource(R.color.text_primary) else colorResource(R.color.text06),
                unselectedContentColor = if (enabled) colorResource(R.color.text05) else colorResource(R.color.text06),
                modifier = Modifier.testTag(tab.testTag)
            )
        }
    }
}

@Composable
private fun BoxScope.ArchivingAnimationBadge() {
    val infiniteTransition = rememberInfiniteTransition(label = "archiving")

    val alpha by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 400,
                delayMillis = 400,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "alpha"
    )

    val translateY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 10f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 800,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "translateY"
    )

    Icon(
        painter = painterResource(R.drawable.icon_general_bottom_solid),
        contentDescription = null,
        tint = colorResource(R.color.Green),
        modifier = Modifier
            .size(16.dp)
            .offset(x = 5.dp, y = (-1).dp)
            .align(Alignment.TopCenter)
            .graphicsLayer {
                translationY = translateY
            }
            .alpha(alpha)
            .testTag("archivingAnimation")
    )
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewBottomBar() {
    BottomBar(
        BottomTabItem.entries.map { BottomTabState(it, true) },
        BottomTabItem.View,
    ) {
    }
}