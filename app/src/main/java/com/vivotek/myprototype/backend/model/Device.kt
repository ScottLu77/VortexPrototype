@file:Suppress("SpellCheckingInspection")

package com.vivotek.myprototype.backend.model

import com.amplifyframework.datastore.generated.model.DeviceCity
import com.amplifyframework.datastore.generated.model.DeviceCompositeType
import com.google.gson.annotations.SerializedName
import com.vivotek.myprototype.common.DevicePrimaryKey2

@Suppress("unused")
enum class SupportKey {
    @SerializedName("ipspeaker-multiaudio")
    IPSPEAKER_MULTIAUDIO,
    @SerializedName("privacy-mask")
    PRIVACY_MASK,
    @SerializedName("tampering-smart")
    TAMPERING_SMART,
    @SerializedName("webhook")
    WEBHOOK,
    @SerializedName("daynight")
    DAYNIGHT,
    @SerializedName("audioin")
    AUDIOIN,
    @SerializedName("rtsp-access")
    RTSP_ACCESS,
    @SerializedName("scenemode")
    SCENEMODE,
    @SerializedName("webhook-v2")
    WEBHOOK_V2,
    @SerializedName("di")
    DI,
    @SerializedName("do")
    DO,
    @SerializedName("recording")
    RECORDING,
    @SerializedName("remotefocus")
    REMOTE_FOCUS,
    @SerializedName("videoin_stream3")
    VIDEOIN_STREAM3,
    @SerializedName("retentionDaysByUser")
    RETENTION_DAYS_BY_USER,
    @SerializedName("audio")
    AUDIO,
    @SerializedName("audioout")
    AUDIO_OUT,
    @SerializedName("ptzv2")
    PTZ_V2,
    @SerializedName("ptzv3")
    PTZ_V3,
    @SerializedName("channelfirmwareupgrade")
    ChannelFwUpgrade,
}

enum class DeviceType {
    @SerializedName("unknownDevice")
    unknownDevice,
    @SerializedName("camera")
    camera,
    @SerializedName("nvr")
    nvr,
    @SerializedName("nvrchannel")
    nvrchannel,
    @SerializedName("ipspeaker")
    ipspeaker,
    @SerializedName("poeSwitch")
    poeSwitch,
    @SerializedName("bridge")
    bridge,
    @SerializedName("vss")
    vss,
    @SerializedName("vsschannel")
    vsschannel,
}

enum class RecordingType {
    @SerializedName("main_stream")
    main_stream,
    @SerializedName("dual_stream")
    dual_stream
}

data class DeviceInfoVCA(
    @SerializedName("capability")
    val capability: List<String?>?,
    @SerializedName("version")
    val version: String?
)

@Suppress("unused")
enum class PlanState {
    @SerializedName("VALID")
    VALID,
    @SerializedName("EXPIRING")
    EXPIRING,
    @SerializedName("EXPIRED")
    EXPIRED,
}

data class PlanInfo(
    @SerializedName("planType")
    val planType: String,
    @SerializedName("additionalInfo")
    val additionalInfo: String? = null,
    @SerializedName("state")
    val state: PlanState?, // 用 PlanState? 是因為 Gson 會將看不懂的 enum 變成 null
)

data class ContractInfo(
    @SerializedName("mainPlan")
    val mainPlan: PlanInfo?,
    @SerializedName("addOnPlans")
    val addOnPlans: List<PlanInfo?> = listOf(),
    @SerializedName("otherPlans")
    val otherPlans: List<PlanInfo?> = listOf(),
)

@Suppress("unused")
enum class Protocol {
    @SerializedName("VIVOTEK")
    VIVOTEK,
    @SerializedName("ONVIF")
    ONVIF,
    @SerializedName("EXPIRED")
    RTSP,
}

data class Device(
    @SerializedName("mac")
    val mac: String,
    @SerializedName("organizationID")
    val organizationID: String,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: DeviceType? = null,
    @SerializedName("thingName")
    val thingName: String? = null,
    @SerializedName("city")
    val city: DeviceCity? = null,
    @SerializedName("derivant")
    val derivant: String? = null,
    @SerializedName("derivantMac")
    val derivantMac: String? = null,
    @SerializedName("ip")
    val ip: String? = null,
    @SerializedName("firmware")
    val firmware: String? = null,
    @SerializedName("fwUpgradeVersion")
    val fwUpgradeVersion: String? = null,
    @SerializedName("fwUpgradeState")
    val fwUpgradeState: Int? = null,
    @SerializedName("model")
    val model: String? = null,
    @SerializedName("modelType")
    val modelType: String? = null,
    @SerializedName("online")
    val online: Boolean? = null,
    @SerializedName("siteID")
    val siteID: String? = null,
    @SerializedName("fisheye")
    val fisheye: Boolean? = null,
    @SerializedName("ptz")
    val ptz: Boolean? = null,
    @SerializedName("recording")
    val recording: Boolean? = null,
    @SerializedName("recordingCapacityDays")
    val recordingCapacityDays: Int? = null,
    @SerializedName("recordingType")
    val recordingType: RecordingType? = null,
    @SerializedName("protocol")
    val protocol: Protocol? = null, // NVR channel 的來源種類
    @SerializedName("timezone")
    val timezone: String? = null,
    @SerializedName("vca")
    val vca: DeviceInfoVCA? = null,
    @SerializedName("connectedAt")
    val connectedAt: String? = null,
    @SerializedName("disconnectedAt")
    val disconnectedAt: String? = null,
    @SerializedName("auth")
    val auth: String? = null,
    @SerializedName("storageCapacity")
    val storageCapacity: Int? = null,
    @SerializedName("archiveLimitedSize")
    val archiveLimitedSize: Int? = null,
    @SerializedName("wizardFinished")
    val wizardFinished: Boolean? = null,
    @SerializedName("support")
    val support: List<SupportKey?>? = null, // 用 SupportKey? 是因為 Gson 會將看不懂的 enum 變成 null
    @SerializedName("isCustomRetentionDaysEnabled")
    val isCustomRetentionDaysEnabled: Boolean? = null,
    @SerializedName("contractInfo")
    val contractInfo: ContractInfo?,
)

fun DeviceCompositeType.toKey2() = DevicePrimaryKey2(thingName, derivant)
