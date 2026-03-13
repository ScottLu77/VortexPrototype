package com.vivotek.myprototype.manager

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.vivotek.myprototype.backend.Backend
import com.vivotek.myprototype.common.UserInfo


// TODO 需要實驗非 admin 的人會拿到甚麼
open class UserManager {

    companion object {

        private var _shared: UserManager = UserManager()

        fun shared(): UserManager {
            return _shared
        }
    }

    private var backend = Backend()
    private var userList = mutableListOf<UserInfo>()
    val isFetching = mutableStateOf(false)
    var orgOwner = mutableStateOf<UserInfo?>(null)
    var me = mutableStateOf<UserInfo?>(null)

    init {
        fetchUsers()
        userList.find { it.orgRole == OrgRole.Owner }?.let {
            me.value = it
        }
    }

    open fun fetchUsers() { // 3
        try {
            isFetching.value = true
            val organizationID = OrganizationInfoManager.organizationId
            userList = backend.listAllUsers(organizationID)
            orgOwner.value = userList.find { it.orgRole == OrgRole.Owner }
            userList.find { it.email == me.value!!.email }?.copy(
                id = me.value!!.id
            )?.let {
                me.value = it
            }
        } catch (e: Exception) {
            Log.e("scott", "listAllUsers Exception: $e")
        } finally {
            isFetching.value = false
        }
    }

    fun findUser(email: String): UserInfo {
        return userList.find { it.email == email } ?: UserInfo("", email, null, "")
    }

    open fun getUsers(): List<UserInfo> {
        return userList.toList()
    }

}