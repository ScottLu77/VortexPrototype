package com.vivotek.myprototype.main.bottombar

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vivotek.myprototype.common.PreferenceWrapper
import com.vivotek.myprototype.main.bottombar.BottomTabItem.*


data class BottomTabState(
    val tab: BottomTabItem,
    val enabled: Boolean,
    val showBadge: Boolean = false,
)

class BottomBarViewModelFactory(
    val application: Application, val initialTabId: Int?
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return BottomBarViewModel(application, initialTabId) as T
    }
}

class BottomBarViewModel(
    val application: Application,
    val initialTabId: Int?,
) : ViewModel() {
    private val preference: PreferenceWrapper = PreferenceWrapper()
    private val tabDisplayResolver = BottomTabDisplayResolver()

    val bottomTabs = mutableStateListOf<BottomTabItem>()
    var selectedTab: MutableState<BottomTabItem>
        private set

    val showBottomSheet = mutableStateOf(false)
    val showAIHubBottomSheet = mutableStateOf(false)

    init {
        initBottomTabs()

        selectedTab = mutableStateOf(bottomTabs.find { it.id == initialTabId } ?: bottomTabs.first())
    }


    private fun initBottomTabs() {
        val saved = getSavedTabs()
        val available = getAvailableTabs()
        val savedAvailable = saved.intersect(available)
        val unsavedAvailable = available.subtract(saved)
        val tabs = savedAvailable + unsavedAvailable
        bottomTabs.addAll(tabs)
    }


    private fun getSavedTabs(): List<BottomTabItem> {
        val value = preference.getString(application, PreferenceWrapper.KEY_BOTTOM_TABS)
        if (value.isEmpty()) return listOf()
        return value.split(",").mapNotNull {
            BottomTabItem.entries.find { item -> item.key == it }
        }
    }

    private fun getAvailableTabs(): List<BottomTabItem> {
        val defaultList = listOf(View, CustomView, DeepSearch, Message, SearchLight, Archive, FloorPlan)
        return tabDisplayResolver.visibleTabs(defaultList)
    }


    val bottomTabStates: State<List<BottomTabState>> = derivedStateOf {
        bottomTabs.map { tab ->
            BottomTabState(
                tab = tab,
                enabled = tabDisplayResolver.enabled(tab),
                showBadge = tabDisplayResolver.showBadge(tab)
            )
        }
    }


    fun navigateTo(tab: BottomTabItem) {
        when (tab) {
            More -> {
                popupMenu()
            }
            AIHub -> {
                popupAIHubMenu()
            }
            else -> {
                selectedTab.value = tab
            }
        }
    }


    private fun popupMenu() {
        showBottomSheet.value = true
    }

    fun closeMenu() {
        showBottomSheet.value = false
    }

    private fun popupAIHubMenu() {
        showAIHubBottomSheet.value = true
    }

    fun closeAIHubMenu() {
        showAIHubBottomSheet.value = false
    }
}