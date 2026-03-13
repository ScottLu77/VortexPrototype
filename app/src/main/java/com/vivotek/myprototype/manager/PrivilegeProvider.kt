package com.vivotek.myprototype.manager

import com.vivotek.myprototype.common.DevicePrimaryKey2
import com.vivotek.myprototype.common.DeviceScope
import com.vivotek.myprototype.common.OrgScope


enum class OrgRole {
    Owner,
    Admin,
    Member,
    Custom,
}

interface BasePrivilegeProvider {
    fun canDoOrg(scope: OrgScope): Boolean
    fun canDoDevice(key: DevicePrimaryKey2, scope: DeviceScope): Boolean
}

class PrivilegeProvider {

    companion object : BasePrivilegeProvider {
        override fun canDoOrg(scope: OrgScope): Boolean {
            return true
        }

        override fun canDoDevice(key: DevicePrimaryKey2, scope: DeviceScope): Boolean {
            return true
        }

    }
}