package com.vivotek.myprototype.backend.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.vivotek.myprototype.common.DevicePrimaryKey2
import kotlinx.parcelize.Parcelize

@Parcelize
data class Site(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("parentId")
    val parentID: String? = null,
    @SerializedName("location")
    val location: Location? = null,
) : Parcelable

@Parcelize
data class Location(
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("address")
    val address: String,
) : Parcelable

data class GetSitesResponse(
    @SerializedName("sites")
    val sites: List<Site>,
)

data class CreateSiteRequest(
    @SerializedName("name")
    val name: String,
    @SerializedName("location")
    val location: Location?,
)

data class MoveDeviceRequest(
    @SerializedName("devices")
    val devices: List<DevicePrimaryKey2>,
)

data class MoveDeviceResponse(
    @SerializedName("devices")
    val devices: List<DeviceMoveResult>,
    @SerializedName("summary")
    val summary: DeviceMoveSummary,
)

data class DeviceMoveResult(
    @SerializedName("thingName")
    val thingName: String,
    @SerializedName("derivant")
    val derivant: String,
    @SerializedName("status")
    val status: DeviceMoveStatus,
    @SerializedName("error")
    val error: String?, // "device not found"  "forbidden"  "internal error"  "..."
)

enum class DeviceMoveStatus {
    @SerializedName("success")
    Success,
    @SerializedName("failed")
    Failed,
}

data class DeviceMoveSummary(
    @SerializedName("total")
    val total: Int,
    @SerializedName("succeeded")
    val succeeded: Int,
    @SerializedName("failed")
    val failed: Int,
)
