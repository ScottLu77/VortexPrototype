package com.vivotek.myprototype.backend

import com.amplifyframework.datastore.generated.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vivotek.myprototype.archive.ArchiveFile
import com.vivotek.myprototype.backend.model.Device
import com.vivotek.myprototype.backend.model.UserManagementV2
import com.vivotek.myprototype.common.CloudStorageConfigItem
import com.vivotek.myprototype.common.DeviceItem
import com.vivotek.myprototype.common.UserInfo
import com.vivotek.myprototype.common.create
import com.vivotek.myprototype.backend.model.ArchiveFilterV2


open class Backend {

    fun listMyOrganization(): MutableList<MyOrganization> {
        val gson = Gson()
        val responseType = object : TypeToken<GraphQLResponse<ListMyOrganizationData>>() {}.type
        val response: GraphQLResponse<ListMyOrganizationData> = gson.fromJson(JsonContents.LIST_MY_ORGANIZATION_JSON, responseType)
        return response.data.listMyOrganization.items.toMutableList()
    }


    fun listCloudStorageConfig(): MutableList<CloudStorageConfigItem> {
        val gson = Gson()
        val responseType = object : TypeToken<GraphQLResponse<ListCloudStorageConfigData>>() {}.type
        val response: GraphQLResponse<ListCloudStorageConfigData> = gson.fromJson(JsonContents.LIST_CLOUD_STORAGE_JSON, responseType)
        return response.data.listCloudStorageConfig.items.map { CloudStorageConfigItem.create(it) }.toMutableList()
    }

    fun listDeviceInfo(organizationID: String): MutableList<DeviceItem> {
        val gson = Gson()
        val responseType = object : TypeToken<GraphQLResponse<ListDevicesDataForDevice>>() {}.type
        val response: GraphQLResponse<ListDevicesDataForDevice> = gson.fromJson(JsonContents.LIST_DEVICES_JSON, responseType)
        return response.data.listDeviceInfoOfOrganization.items.map { DeviceItem.create(it) }.toMutableList()
    }

    fun listAllUsers(organizationID: String): MutableList<UserInfo> {
        val gson = Gson()
        val responseType = object : TypeToken<GraphQLResponse<ListUsersData>>() {}.type
        val response: GraphQLResponse<ListUsersData> = gson.fromJson(JsonContents.LIST_USERS_JSON, responseType)
        return response.data.listUserOfOrganizationV2.items.map { UserInfo(it) }.toMutableList()
    }

    open fun listSIOfOrganization(organizationId: String): List<SIService> {
        val gson = Gson()
        val responseType = object : TypeToken<GraphQLResponse<ListSIOfOrganizationData>>() {}.type
        val response: GraphQLResponse<ListSIOfOrganizationData> = gson.fromJson(JsonContents.LIST_SI_OF_ORGANIZATION_JSON, responseType)
        return response.data.listSIOfOrganization.items
    }

    open fun updateMyOrganizationUserName(organizationID: String, userName: String) {

    }

    open fun fetchArchiveFileList(organizationID: String, filter: ArchiveFilterV2): List<ArchiveFile> {
        val gson = Gson()
        val responseType = object : TypeToken<GraphQLResponse<QueryArchiveData>>() {}.type
        val response: GraphQLResponse<QueryArchiveData> = gson.fromJson(JsonContents.QUERY_ARCHIVES_JSON, responseType)
        return response.data.queryArchiveV2.items.map { ArchiveFile(it) }
    }


    data class GraphQLResponse<T>(val data: T)
    data class ListMyOrganizationData(val listMyOrganization: ItemsWrapper<MyOrganization>)
    data class ListSIOfOrganizationData(val listSIOfOrganization: ItemsWrapper<SIService>)
    data class ItemsWrapper<T>(val items: List<T>)
    data class ListDevicesDataForDevice(val listDeviceInfoOfOrganization: ItemsWrapper<Device>)

    data class ListCloudStorageConfigData(val listCloudStorageConfig: ItemsWrapper<CloudStorage>)

    data class ListUsersData(val listUserOfOrganizationV2: ItemsWrapper<UserManagementV2>)
    data class QueryArchiveData(val queryArchiveV2: ItemsWrapper<Archive>)
}