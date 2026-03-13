package com.vivotek.myprototype.manager

import androidx.compose.runtime.mutableStateListOf
import com.vivotek.myprototype.backend.Api
import com.vivotek.myprototype.backend.Backend
import com.vivotek.myprototype.backend.model.DeviceType.*
import com.vivotek.myprototype.backend.model.Site
import com.vivotek.myprototype.common.DeviceItem
import com.vivotek.myprototype.common.DevicePrimaryKey
import com.vivotek.myprototype.common.DevicePrimaryKey2


open class DeviceManager {

    companion object {

        private var _shared: DeviceManager = DeviceManager()

        fun shared(): DeviceManager {
            return _shared
        }
    }

    private var backend = Backend()
    private var api = Api()

    var sites = mutableStateListOf<Site>()
    var deviceList = mutableStateListOf<DeviceItem>()

    init {
        fetchDevices()
    }

    open fun fetchDevices() {
        val organizationID = OrganizationInfoManager.organizationId

        sites.clear()
        deviceList.clear()

        sites.addAll(api.getSites())
        deviceList.addAll(backend.listDeviceInfo(organizationID).sortedBy { it.derivant != "none" })
    }

    open fun findDevice(pk: DevicePrimaryKey): DeviceItem? {
        return deviceList.find { it.mac == pk.mac && it.derivant == pk.derivant }
    }

    open fun findDevice(pk: DevicePrimaryKey2): DeviceItem? {
        return deviceList.find { it.thingName == pk.thingName && it.derivant == pk.derivant }
    }

    fun findParent(child: DeviceItem?): DeviceItem? {
        child ?: return null
        return deviceList.find { it.mac == child.mac && it.derivant == "none" }
    }

    fun findChannels(nvr: DevicePrimaryKey): List<DeviceItem> { // DeviceType
        return deviceList.filter { it.mac == nvr.mac && it.thingType == nvrchannel }
    }

    fun findBridgePeripheral(bridge: DevicePrimaryKey): List<DeviceItem> { // DeviceType
        return deviceList.filter { (it.mac == bridge.mac && it.thingType == poeSwitch) || (it.mac == bridge.mac && it.thingType == ipspeaker) }
    }

    fun findVSSCameras(vss: DevicePrimaryKey): List<DeviceItem> { // DeviceType
        return deviceList.filter { it.mac == vss.mac && it.thingType == vsschannel }
    }


}