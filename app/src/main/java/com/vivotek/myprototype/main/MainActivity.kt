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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
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

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var bottomBarViewModel: BottomBarViewModel


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

        setContent {

            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val scaffoldState = rememberScaffoldState()
            val navController = rememberNavController()
            val scope = rememberCoroutineScope()
            val selectedTab by bottomBarViewModel.selectedTab
            val bottomTabStates by bottomBarViewModel.bottomTabStates


            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                },
            ) {
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
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

        }
    }
}