package com.vivotek.myprototype.archive

import android.os.Parcelable
import com.amplifyframework.datastore.generated.model.Archive
import com.amplifyframework.datastore.generated.model.ArchiveSharedLinkOutput
import com.amplifyframework.datastore.generated.model.Status
import com.vivotek.myprototype.FlavorConfig
import com.vivotek.myprototype.common.DevicePrimaryKey2
import com.vivotek.myprototype.common.FeatureToggle
import com.vivotek.myprototype.common.UserInfo
import com.vivotek.myprototype.common.extension.ifNullOrEmpty
import com.vivotek.myprototype.common.toInstant
import com.vivotek.myprototype.common.toString
import com.vivotek.myprototype.manager.OrganizationInfoManager
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.TestOnly
import java.time.Instant
import java.time.ZoneOffset


enum class ArchiveAction {
    Archiving,
    Waiting,
    Success,
    Failed
}

data class SharedLink(
    val id: String,
    val enabled: Boolean,
    val password: String?,
    val expireTime: Instant?,
    val url: String?,
    val enableDownload: Boolean?,
) {
    constructor(output: ArchiveSharedLinkOutput) : this(
        output.id,
        output.enabled,
        output.password,
        output.expireTime?.toInstant("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", ZoneOffset.UTC),
        output.url,
        output.enableDownload,
    )
}

data class ArchiveFile(
    val thingName: String,
    val createdAt: String,
    val name: String,
    val creatorNickName: String,
    val creatorEmail: String,
    val startAt: Instant,
    val status: Status,
    val videoLength: Int,
    val derivant: String,
    val cloudSize: Int,
    val sharedLink: SharedLink,
) {
    val id = thingName + createdAt + derivant
    val deviceID = DevicePrimaryKey2(thingName, derivant)
    val createAtForDisplay = Instant.parse(createdAt).toString("yyyy/MM/dd HH:mm:ss")
    val archivingAction: ArchiveAction = when (status) {
        Status.START_ARCHIVE -> ArchiveAction.Waiting
        Status.UPLOADING, Status.UPLOAD_DONE -> ArchiveAction.Archiving
        Status.HLS_READY -> ArchiveAction.Success
        Status.GEN_M3U8_FAIL -> ArchiveAction.Failed
        else -> {
            ArchiveAction.Success
        }
    }
    val thumbnails3Key = thingName + "/archive/${createdAt}/thumbnail.jpg"
    val playbackUrl = "${FlavorConfig.S3_CDN_URL}device/${OrganizationInfoManager.storageLocation}/$thingName/archive/${createdAt}/playback.m3u8"
    val archiveUrl = "${FlavorConfig.S3_CDN_URL}device/${OrganizationInfoManager.storageLocation}/$thingName/archive/${createdAt}/archive.mp4"
    val thumbnailLocalFileName = thumbnails3Key
        .replace("-", "_")
        .replace("/", "_")
        .replace("T", "_")
        .replace(":", "_")
        .replace("Z", "_")
        .replaceFirst(".", "_")
    val canArchiveShare: Boolean
    val canArchiveDownload: Boolean
    val canArchiveDelete: Boolean

    constructor(archive: Archive) : this(
        archive.thingName ?: "",
        archive.createdAt, // 2023-10-19T01:38:02Z、2023-10-18T06:05:52.969Z
        archive.filename ?: "",
        archive.creatorNickname ?: "",
        archive.creatorEmail?.lowercase() ?: "",
        Instant.parse(archive.startAt),
        archive.status,
        archive.videoLength ?: 0,
        archive.derivant.ifNullOrEmpty { "none" },
        archive.cloudSize ?: 0, // kb
        SharedLink(archive.sharedLink),
    )

    init {
        val featureToggle = FeatureToggle.Companion.shared()
        canArchiveShare = featureToggle.canShare(this@ArchiveFile)
        canArchiveDownload = featureToggle.canDownload(this@ArchiveFile)
        canArchiveDelete = featureToggle.canDelete(this@ArchiveFile)
    }

    companion object

}

@Parcelize
data class ArchiveInfo(
    val fileName: String,
    var deviceName: String,
    var nvrName: String?,
    var site: String,
    var dateOfArchived: String,
    var dateOfFootage: String,
    var duration: String,
    val cloudSize: String,
    var creator: UserInfo,
    val status: ArchiveAction,
) : Parcelable

@Parcelize
data class ArchivePlayerInfo(
    var thingName: String,
    var createdAt: String,
    var playbackUrl: String
) : Parcelable

@TestOnly
fun ArchiveFile.Companion.create(thingName: String, name: String, createdAt: String, status: Status, url: String? = null, videoLength: Int = 0): ArchiveFile {
    return Archive.Builder()
        .thingName(thingName)
        .createdAt(createdAt)
        .filename(name)
        .creatorNickname("")
        .creatorEmail("")
        .startAt(createdAt)
        .endAt(createdAt)
        .updatedAt(createdAt)
        .sharedLink(
            ArchiveSharedLinkOutput.Builder()
                .id("")
                .enabled(false)
                .url(url)
                .build()
        ).status(status)
        .videoLength(videoLength)
        .derivant("none")
        .cloudSize(0)
        .build()
        .let { ArchiveFile(it) }
}
