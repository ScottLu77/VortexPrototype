package com.vivotek.myprototype.main.headerbar

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.vivotek.myprototype.R

enum class HeaderBarIcon(
    @DrawableRes val icon: Int,
    val testTag: String,
) {
    News(R.drawable.icon_status_notified, "newsButton"),
    Search(R.drawable.icon_general_search_line, "searchButton"),
    Mode(R.drawable.icon_general_grid_solid, "changeLayout"),
    Alarm(R.drawable.icon_general_alarm_management_solid, "alarmSettingsButton"),
    Snooze(R.drawable.icon_general_snooze_rules, "snoozeRuleButton"),
    Add(R.drawable.icon_general_plus_line, "addButton"),
    Archiving(R.drawable.icon_status_archiving_solid_normal_dark, "archivingFilesButton"),
}

data class HeaderBarIconState(
    val icon: HeaderBarIcon,
    val badgeCount: Int = 0,
    val resolvedIcon: Int = icon.icon,
    val tint: Color? = null,
)
