package com.vivotek.myprototype.main.headerbar

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.vivotek.myprototype.R
import com.vivotek.myprototype.archive.ArchiveFileProvider
import com.vivotek.myprototype.archive.BaseArchiveFileProvider
import com.vivotek.myprototype.common.FeatureToggle
import com.vivotek.myprototype.main.bottombar.BottomTabItem
import com.vivotek.myprototype.main.bottombar.BottomTabItem.*
import com.vivotek.myprototype.main.view.ViewMode
import com.vivotek.myprototype.manager.OrganizationInfoManager

class HeaderBarViewModel(
    private val featureToggle: FeatureToggle = FeatureToggle.shared(),
    private val archiveFileProvider: BaseArchiveFileProvider = ArchiveFileProvider.Companion,
) : ViewModel() {

    var selectedTab by mutableStateOf<BottomTabItem?>(null)
        private set
    var snoozeCount by mutableStateOf(0)
        private set
    var viewMode by mutableStateOf<ViewMode?>(null)
        private set
    var canDeepSearch by mutableStateOf(false)
        private set
    var showBottomSheet = mutableStateOf(false)

    val headerBarIconStates: State<List<HeaderBarIconState>> = derivedStateOf {
        val tab = selectedTab ?: return@derivedStateOf emptyList()
        buildList {
            // News - only on View tab when reseller binding hint is enabled
            if (tab == View && featureToggle.canShowResellerBindingHint()) {
                add(HeaderBarIconState(HeaderBarIcon.News, tint = Color.Unspecified))
            }

            // Search - tab-dependent
            if (showSearch(tab)) {
                add(HeaderBarIconState(HeaderBarIcon.Search))
            }

            // Mode - only View/FloorPlan with active viewMode
            viewMode?.let { mode ->
                if (tab == View || tab == FloorPlan) {
                    val resolved = if (mode == ViewMode.List)
                        R.drawable.icon_general_grid_solid
                    else
                        R.drawable.icon_general_list_solid
                    add(HeaderBarIconState(HeaderBarIcon.Mode, resolvedIcon = resolved))
                }
            }

            // Alarm - Message tab with feature flag
            if (tab == Message && featureToggle.canViewAlarmManagement()) {
                add(HeaderBarIconState(HeaderBarIcon.Alarm))
            }

            // Snooze - Message tab with feature flag + count
            if (tab == Message && featureToggle.canSnoozeMessage()) {
                add(HeaderBarIconState(HeaderBarIcon.Snooze, badgeCount = snoozeCount))
            }

            // Add - CustomView tab only
            if (tab == CustomView) {
                add(HeaderBarIconState(HeaderBarIcon.Add))
            }

            // Archiving - Archive tab, not free plan, has archiving files
            if (tab == Archive && !OrganizationInfoManager.isFreePlan
                && archiveFileProvider.archivingFiles.isNotEmpty()
            ) {
                add(HeaderBarIconState(HeaderBarIcon.Archiving, tint = Color.Unspecified))
            }
        }
    }

    private fun showSearch(tab: BottomTabItem): Boolean {
        return when (tab) {
            View, CustomView, FloorPlan, EventInsight -> true
            DeepSearch -> canDeepSearch
            else -> false
        }
    }

    fun updateTab(tab: BottomTabItem) {
        selectedTab = tab
    }

    fun updateSnoozeCount(count: Int) {
        snoozeCount = count
    }

    fun updateViewMode(mode: ViewMode?) {
        viewMode = mode
    }

    fun updateCanDeepSearch(enabled: Boolean) {
        canDeepSearch = enabled
    }

    fun popupMenu() {
        showBottomSheet.value = true
    }

    fun closeMenu() {
        showBottomSheet.value = false
    }
}
