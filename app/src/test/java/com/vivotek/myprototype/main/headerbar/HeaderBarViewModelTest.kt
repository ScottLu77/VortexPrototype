package com.vivotek.myprototype.main.headerbar

import androidx.compose.ui.graphics.Color
import com.vivotek.myprototype.R
import com.vivotek.myprototype.archive.BaseArchiveFileProvider
import com.vivotek.myprototype.common.FeatureToggle
import com.vivotek.myprototype.main.bottombar.BottomTabItem
import com.vivotek.myprototype.main.view.ViewMode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class HeaderBarViewModelTest {

    private lateinit var viewModel: HeaderBarViewModel
    private lateinit var fakeFeatureToggle: FakeFeatureToggle
    private lateinit var fakeArchiveFileProvider: BaseArchiveFileProvider

    class FakeFeatureToggle : FeatureToggle() {
        var resellerBindingHint = false
        var alarmManagement = false
        var snoozeMessage = false

        override fun canShowResellerBindingHint(): Boolean = resellerBindingHint
        override fun canViewAlarmManagement(): Boolean = alarmManagement
        override fun canSnoozeMessage(): Boolean = snoozeMessage
    }

    @Before
    fun setup() {
        fakeFeatureToggle = FakeFeatureToggle()
        fakeArchiveFileProvider = BaseArchiveFileProvider()
        viewModel = HeaderBarViewModel(
            featureToggle = fakeFeatureToggle,
            archiveFileProvider = fakeArchiveFileProvider,
        )
    }

    @Test
    fun `no icons when no tab selected`() {
        val states = viewModel.headerBarIconStates.value
        assertTrue(states.isEmpty())
    }

    @Test
    fun `View tab shows News when resellerBindingHint enabled`() {
        fakeFeatureToggle.resellerBindingHint = true
        viewModel.updateTab(BottomTabItem.View)
        val states = viewModel.headerBarIconStates.value
        assertTrue(states.any { it.icon == HeaderBarIcon.News })
    }

    @Test
    fun `View tab hides News when resellerBindingHint disabled`() {
        fakeFeatureToggle.resellerBindingHint = false
        viewModel.updateTab(BottomTabItem.View)
        val states = viewModel.headerBarIconStates.value
        assertTrue(states.none { it.icon == HeaderBarIcon.News })
    }

    @Test
    fun `View tab shows Search`() {
        viewModel.updateTab(BottomTabItem.View)
        val states = viewModel.headerBarIconStates.value
        assertTrue(states.any { it.icon == HeaderBarIcon.Search })
    }

    @Test
    fun `CustomView tab shows Search and Add`() {
        viewModel.updateTab(BottomTabItem.CustomView)
        val states = viewModel.headerBarIconStates.value
        assertTrue(states.any { it.icon == HeaderBarIcon.Search })
        assertTrue(states.any { it.icon == HeaderBarIcon.Add })
    }

    @Test
    fun `Message tab shows Alarm when feature enabled`() {
        fakeFeatureToggle.alarmManagement = true
        viewModel.updateTab(BottomTabItem.Message)
        val states = viewModel.headerBarIconStates.value
        assertTrue(states.any { it.icon == HeaderBarIcon.Alarm })
    }

    @Test
    fun `Message tab shows Snooze with count when feature enabled`() {
        fakeFeatureToggle.snoozeMessage = true
        viewModel.updateTab(BottomTabItem.Message)
        viewModel.updateSnoozeCount(3)
        val states = viewModel.headerBarIconStates.value
        val snooze = states.find { it.icon == HeaderBarIcon.Snooze }
        assertEquals(3, snooze?.badgeCount)
    }

    @Test
    fun `View tab shows Mode icon when viewMode is set`() {
        viewModel.updateTab(BottomTabItem.View)
        viewModel.updateViewMode(ViewMode.List)
        val states = viewModel.headerBarIconStates.value
        val mode = states.find { it.icon == HeaderBarIcon.Mode }
        assertEquals(R.drawable.icon_general_grid_solid, mode?.resolvedIcon)
    }

    @Test
    fun `Mode icon resolves to list icon when in Grid mode`() {
        viewModel.updateTab(BottomTabItem.View)
        viewModel.updateViewMode(ViewMode.Grid)
        val states = viewModel.headerBarIconStates.value
        val mode = states.find { it.icon == HeaderBarIcon.Mode }
        assertEquals(R.drawable.icon_general_list_solid, mode?.resolvedIcon)
    }

    @Test
    fun `FloorPlan tab shows Search and Mode`() {
        viewModel.updateTab(BottomTabItem.FloorPlan)
        viewModel.updateViewMode(ViewMode.List)
        val states = viewModel.headerBarIconStates.value
        assertTrue(states.any { it.icon == HeaderBarIcon.Search })
        assertTrue(states.any { it.icon == HeaderBarIcon.Mode })
    }

    @Test
    fun `EventInsight tab shows Search`() {
        viewModel.updateTab(BottomTabItem.EventInsight)
        val states = viewModel.headerBarIconStates.value
        assertTrue(states.any { it.icon == HeaderBarIcon.Search })
    }

    @Test
    fun `DeepSearch tab shows Search when canDeepSearch`() {
        viewModel.updateCanDeepSearch(true)
        viewModel.updateTab(BottomTabItem.DeepSearch)
        val states = viewModel.headerBarIconStates.value
        assertTrue(states.any { it.icon == HeaderBarIcon.Search })
    }

    @Test
    fun `DeepSearch tab hides Search when not canDeepSearch`() {
        viewModel.updateCanDeepSearch(false)
        viewModel.updateTab(BottomTabItem.DeepSearch)
        val states = viewModel.headerBarIconStates.value
        assertTrue(states.none { it.icon == HeaderBarIcon.Search })
    }

    @Test
    fun `News icon has tint Unspecified`() {
        fakeFeatureToggle.resellerBindingHint = true
        viewModel.updateTab(BottomTabItem.View)
        val states = viewModel.headerBarIconStates.value
        val news = states.find { it.icon == HeaderBarIcon.News }
        assertEquals(Color.Unspecified, news?.tint)
    }
}
