package com.vivotek.myprototype.common

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DevicePrimaryKey(
    val mac: String,
    val derivant: String,
) : Parcelable {
    constructor(key2: DevicePrimaryKey2) : this(key2.thingName.take(12), key2.derivant)
}