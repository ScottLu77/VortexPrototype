package com.vivotek.myprototype.multichannelv2

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.vivotek.myprototype.R


enum class LayoutOption(val row: Int, val column: Int, val count: Int, @DrawableRes val icon: Int, @StringRes val textRes: Int, val analyticsValue: String) {
    Channel1(1, 1, 1, R.drawable.icon_general_layout_1ch_line, R.string.layout_ch_1, "1x1"),
    Channel2(2, 1, 2, R.drawable.icon_general_layout_2ch_line, R.string.layout_ch_2, "2x1"),
    Channel4(2, 2, 4, R.drawable.icon_general_layout_4ch_line, R.string.layout_ch_4, "2x2"),
    Channel6(3, 2, 6, R.drawable.icon_general_layout_6ch_line, R.string.layout_ch_6, "3x2"),
    Channel16(4, 4, 16, R.drawable.icon_general_layout_16ch_line, R.string.layout_ch_16, "4x4"),
}


class MultiChannelViewModelV2 {
}