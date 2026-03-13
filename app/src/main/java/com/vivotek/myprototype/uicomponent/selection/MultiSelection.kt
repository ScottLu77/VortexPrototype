package com.vivotek.myprototype.uicomponent.selection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vivotek.myprototype.R
import com.vivotek.myprototype.uicomponent.common.clickable2
import com.vivotek.myprototype.uicomponent.font.Body2
import com.vivotek.myprototype.uicomponent.font.Button
import com.vivotek.myprototype.uicomponent.font.Subtitle1
import com.vivotek.myprototype.uicomponent.headerbar.NoSearchResult
import com.vivotek.myprototype.uicomponent.headerbar.SearchBarPage


interface MultiSelection {
    val key: String
    val selected : MutableState<Boolean>
    @Composable fun RowItemView()
}

@Composable
fun MultiSelectionPage(
    headerBar: @Composable () -> Unit,
    emptyView: @Composable () -> Unit,
    options: List<MultiSelection>,
    searchBarHint: String,
) {
    val nav = rememberNavController()
    NavHost(nav, "main") {
        composable("main") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.surface02)),
            ) {
                headerBar()
                SearchingBlock(searchBarHint) { nav.navigate("search") }
                if (options.isNotEmpty()) {
                    MultiSelectionIndicator(options)
                    MultiSelectionList(options)
                } else {
                    emptyView()
                }
            }
        }
        composable("search") {
            SearchBarPage(
                searchBarHint,
                onClose = { nav.popBackStack() }
            ) { searchText ->
                if (searchText.isNotEmpty()) {
                    val results = options.filter { it.key.contains(searchText, true) }
                    if (results.isNotEmpty()) {
                        MultiSelectionList(results)
                    } else {
                        NoSearchResult()
                    }
                }
            }
        }
    }
}

@Composable
fun SearchingBlock(
    searchBarHint: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(colorResource(R.color.surface03))
            .semantics { testTagsAsResourceId = true },
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
                .height(36.dp)
                .background(colorResource(id = R.color.input01), shape = RoundedCornerShape(4.dp))
                .clickable2(onClick)
                .testTag("searchButton"),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_general_search_line),
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 6.dp)
                    .size(24.dp),
                colorFilter = ColorFilter.tint(colorResource(R.color.icon15))
            )
            Text(
                text = searchBarHint,
                style = Body2,
                color = colorResource(R.color.text06)
            )
        }
    }
}


@Composable
private fun MultiSelectionIndicator(
    list: List<MultiSelection>,
) {
    val selectCount = list.filter { it.selected.value }.size
    val totalCount = list.size
    val allSelected = selectCount == totalCount

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
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
                .clickable { if (allSelected) list.forEach { it.selected.value = false } else list.forEach { it.selected.value = true } },
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
private fun MultiSelectionList(
    list: List<MultiSelection>,
) {
    LazyColumn {
        items(list) { item ->
            MultiSelectionRowItem(item) { item.selected.value = !item.selected.value }
        }
    }
}

@Composable
private fun MultiSelectionRowItem(
    item: MultiSelection,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
            .background(colorResource(id = R.color.surface03), shape = RoundedCornerShape(4.dp))
            .clickable2(onClick),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            item.RowItemView()
        }
        Image(
            modifier = Modifier
                .padding(end = 16.dp)
                .size(24.dp),
            painter = if (item.selected.value) {
                painterResource(id = R.drawable.icon_status_checkbox_circle_checked_solid_normal)
            } else {
                painterResource(id = R.drawable.icon_status_checkbox_circle_unchecked_solid_normal)
            },
            contentDescription = ""
        )
    }
}

@Composable
fun EmptySelectionView(
    text: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.illustration_list_dark),
            contentDescription = "",
            modifier = Modifier.size(100.dp),
            colorFilter = ColorFilter.tint(colorResource(R.color.icon02)),
        )
        Text(
            text = text,
            modifier = Modifier
                .wrapContentSize()
                .padding(top = 8.dp),
            style = Subtitle1,
            color = colorResource(id = R.color.text01),
            textAlign = TextAlign.Center,
        )
    }
}