package com.vivotek.myprototype.common

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.graphics.toColorInt
import kotlin.math.abs

class AvatarHelper {

    companion object {
        val shared = AvatarHelper()

        private val userColors = listOf(
            "#FF9A96",
            "#FDB0AE",
            "#FF93BC",
            "#FCB8D1",
            "#D98EDE",
            "#DF9DEA",
            "#9C8EE3",
            "#BBA7DD",
            "#859FD3",
            "#9BAED8",
            "#60DAE7",
            "#9ADFE7",
            "#70C9A2",
            "#5EDCC0",
            "#AAD484",
            "#CBE5B4",
            "#FDC474",
            "#FFD58F",
            "#C4A297",
            "#FEBE9B",
        )

        private val orgColors = listOf(
            "#E6544A",
            "#E66A61",
            "#E63378",
            "#E66194",
            "#9E28B3",
            "#A34BB3",
            "#6439B3",
            "#7C5DB3",
            "#3E50B3",
            "#5160B3",
            "#0096AC",
            "#52BCCC",
            "#00966E",
            "#00B383",
            "#6DBF10",
            "#88D033",
            "#EB8C00",
            "#FFAD33",
            "#804733",
            "#EB8142",
        )
    }

    private fun hash(value: String): Int {
        var hash = 0L
        for (c in value) {
            hash = (c.code + (hash.toInt().shl(5) - hash))
        }
        return (abs(hash) % 20).toInt()
    }

    fun getUserColor(email: String): Int {
        val hash = hash(email)
        return userColors[hash].toColorInt()
    }

    fun getOrgColor(name: String): Int {
        val hash = hash(name)
        return orgColors[hash].toColorInt()
    }

    fun setAvatarColor(view: TextView, @ColorInt color: Int) {
        view.background.colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN)
    }
}