package com.vivotek.myprototype.common.extension

fun <T : Enum<T>> T?.isNotIn(items: Iterable<T>): Boolean {
    return !items.contains(this)
}

fun <T : Enum<T>> T?.isNot(vararg items: T): Boolean {
    return !items.contains(this)
}

fun <T : Enum<T>> T?.isAnyOf(vararg items: T): Boolean {
    return items.contains(this)
}
