package com.vivotek.myprototype.backend.model

import com.google.gson.annotations.SerializedName
import com.vivotek.myprototype.common.DevicePrimaryKey2

data class ArchiveFilterV2(
    @SerializedName("devices")
    val devices: List<DevicePrimaryKey2>? = null,
    @SerializedName("time")
    val time: TimeRange? = null,
)
