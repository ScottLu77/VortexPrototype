package com.vivotek.myprototype.uicomponent.selection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vivotek.myprototype.R
import com.vivotek.myprototype.uicomponent.common.Divider
import com.vivotek.myprototype.uicomponent.font.Body1
import com.vivotek.myprototype.uicomponent.font.Caption
import com.vivotek.myprototype.uicomponent.headerbar.ApplyButton
import com.vivotek.myprototype.uicomponent.headerbar.NavigationBar
import com.vivotek.myprototype.uicomponent.headerbar.NavigationBarWithApply
import com.vivotek.myprototype.uicomponent.headerbar.NoSearchResult
import com.vivotek.myprototype.uicomponent.headerbar.SearchBarPage


interface SingleSelection {
    val key: String
    @Composable fun RowItemView()
}

@Composable
fun SingleSelectionPage(
    headerBar: @Composable () -> Unit,
    options: List<SingleSelection>,
    selected: SingleSelection?,
    description: String? = null,
    onClick: (SingleSelection) -> Unit,
) {
    val lastIndex = remember { options.lastIndex }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.surface02))
    ) {
        headerBar()
        Spacer(modifier = Modifier.height(56.dp))
        LazyColumn {
            itemsIndexed(options) { index, option ->
                val isLast = index == lastIndex
                SingleSelectionRowItem(
                    rowItemView = { option.RowItemView() },
                    selected = selected == option,
                    showDivider = !isLast,
                ) {
                    onClick(option)
                }
            }
        }
        if (description != null) {
            Text(
                text = description,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 12.dp)
                    .fillMaxWidth(),
                style = Caption,
                color = colorResource(R.color.text01),
            )
        }
    }
}

@Composable
fun SingleSelectionWithSearch(
    headerBar: @Composable () -> Unit,
    options: List<SingleSelection>,
    selected: SingleSelection?,
    searchBarHint: String,
    onClick: (SingleSelection) -> Unit,
) {
    val nav = rememberNavController()
    NavHost(nav, "main") {
        composable("main") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(R.color.surface02))
            ) {
                headerBar()
                SearchingBlock(searchBarHint) { nav.navigate("search") }
                SingleSelectionList(options, selected, onClick)
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
                        SingleSelectionList(results, selected, onClick)
                    } else {
                        NoSearchResult()
                    }
                }
            }
        }
    }
}

@Composable
private fun SingleSelectionList(
    options: List<SingleSelection>,
    selected: SingleSelection?,
    onClick: (SingleSelection) -> Unit,
) {
    val lastIndex = remember { options.lastIndex }
    val listState = rememberLazyListState()

    // Auto scroll to selected item
    LaunchedEffect(selected) {
        selected?.let {
            val selectedIndex = options.indexOf(it)
            if (selectedIndex >= 0) {
                listState.scrollToItem(selectedIndex)
            }
        }
    }

    LazyColumn(
        state = listState,
        contentPadding = PaddingValues(top = 8.dp)
    ) {
        itemsIndexed(options) { index, option ->
            val isLast = index == lastIndex
            SingleSelectionRowItem(
                rowItemView = { option.RowItemView() },
                selected = selected == option,
                showDivider = !isLast,
            ) {
                onClick(option)
            }
        }
    }
}

@Composable
private fun SingleSelectionRowItem(
    rowItemView: @Composable () -> Unit,
    selected: Boolean = false,
    showDivider: Boolean = true,
    onClick: () -> Unit,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(colorResource(R.color.surface03))
            .semantics { testTagsAsResourceId = true }
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(colorResource(R.color.transparent)),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.transparent),
                contentColor = colorResource(R.color.transparent),
                disabledContainerColor = colorResource(R.color.transparent),
                disabledContentColor = colorResource(R.color.transparent),
            ),
            border = null,
            elevation = null,
            contentPadding = PaddingValues(0.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    rowItemView()
                }
                if (selected) {
                    Image(
                        painter = painterResource(R.drawable.ic_icon_general_check_solid),
                        contentDescription = "",
                        modifier = Modifier.size(28.dp),
                        contentScale = ContentScale.Fit,
                        colorFilter = ColorFilter.tint(colorResource(R.color.icon06)),
                    )
                }
            }
        }

        if (showDivider) {
            Divider(padding = 16.dp)
        }
    }
}

@Composable
fun SingleSelectionRowItemView(
    text: String,
    icon: Int? = null,
    colorIcon: Int? = null,
) {
    Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        if (icon != null) {
            Image(
                modifier = Modifier.size(28.dp),
                painter = painterResource(icon),
                colorFilter = ColorFilter.tint(colorResource(R.color.icon02)),
                contentDescription = "",
            )
        } else if (colorIcon != null) {
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .padding(8.dp)
                    .border(1.dp, colorResource(R.color.outline01), shape = CircleShape)
                    .background(colorResource(colorIcon), shape = CircleShape),
            )
        }
        Text(
            text,
            modifier = Modifier.weight(1f),
            style = Body1,
            color = colorResource(R.color.text01),
            maxLines = 1,
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis,
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewColorSelectionPage() {
    SingleSelectionPage(
        headerBar = {
            NavigationBar(
                stringResource(R.string.Upper_body_clothing_color),
                R.drawable.icon_general_left_line
            ) { }
        },
        PreviewColorOption.entries,
        PreviewColorOption.Orange
    ) { }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAgeSelectionPage() {
    SingleSelectionPage(
        headerBar = {
            NavigationBarWithApply(
                stringResource(R.string.PowerLineFrequency),
                R.drawable.icon_general_left_line,
                ApplyButton(stringResource(R.string.save), true) {},
            ) { }
        },
        PreviewPowerLineOption.entries,
        PreviewPowerLineOption._60,
        stringResource(R.string.powerLineFrequencyDescription),
    ) { }
}

@Preview(showBackground = true)
@Composable
private fun PreviewGenderSelectionPage() {
    SingleSelectionPage(
        headerBar = {
            NavigationBar(
                stringResource(R.string.Gender),
                R.drawable.icon_general_left_line
            ) { }
        },
        PreviewGenderOption.entries,
        PreviewGenderOption.Any,
    ) { }
}

private enum class PreviewColorOption(val text: String, val icon: Int?, val color: Int?): SingleSelection {
    Any("Any", R.drawable.icon_general_category_line, null),
    Red("Red", null, R.color.Red),
    Orange("Orange", null, R.color.Orange),
    Yellow("Yellow", null, R.color.Yellow),
    Green("Green", null, R.color.Green),
    Blue("Blue", null, R.color.Blue);

    override val key: String get() = text

    @Composable
    override fun RowItemView() {
        SingleSelectionRowItemView(text, icon, color)
    }
}

private enum class PreviewPowerLineOption(val text: String): SingleSelection {
    _50("50 Hz"),
    _60("60 Hz");

    override val key: String get() = text

    @Composable
    override fun RowItemView() {
        SingleSelectionRowItemView(text)
    }
}

private enum class PreviewGenderOption(val text: String, val icon: Int): SingleSelection {
    Any("Any", R.drawable.icon_general_category_line),
    Male("Male", R.drawable.icon_general_male_line),
    Female("Female", R.drawable.icon_general_female_line);

    override val key: String get() = text

    @Composable
    override fun RowItemView() {
        SingleSelectionRowItemView(text, icon)
    }
}