package com.vivotek.myprototype.main.headerbar

import com.vivotek.myprototype.R
import org.junit.Assert.assertEquals
import org.junit.Test

class HeaderBarIconTest {

    @Test
    fun `each icon has correct test tag`() {
        assertEquals("newsButton", HeaderBarIcon.News.testTag)
        assertEquals("searchButton", HeaderBarIcon.Search.testTag)
        assertEquals("changeLayout", HeaderBarIcon.Mode.testTag)
        assertEquals("alarmSettingsButton", HeaderBarIcon.Alarm.testTag)
        assertEquals("snoozeRuleButton", HeaderBarIcon.Snooze.testTag)
        assertEquals("addButton", HeaderBarIcon.Add.testTag)
        assertEquals("archivingFilesButton", HeaderBarIcon.Archiving.testTag)
    }

    @Test
    fun `each icon has correct drawable resource`() {
        assertEquals(R.drawable.icon_status_notified, HeaderBarIcon.News.icon)
        assertEquals(R.drawable.icon_general_search_line, HeaderBarIcon.Search.icon)
        assertEquals(R.drawable.icon_general_grid_solid, HeaderBarIcon.Mode.icon)
        assertEquals(R.drawable.icon_general_alarm_management_solid, HeaderBarIcon.Alarm.icon)
        assertEquals(R.drawable.icon_general_snooze_rules, HeaderBarIcon.Snooze.icon)
        assertEquals(R.drawable.icon_general_plus_line, HeaderBarIcon.Add.icon)
        assertEquals(R.drawable.icon_status_archiving_solid_normal_dark, HeaderBarIcon.Archiving.icon)
    }

    @Test
    fun `HeaderBarIconState defaults`() {
        val state = HeaderBarIconState(HeaderBarIcon.Search)
        assertEquals(HeaderBarIcon.Search, state.icon)
        assertEquals(0, state.badgeCount)
        assertEquals(R.drawable.icon_general_search_line, state.resolvedIcon)
        assertEquals(null, state.tint)
    }

    @Test
    fun `HeaderBarIconState with snooze badge count`() {
        val state = HeaderBarIconState(HeaderBarIcon.Snooze, badgeCount = 5)
        assertEquals(5, state.badgeCount)
    }

    @Test
    fun `HeaderBarIconState with resolved icon override`() {
        val state = HeaderBarIconState(
            HeaderBarIcon.Mode,
            resolvedIcon = R.drawable.icon_general_list_solid
        )
        assertEquals(R.drawable.icon_general_list_solid, state.resolvedIcon)
    }
}
