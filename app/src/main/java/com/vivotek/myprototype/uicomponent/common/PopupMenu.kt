package com.vivotek.myprototype.uicomponent.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.vivotek.myprototype.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopupMenu(
    show: MutableState<Boolean>,
    onDismissRequest: () -> Unit = { show.value = false },
    content: @Composable ColumnScope.() -> Unit,
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    if (show.value) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            shape = RoundedCornerShape(topStart = 13.dp, topEnd = 13.dp),
            containerColor = colorResource(id = R.color.drop_surface01),
            dragHandle = {
                Surface(
                    modifier = Modifier.padding(0.dp, 6.dp, 0.dp, 2.dp),
                    color = colorResource(id = R.color.surface20),
                    shape = RoundedCornerShape(2.5.dp),
                ) {
                    Box(Modifier.size(width = 40.dp, height = 5.dp))
                }
            },
            content = content,
        )
    }
}