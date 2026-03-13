package com.vivotek.myprototype.main.bottombar

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vivotek.myprototype.R
import com.vivotek.myprototype.uicomponent.common.Divider
import com.vivotek.myprototype.uicomponent.common.clickable2
import com.vivotek.myprototype.uicomponent.font.Button
import com.vivotek.myprototype.uicomponent.font.H6

@Composable
fun MoreTabsMenu(
    states: List<BottomTabState>,
    onTabClick: (BottomTabItem) -> Unit,
    onReorderTabsClick: () -> Unit,
) {
    Column {
        MenuTitleWithAction(
            stringResource(R.string.more_functions),
            stringResource(R.string.reorder),
            onReorderTabsClick
        )
        Divider(padding = 0.dp)

        LazyVerticalGrid(
            columns = GridCells.Fixed(4), // EXACT: 4 columns
            modifier = Modifier
                .wrapContentWidth() // EXACT: wrap_content (XML line 67)
                .wrapContentHeight(), // EXACT: wrap_content (XML line 68)
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(states) { state ->
                TabMenuItem(
                    tab = state.tab,
                    enabled = state.enabled,
                ) { if (state.enabled) onTabClick(state.tab) }
            }
        }
    }
}

@Composable
fun MenuTitleWithAction(
    title: String,
    actionText: String,
    actionOnClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 16.dp, 16.dp, 18.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            modifier = Modifier.weight(1f),
            style = H6,
            color = colorResource(R.color.text01),
            textAlign = TextAlign.Start,
        )

        Text(
            text = actionText,
            modifier = Modifier.clickable2(actionOnClick),
            style = Button,
            color = colorResource(R.color.primary),
            textAlign = TextAlign.End,
        )
    }
}

@Composable
fun TabMenuItem(
    tab: BottomTabItem,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    val alpha = if (enabled) 1f else 0.4f
    Column(
        modifier = Modifier
            .padding(top = 24.dp, bottom = 12.dp)
            .width(82.dp)
            .height(70.dp)
            .alpha(alpha)
            .clickable2(onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(tab.icon),
            contentDescription = "",
            modifier = Modifier
                .size(48.dp)
                .background(colorResource(R.color.primary), RoundedCornerShape(8.dp))
                .padding(10.dp),
            colorFilter = ColorFilter.tint(colorResource(R.color.icon05))
        )
        Text(
            stringResource(tab.title),
            modifier = Modifier
                .padding(top = 6.dp),
            color = colorResource(R.color.text01),
            fontSize = 11.sp,
            fontFamily = FontFamily.SansSerif,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewMoreTabsMenu() {
    MoreTabsMenu(
        BottomTabItem.entries.map { BottomTabState(it, true) },
        onTabClick = {},
        onReorderTabsClick = {},
    )
}