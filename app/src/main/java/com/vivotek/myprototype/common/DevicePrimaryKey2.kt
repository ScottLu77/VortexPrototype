package com.vivotek.myprototype.common

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DevicePrimaryKey2(
    @SerializedName("thingName")
    val thingName: String,
    @SerializedName("derivant")
    val derivant: String,
) : Parcelable {
    fun getMac() = thingName.take(12)
    override fun toString(): String = "$thingName:$derivant"
}
