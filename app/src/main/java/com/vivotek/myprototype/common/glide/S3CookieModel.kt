package com.vivotek.myprototype.common.glide

import com.vivotek.myprototype.archive.ArchiveFile

class S3CookieModel(
    val thumbnails3Key: String,
    val outFilePath: String, // base on context.filesDir
    val createAt: String,
    val thingName: String,
    var cookie: String? = null,
)

fun ArchiveFile.S3CookieModel(): S3CookieModel {
    return S3CookieModel(
        thumbnails3Key,
        thumbnailLocalFileName,
        createdAt,
        thingName
    )
}