package com.vivotek.myprototype.uicomponent.headerbar

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vivotek.myprototype.R
import com.vivotek.myprototype.uicomponent.common.Divider
import com.vivotek.myprototype.uicomponent.font.H6
import com.vivotek.myprototype.uicomponent.icon.GeneralIcon
import com.vivotek.myprototype.uicomponent.icon.TextIcon

val navigationBarDefaultHeight = 57.dp

data class ApplyButton(
    val text: String,
    val enabled: Boolean,
    val onClick: () -> Unit
)

data class MenuButton(
    val icon: Int,
    val enabled: Boolean,
    val specialColor: Int? = null,
    val onClick: () -> Unit
)

@Composable
fun NavigationBarWithApply(
    title: String,
    closeIcon: Int = R.drawable.icon_general_cross_line,
    applyButton: ApplyButton,
    onClose: () -> Unit,
) {
    NavigationBar(
        title = title,
        closeIcon = closeIcon,
        actionView = {
            TextIcon(
                text = applyButton.text,
                enabled = applyButton.enabled,
                onClick = applyButton.onClick,
            )
        },
        onClose = onClose,
    )
}

@Composable
fun NavigationBarWithMenus(
    title: String,
    closeIcon: Int = R.drawable.icon_general_cross_line,
    backgroundColor: Int = R.color.surface03,
    underline: Boolean = true,
    menuItems: List<MenuButton>,
    onClose: () -> Unit,
) {
    NavigationBar(
        title = title,
        closeIcon = closeIcon,
        backgroundColor = backgroundColor,
        underline = underline,
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
fun NavigationBar(
    title: String,
    closeIcon: Int = R.drawable.icon_general_cross_line,
    enableClose: Boolean = true,
    backgroundColor: Int = R.color.surface03,
    underline: Boolean = true,
    actionView: (@Composable () -> Unit)? = null,
    onClose: () -> Unit,
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(57.dp)
                .background(colorResource(backgroundColor))
                .padding(horizontal = 8.dp)
                .semantics { testTagsAsResourceId = true },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            GeneralIcon(
                modifier = Modifier.padding(end = 8.dp),
                icon = closeIcon,
                enabled = enableClose,
                onClick = onClose,
                testTag = "closeButton",
            )
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
        if (underline) {
            Divider(padding = 0.dp)
        }
    }
}

// =============================================================================
// Convenience Helpers
// =============================================================================

@Composable
fun NavBarClose(title: String, onClose: () -> Unit) {
    NavigationBar(title, onClose = onClose)
}

@Composable
fun NavBarBack(title: String, onBack: () -> Unit) {
    NavigationBar(title, R.drawable.icon_general_left_line, onClose = onBack)
}

@Composable
fun NavBarCloseSave(title: String, onClose: () -> Unit, enable: Boolean = true, onSave: () -> Unit) {
    NavigationBarWithApply(
        title = title,
        applyButton = ApplyButton(stringResource(R.string.save), enable, onSave),
        onClose = onClose
    )
}

@Composable
fun NavBarBackSave(title: String, onBack: () -> Unit, enable: Boolean = true, onSave: () -> Unit) {
    NavigationBarWithApply(
        title = title,
        closeIcon = R.drawable.icon_general_left_line,
        applyButton = ApplyButton(stringResource(R.string.save), enable, onSave),
        onClose = onBack
    )
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Composable
fun PreviewHeaderBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(R.color.surface02))
    ) {
        NavigationBar("Filter") {}
        NavigationBar("Archiving files", R.drawable.icon_general_left_line) {}
        NavigationBarWithApply("Device name", R.drawable.icon_general_left_line, ApplyButton("Save", true) {}) {}
        NavigationBarWithMenus(
            "",
            menuItems = listOf(
                MenuButton(R.drawable.icon_general_feedback_line, true, onClick = {}),
                MenuButton(R.drawable.icon_general_pause_alarm_line, true, R.color.alert, onClick = {}),
            )
        ) {}

        NavigationBarWithMenus(
            "Add device",
            menuItems = listOf(
                MenuButton(R.drawable.icon_general_qr_code_solid, true, onClick = {}),
            ),
            backgroundColor = R.color.transparent,
            underline = false,
        ) {}
    }
}