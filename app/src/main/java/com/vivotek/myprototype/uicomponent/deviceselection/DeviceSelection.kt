package com.vivotek.myprototype.uicomponent.deviceselection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vivotek.myprototype.common.DevicePrimaryKey2
import com.vivotek.myprototype.R
import com.vivotek.myprototype.common.FeatureToggle
import com.vivotek.myprototype.common.SiteState
import com.vivotek.myprototype.uicomponent.common.clickable2
import com.vivotek.myprototype.uicomponent.font.Button
import com.vivotek.myprototype.uicomponent.font.H6
import com.vivotek.myprototype.uicomponent.font.Subtitle1
import com.vivotek.myprototype.uicomponent.headerbar.NoSearchResult
import com.vivotek.myprototype.uicomponent.headerbar.SearchBarPage
import com.vivotek.myprototype.uicomponent.selection.SearchingBlock

@Composable
fun DeviceSelection(
    multiChoices: Boolean,
    headerBar: @Composable () -> Unit,
    source: List<SiteState>,
    selection: SnapshotStateList<DevicePrimaryKey2>,
    searchBarHint: String,
    onAddNewDevice: () -> Unit,
) {
    LaunchedEffect(selection) {
        source.forEach { group ->
            group.isExpand.value = group.devices.any { selection.contains(it.key2) }
        }
    }

    val nav = rememberNavController()
    NavHost(nav, "main") {
        composable("main") {
            DeviceSelectionMainPage(
                multiChoices = multiChoices,
                headerBar = headerBar,
                source = source,
                selection = selection,
                searchBarHint = searchBarHint,
                onClickSearchBar = { nav.navigate("search") },
                onAddNewDevice = onAddNewDevice,
            )
        }
        composable("search") {
            SearchBarPage(
                searchBarHint,
                onClose = { nav.popBackStack() }
            ) { searchText ->
                if (searchText.isNotEmpty()) {
                    DeviceSelectionSearchingPage(
                        multiChoices = multiChoices,
                        searchText = searchText,
                        source = source,
                        selection = selection,
                    )
                }
            }
        }
    }
}

@Composable
fun DeviceSelectionMainPage(
    multiChoices: Boolean,
    headerBar: @Composable () -> Unit,
    source: List<SiteState>,
    selection: SnapshotStateList<DevicePrimaryKey2>,
    searchBarHint: String,
    onClickSearchBar: () -> Unit,
    onAddNewDevice: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        headerBar()
        SearchingBlock(searchBarHint, onClickSearchBar)
        if (source.isEmpty()) {
            NoDevicesScreen(onAddNewDevice)
        } else {
            if (multiChoices) {
                DeviceSelectionIndicator(source, selection)
            }
            DeviceSelectionList(multiChoices, source, selection)
        }
    }
}

@Composable
fun DeviceSelectionSearchingPage(
    multiChoices: Boolean,
    searchText: String,
    source: List<SiteState>,
    selection: SnapshotStateList<DevicePrimaryKey2>,
) {
    val results = remember(searchText) {
        source.mapNotNull { group ->
            val groupNameMatches = group.name.contains(searchText, true)
            val filteredDevices =
                group.devices.filter { device -> device.name.contains(searchText, true) }
            when {
                groupNameMatches -> {
                    // Group name matches: show group with all devices
                    group.copy(devices = group.devices.toMutableStateList()).apply { isExpand.value = true }
                }
                filteredDevices.isNotEmpty() -> {
                    // Device name matches: show group with only matching devices
                    group.copy(devices = filteredDevices.toMutableStateList()).apply { isExpand.value = true }
                }
                else -> null
            }
        }.toMutableStateList()
    }
    if (results.isEmpty()) {
        NoSearchResult()
    } else {
        DeviceSelectionList(multiChoices, results, selection)
    }
}

@Composable
fun DeviceSelectionIndicator(
    sourceList: List<SiteState>,
    selection: SnapshotStateList<DevicePrimaryKey2>,
) {
    val selectCount = selection.size
    val devices = remember { sourceList.map { it.devices } }.flatten()
    val totalCount = devices.size
    val allSelected = selectCount == totalCount

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(colorResource(R.color.surface02))
            .padding(start = 16.dp, end = 16.dp, top = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = Modifier
                .wrapContentSize(),
            style = Subtitle1,
            color = colorResource(R.color.text05),
            text = if (selectCount == 0) {
                stringResource(R.string.no_items_selected_yet)
            } else {
                stringResource(id = R.string.x_x_Selected, selectCount, totalCount)
            }
        )

        Text(
            modifier = Modifier
                .wrapContentSize()
                .clickable2 {
                    selection.clear()
                    if (!allSelected) {
                        selection.addAll(devices.map { it.key2 })
                    }
                },
            style = Button,
            color = colorResource(R.color.text01),
            text = if (allSelected) {
                stringResource(R.string.Deselecte_all)
            } else {
                stringResource(R.string.Selecte_all)
            }
        )
    }
}


@Composable
fun DeviceSelectionList(
    multiChoices: Boolean,
    sourceList: List<SiteState>,
    selection: SnapshotStateList<DevicePrimaryKey2>,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.surface02)),
    ) {
        sourceList.forEach { group ->
            // Group header (sticky)
            stickyHeader(key = group.id) {
                if (multiChoices) {
                    // Multi-choice mode: show tri-state checkbox
                    val groupToggleState = remember(sourceList, selection.size) {
                        derivedStateOf {
                            val selectedInGroup = group.devices.count { selection.contains(it.key2) }
                            when (selectedInGroup) {
                                0 -> ToggleableState.Off
                                group.devices.size -> ToggleableState.On
                                else -> ToggleableState.Indeterminate
                            }
                        }
                    }
                    GroupRowItem(
                        group = group,
                        onClick = { group.isExpand.value = !group.isExpand.value },
                        toggleState = groupToggleState,
                        onToggleClick = {
                            when (groupToggleState.value) {
                                ToggleableState.Off -> {
                                    // Select all devices in group
                                    selection.addAll(group.devices.map { it.key2 }.filter { !selection.contains(it) })
                                }
                                ToggleableState.On -> {
                                    // Deselect all devices in group
                                    selection.removeAll(group.devices.map { it.key2 })
                                }
                                ToggleableState.Indeterminate -> {
                                    // Select remaining devices in group
                                    selection.addAll(group.devices.map { it.key2 }.filter { !selection.contains(it) })
                                }
                            }
                        },
                    )
                } else {
                    // Single-choice mode: no checkbox
                    GroupRowItem(
                        group = group,
                        onClick = { group.isExpand.value = !group.isExpand.value },
                    )
                }
            }

            // Device items (if expanded)
            if (group.isExpand.value) {
                item { Spacer(Modifier.height(8.dp)) }
                items(group.devices, key = { it.key2 }) { device ->
                    if (multiChoices) {
                        // Multi-choice mode: show checkbox
                        val checked = remember(selection.size) {
                            derivedStateOf { selection.contains(device.key2) }
                        }
                        DeviceRowItem(
                            device = device,
                            checkedState = checked,
                            onCheckedChange = { isChecked ->
                                if (isChecked) {
                                    selection.add(device.key2)
                                } else {
                                    selection.remove(device.key2)
                                }
                            },
                            onClick = {
                                if (checked.value) {
                                    selection.remove(device.key2)
                                } else {
                                    selection.add(device.key2)
                                }
                            },
                        )
                    } else {
                        // Single-choice mode: no checkbox, just click to select
                        DeviceRowItem(
                            device = device,
                            onClick = {
                                selection.clear()
                                selection.add(device.key2)
                            },
                        )
                    }
                }
                item { Spacer(Modifier.height(8.dp)) }
            }
        }
    }
}

@Composable
fun NoDevicesScreen(
    onAddNewDevice: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.surface02)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(painterResource(R.drawable.illustration_list_dark), "", Modifier.size(100.dp), colorFilter = ColorFilter.tint(colorResource(R.color.icon02)))
        Spacer(modifier = Modifier.height(8.dp))
        Text(stringResource(R.string.no_devices), Modifier, style = H6, color = colorResource(R.color.text01))
        if (FeatureToggle.shared().canAddDevice()) {
            Spacer(modifier = Modifier.height(22.dp))
            Text(stringResource(R.string.add_one), Modifier.clickable2(onAddNewDevice), style = Button, color = colorResource(R.color.primary))
        }
    }
}