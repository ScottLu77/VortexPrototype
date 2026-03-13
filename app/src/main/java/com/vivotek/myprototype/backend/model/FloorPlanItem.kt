package com.vivotek.myprototype.backend.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FloorPlanItem(
    @SerializedName("id")
    val id: String,
    @SerializedName("siteId")
    val siteId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
) : Parcelable

data class FloorPlansResponse(
    @SerializedName("floorPlans")
    val floorPlans: List<FloorPlanItem>
) {
    companion object
}

fun FloorPlansResponse.Companion.uiPreview() = FloorPlansResponse(
    floorPlans = listOf(
        FloorPlanItem(
            id = "floor-plan-001",
            siteId = "6874b23f-be80-477c-8ecf-5896741584e5",
            name = "Floor 1",
            imageUrl = "https://mcdn.wallpapersafari.com/small/97/89/JL8o4B.jpg"
        ),
        FloorPlanItem(
            id = "floor-plan-002",
            siteId = "d2d0543f-f3eb-4604-81c5-5ecf698a07d1",
            name = "Floor 2",
            imageUrl = "https://mcdn.wallpapersafari.com/small/20/87/Ld7IhK.jpg"
        )
    )
)

@Parcelize
data class DevicePosition(
    @SerializedName("floorPlanId")
    val floorPlanId: String,
    @SerializedName("deviceSerialNumber")
    val deviceId: String,
    @SerializedName("positionX")
    val x: Float,
    @SerializedName("positionY")
    val y: Float,
    @SerializedName("fovAngle")
    val fovAngle: Float?,
    @SerializedName("fovDirection")
    val fovDirection: Float,
    @SerializedName("fovDepth")
    val fovDepth: Float?
) : Parcelable

data class DevicePositionsResponse(
    @SerializedName("devicePositions")
    val devicePositions: List<DevicePosition>
) {
    companion object
}


fun DevicePositionsResponse.Companion.uiPreview() = DevicePositionsResponse(
    devicePositions = listOf(
        DevicePosition(
            floorPlanId = "floor-plan-001",
            deviceId = "0002D1A3D60E-1728636626348:none",
            x = 0.5f,
            y = 0.5f,
            fovAngle = 38.0f,
            fovDirection = 200.0f,
            fovDepth = 0.12f
        ),
        DevicePosition(
            floorPlanId = "floor-plan-001",
            deviceId = "0002D1A3F1E0-1677061577935:none",
            x = 0.7f,
            y = 0.3f,
            fovAngle = 56.0f,
            fovDirection = 85.0f,
            fovDepth = 0.08f,
        ),
    )
)