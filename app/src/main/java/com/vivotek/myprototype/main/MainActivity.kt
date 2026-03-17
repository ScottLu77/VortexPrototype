package com.vivotek.myprototype.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vivotek.myprototype.R
import com.vivotek.myprototype.common.IntentParam
import com.vivotek.myprototype.common.PRIVILEGE_CHANGED
import com.vivotek.myprototype.common.RESOURCE_NOT_FOUND
import com.vivotek.myprototype.main.bottombar.BottomBar
import com.vivotek.myprototype.main.bottombar.BottomBarViewModel
import com.vivotek.myprototype.main.bottombar.BottomBarViewModelFactory
import com.vivotek.myprototype.main.bottombar.BottomTabItem
import com.vivotek.myprototype.main.bottombar.MoreTabsMenu
import com.vivotek.myprototype.main.headerbar.HeaderBar
import com.vivotek.myprototype.main.headerbar.HeaderBarIcon
import com.vivotek.myprototype.main.headerbar.HeaderBarViewModel
import com.vivotek.myprototype.manager.OrganizationInfoManager
import com.vivotek.myprototype.uicomponent.common.PopupMenu
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var bottomBarViewModel: BottomBarViewModel
    private lateinit var headerBarViewModel: HeaderBarViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val startBy = intent.getStringExtra(IntentParam.startBy) ?: ""
        val initialTabId = if (
            (startBy == PRIVILEGE_CHANGED || startBy == RESOURCE_NOT_FOUND)
            && intent.hasExtra(IntentParam.selectedMainViewTab)
        ) {
            intent.getIntExtra(IntentParam.selectedMainViewTab, 0)
        } else {
            null
        }

        val factory = BottomBarViewModelFactory(application, initialTabId)
        bottomBarViewModel = ViewModelProvider(this, factory)[BottomBarViewModel::class.java]
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        headerBarViewModel = ViewModelProvider(this)[HeaderBarViewModel::class.java]

        setContent {

            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val scaffoldState = rememberScaffoldState()
            val navController = rememberNavController()
            val scope = rememberCoroutineScope()
            val selectedTab by bottomBarViewModel.selectedTab
            val bottomTabStates by bottomBarViewModel.bottomTabStates
            val headerBarIconStates by headerBarViewModel.headerBarIconStates

            LaunchedEffect(selectedTab) {
                headerBarViewModel.updateTab(selectedTab)
            }


            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                },
            ) {
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        HeaderBar(
                            title = stringResource(selectedTab.title),
                            orgName = OrganizationInfoManager.organizationName,
                            iconStates = headerBarIconStates,
                            onAvatarClick = { scope.launch { drawerState.open() } },
                            onIconClick = { icon ->
                                when (icon) {
                                    HeaderBarIcon.News -> headerBarViewModel.popupMenu()
                                    HeaderBarIcon.Search -> {}
                                    HeaderBarIcon.Mode -> {}
                                    HeaderBarIcon.Alarm -> {}
                                    HeaderBarIcon.Snooze -> {}
                                    HeaderBarIcon.Add -> {}
                                    HeaderBarIcon.Archiving -> {}
                                }
                            },
                        )
                    },
                    bottomBar = {
                        BottomBar(
                            states = bottomTabStates,
                            selectedTab = selectedTab,
                        ) {
                            bottomBarViewModel.navigateTo(it)
                        }
                    },
                    backgroundColor = colorResource(R.color.surface02),
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = selectedTab.key,
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable(BottomTabItem.View.key) {

                        }
                        composable(BottomTabItem.CustomView.key) {

                        }
                        composable(BottomTabItem.Message.key) {

                        }
                        composable(BottomTabItem.FloorPlan.key) {

                        }
                        composable(BottomTabItem.ThinkSearch.key) {

                        }
                        composable(BottomTabItem.DeepSearch.key) {

                        }
                        composable(BottomTabItem.Archive.key) {

                        }
                    }

                }
            }

            PopupMenu(show = bottomBarViewModel.showBottomSheet) {
                MoreTabsMenu(
                    states = bottomTabStates,
                    onTabClick = {
                        bottomBarViewModel.closeMenu()
                        bottomBarViewModel.navigateTo(it)
                    },
                    onReorderTabsClick = {
                    }
                )
            }
        }
    }
}