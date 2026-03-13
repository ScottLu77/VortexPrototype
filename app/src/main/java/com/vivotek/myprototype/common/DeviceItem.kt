package com.vivotek.myprototype.common

import android.os.Parcelable
import com.amplifyframework.datastore.generated.model.DeviceCity
import com.vivotek.myprototype.backend.model.Device
import com.vivotek.myprototype.backend.model.DeviceType
import com.vivotek.myprototype.backend.model.Protocol
import com.vivotek.myprototype.backend.model.RecordingType
import com.vivotek.myprototype.backend.model.SupportKey
import kotlinx.parcelize.Parcelize
import kotlin.math.abs

const val DEFAULT_RECORDING_CAPACITY: Int = 0
const val DERIVANT_NONE: String = "none"

enum class CameraType {
    Normal,
    Fisheye,
    PTZ
}

enum class LicenseType(val planTypeId: String) {
    XPro("xPro"),
    XStd("xStd"),
}


@Parcelize
data class DeviceItem(
    val mac: String,
    var derivant: String,
    var siteID: String,
    var name: String,
    var model: String,
    var modelType: String,
    var city: DeviceCity,
    var ip: String,
    var thingName: String,
    var online: Boolean,
    var firmwareVersion: String,
    var firmwareUpgrading: Boolean,
    var cameraType: CameraType,
    var recording: Boolean,
    var thingType: DeviceType?,
    var key: DevicePrimaryKey = DevicePrimaryKey(mac, derivant),
    var key2: DevicePrimaryKey2 = DevicePrimaryKey2(thingName, derivant),
    var channel: Int = derivant.replace("ch", "").toIntOrNull() ?: 0,
    var thumbnailKey: String,
    var derivantMac: String,
    var storageCapacity: Int,
    var archiveLimitedSize: Int,
    var wizardFinished: Boolean?,
    var recordingCapacityDays: Int = DEFAULT_RECORDING_CAPACITY,
    var isCustomRetentionDaysEnabled: Boolean?,
    var recordingType: RecordingType?,
    var protocol: Protocol?,
    var vcaCapability: List<String>?,
    var support: List<SupportKey>?,
    var mainLicenseType: LicenseType?,
    val deletedOrAccessRevokedDevice: Boolean = false, // CustomizedView 專用，拿的到 Device 資料時的 case 會用 canLive
) : Parcelable {
    companion object

    fun support(vararg keys: SupportKey) = support?.containsAll(keys.asList()) ?: false
}


fun DeviceItem.Companion.create(device: Device) = DeviceItem(
    mac = device.mac,
    derivant = device.derivant ?: "",
    siteID = device.siteID ?: "",
    name = device.name ?: "",
    model = device.model ?: "",
    modelType = device.modelType ?: "",
    city = device.city ?: DeviceCity.AmericaLosAngeles,
    ip = device.ip ?: "",
    thingName = device.thingName ?: "",
    online = device.online ?: false,
    firmwareVersion = device.firmware ?: "",
    firmwareUpgrading = CarotaOTAState.isFirmwareUpgrading(device.fwUpgradeState),
    cameraType = if (device.fisheye == true) {
        CameraType.Fisheye
    } else if (device.ptz == true) {
        CameraType.PTZ
    } else {
        CameraType.Normal
    },
    recording = device.recording ?: false,
    thingType = device.type,
    thumbnailKey = (device.thingName ?: "") + if (device.derivant == "none") "" else "/" + device.derivant,
    derivantMac = device.derivantMac ?: "",
    storageCapacity = device.storageCapacity ?: 0,
    archiveLimitedSize = device.archiveLimitedSize ?: 0,
    wizardFinished = device.wizardFinished,
    recordingCapacityDays = device.recordingCapacityDays ?: DEFAULT_RECORDING_CAPACITY,
    recordingType = device.recordingType,
    protocol = device.protocol,
    vcaCapability = device.vca?.capability?.filterNotNull(),
    support = device.support?.filterNotNull(),
    mainLicenseType = LicenseType.entries.firstOrNull {
        it.planTypeId == device.contractInfo?.mainPlan?.planType
    },
    isCustomRetentionDaysEnabled = device.isCustomRetentionDaysEnabled,
)


fun DeviceItem.Companion.uiPreview() = DeviceItem(
    "123456789012",
    "none",
    "site01",
    "Camera 01",
    "model",
    "modelType",
    DeviceCity.AsiaTaipei,
    "ip",
    "thingName",
    true,
    "firmwareVersion",
    false,
    CameraType.Normal,
    true,
    DeviceType.camera,
    thumbnailKey = "",
    derivantMac = "",
    storageCapacity = 0,
    archiveLimitedSize = 0,
    wizardFinished = null,
    recordingType = null,
    protocol = null,
    vcaCapability = null,
    support = null,
    mainLicenseType = null,
    isCustomRetentionDaysEnabled = null,
)


fun DeviceItem.getLatestThumbnailGlideModel(): String {
    val images = arrayOf(
        "https://fastly.picsum.photos/id/8/200/300.jpg?hmac=t2Camsbqc4OfjWMxFDwB32A8N4eu7Ido7ZV1elq4o5M",
        "https://fastly.picsum.photos/id/467/200/300.jpg?hmac=sQK5ibuk2pXpFclSCs5TxY7X9hsRsRbb4r5JhWqRErc",
        "https://fastly.picsum.photos/id/233/200/300.jpg?hmac=aVpewfxURvNso_n34jznb-DOcy5vizCqhqwd-YIcKAM",
        "https://fastly.picsum.photos/id/36/200/300.jpg?hmac=yeKKPp3h_shxmrZgoKPc6ix1TOSmkj8Rs9FZVpFzljA",
        "https://fastly.picsum.photos/id/265/200/300.jpg?hmac=NX0ut-ylHFyYKa4TxhZFNElh-h6RcVV7P4PNPgeBxKk",
        "https://fastly.picsum.photos/id/214/200/200.jpg?hmac=hcznBngs7e7PmNwXcM4UioAhb1oOUpfGDzBM-qSgpp4",
        "https://fastly.picsum.photos/id/591/200/300.jpg?hmac=GBnqheK8f8NgGoZ-JQIGl0uYMejcmT4gvw4PsBmUWPY",
    )

    val hash = (mac+derivant).hashCode()
    return images[abs(hash % images.size)]
}