package com.vivotek.myprototype.common.glide

import android.content.Context
import com.vivotek.myprototype.common.DevicePrimaryKey2
import com.vivotek.myprototype.common.FeatureToggle
//import com.vivotek.myprototype.common.thumbnail.ThumbnailSeparateInfo
import com.vivotek.myprototype.common.toInstant
import java.io.File
import java.time.Instant

enum class CredentialType {
    Device,
    FaceProfile,
}

class S3Model(
    val credentialType: CredentialType,
    val region: String,
    val bucket: String,
    val key: String,
    val outPath: String, // base on context.filesDir
    val devicePrimaryKey2: DevicePrimaryKey2?,
    var forceDownload: Boolean = false,
    val timestamp: Instant? = null,
    val expire: Instant? = null,
) {
    private var outFile2: File? = null

    fun isLocalExist(context: Context): Boolean {
        val file = outFile2 ?: File("${context.filesDir}/$outPath")
        outFile2 = file
        if (!file.exists()) return false
        return file.length() > 0L
    }


    fun isLocalExpire(context: Context): Boolean {
        val file = outFile2 ?: File("${context.filesDir}/$outPath")
        outFile2 = file
        if (expire == null) return false
        val now = Instant.now()
        val featureToggle = FeatureToggle.shared()
        val interval = featureToggle.playbackThumbnailUploadInterval()
        return now > file.lastModified().toInstant().plus(interval).plus(featureToggle.LATEST_BUFFER)
    }

}