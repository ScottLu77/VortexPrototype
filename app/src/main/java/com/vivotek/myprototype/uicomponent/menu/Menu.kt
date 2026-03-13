package com.vivotek.myprototype.uicomponent.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vivotek.myprototype.R
import com.vivotek.myprototype.uicomponent.common.Divider
import com.vivotek.myprototype.uicomponent.font.Body1
import com.vivotek.myprototype.uicomponent.font.H6
import com.vivotek.myprototype.multichannelv2.LayoutOption


data class MenuItem(
    val text: String,
    val icon: Int? = null,
    val specialColor: Int? = null,
    val onClick: () -> Unit,
)

@Composable
fun Menu(
    title: String,
    items: List<MenuItem>,
    selected: MenuItem? = null,
) {
    val lastIndex = remember { items.lastIndex }

    Column {
        MenuTitle(title)
        Divider(padding = 0.dp)
        items.forEachIndexed { index, item ->
            val isLast = index == lastIndex
            MenuRowItem(
                item,
                selected = selected == item,
                showDivider = !isLast,
            ) {
                item.onClick()
            }
        }
    }
}

@Composable
fun MenuTitle(
    title: String = "",
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 16.dp, 16.dp, 17.dp),
        text = title,
        style = H6,
        color = colorResource(R.color.text01),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun MenuRowItem(
    item: MenuItem,
    selected: Boolean,
    showDivider: Boolean,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(R.color.drop_surface01))
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent,
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                disabledElevation = 0.dp
            ),
            contentPadding = PaddingValues(0.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (item.icon != null) {
                    Image(
                        painter = painterResource(item.icon),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(28.dp),
                        contentScale = ContentScale.Fit,
                        colorFilter = ColorFilter.tint(colorResource(item.specialColor ?: R.color.icon15))
                    )
                }
                Text(
                    item.text,
                    modifier = Modifier.weight(1f),
                    style = Body1,
                    color = colorResource(item.specialColor ?: R.color.text01),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if (selected) {
                    Image(
                        painter = painterResource(R.drawable.ic_icon_general_check_solid),
                        contentDescription = "",
                        modifier = Modifier.size(28.dp),
                        contentScale = ContentScale.Fit,
                        colorFilter = ColorFilter.tint(colorResource(R.color.primary))
                    )
                }
            }
        }
        if (showDivider) {
            Divider(padding = 16.dp)
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewLayoutMenu() {
    val items = LayoutOption.entries.map {
        MenuItem(stringResource(it.textRes), it.icon,  onClick = {})
    }
    Menu(
        stringResource(R.string.layout_title),
        items,
        selected = items[3]
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewMoreMenu() {
    val items = listOf(
        MenuItem(stringResource(R.string.edit_name), R.drawable.icon_general_edit_line,  onClick = {}),
        MenuItem(stringResource(R.string.send_copy), R.drawable.icon_general_share_line,  onClick = {}),
        MenuItem(stringResource(R.string.delete), R.drawable.icon_general_delete_line, R.color.text_danger,  onClick = {}),
    )
    Menu(
        "Custom View",
        items
    )
}