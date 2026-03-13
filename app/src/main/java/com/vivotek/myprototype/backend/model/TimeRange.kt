package com.vivotek.myprototype.backend.model

import com.google.gson.annotations.SerializedName

data class TimeRange(
    @SerializedName("start")
    val start: String,
    @SerializedName("end")
    val end: String?,
)
