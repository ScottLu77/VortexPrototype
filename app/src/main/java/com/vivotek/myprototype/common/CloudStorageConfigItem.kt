package com.vivotek.myprototype.common

import com.amplifyframework.datastore.generated.model.CloudStorage
import com.amplifyframework.datastore.generated.model.Location

data class CloudStorageConfigItem(
    val location: Location,
    val deviceStorage: String,
    val deviceStorageRegion: String
) {
    companion object
}

fun CloudStorageConfigItem.Companion.create(cloudStorage: CloudStorage) = CloudStorageConfigItem(
    location = cloudStorage.location,
    deviceStorage = cloudStorage.storages?.device?.name ?: "",
    deviceStorageRegion = cloudStorage.storages?.device?.region ?: ""
)

fun CloudStorageConfigItem.Companion.create(location: Location, deviceStorage: String, deviceStorageRegion: String) = CloudStorageConfigItem(
    location = location,
    deviceStorage = deviceStorage,
    deviceStorageRegion = deviceStorageRegion
)