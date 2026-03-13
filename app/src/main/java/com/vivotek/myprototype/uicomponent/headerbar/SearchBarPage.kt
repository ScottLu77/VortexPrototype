package com.vivotek.myprototype.uicomponent.headerbar

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vivotek.myprototype.R
import com.vivotek.myprototype.uicomponent.common.Divider
import com.vivotek.myprototype.uicomponent.common.clickable2
import com.vivotek.myprototype.uicomponent.icon.GeneralIcon


@Composable
fun SearchBarPage(
    hint: String,
    onClose: () -> Unit,
    searchContent: @Composable (String) -> Unit,
) {
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.surface02))
    ) {
        SearchHeaderBar(
            hint,
            onClose,
            onTextChange = { searchText = it.text }
        )
        searchContent(searchText)
    }
}

@Composable
fun SearchHeaderBar(
    hint: String,
    onClose: () -> Unit,
    onTextChange: (TextFieldValue) -> Unit,
) {
    var searchText by remember { mutableStateOf(TextFieldValue()) }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(colorResource(id = R.color.surface03))
                .padding(end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            GeneralIcon(
                modifier = Modifier.padding(horizontal = 8.dp),
                icon = R.drawable.icon_general_left_line,
                onClick = onClose,
            )
            Row(
                modifier = Modifier
                    .height(36.dp)
                    .fillMaxWidth()
                    .shadow(elevation = 0.dp, shape = RoundedCornerShape(4.dp))
                    .background(colorResource(id = R.color.input01), shape = RoundedCornerShape(4.dp)),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                BasicTextField(
                    modifier = Modifier
                        .weight(5f)
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    value = searchText,
                    textStyle = TextStyle(
                        color = colorResource(id = R.color.text01),
                        fontSize = 14.sp,
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),
                    singleLine = true,
                    cursorBrush = SolidColor(colorResource(id = R.color.primary)),
                    decorationBox = { innerTextField ->
                        if (searchText.text.isEmpty()) {
                            Text(
                                text = hint,
                                color = colorResource(id = R.color.text06),
                                fontSize = 14.sp,
                            )
                        }
                        innerTextField()
                    },
                    onValueChange = {
                        searchText = it
                        onTextChange(searchText)
                    },
                )
                if (searchText.text.isNotEmpty()) {
                    Icon(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(6.dp)
                            .clickable2 {
                                searchText = TextFieldValue(text = "")
                                onTextChange(searchText)
                            },
                        painter = painterResource(id = R.drawable.icon_general_clear_solid),
                        contentDescription = stringResource(R.string.search),
                        tint = colorResource(id = R.color.icon02),
                    )
                }
            }
        }

        Divider(padding = 0.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun NoSearchResult() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 36.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.illustration_search_failed_dark),
            contentDescription = "",
            modifier = Modifier
                .size(100.dp),
        )
        Text(
            modifier = Modifier
                .wrapContentSize(),
            text = stringResource(id = R.string.No_search_results),
            color = colorResource(id = R.color.text01),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Composable
fun PreviewSearchDataPage() {
    SearchBarPage(
        stringResource(R.string.Search_device),
        onClose = {}
    ) {}
}