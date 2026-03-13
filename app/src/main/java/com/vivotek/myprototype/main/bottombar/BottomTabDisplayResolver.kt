package com.vivotek.myprototype.main.bottombar

open class BottomTabDisplayResolver {


    open fun visibleTabs(source: List<BottomTabItem>): List<BottomTabItem> {
        return source
    }

    fun enabled(tab: BottomTabItem): Boolean {
        return true
    }

    fun showBadge(tab: BottomTabItem): Boolean {
        return true
    }
}