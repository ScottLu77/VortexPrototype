package com.vivotek.myprototype.common

import android.os.Parcelable
import android.text.Spannable
import androidx.core.text.getSpans
import androidx.emoji2.text.EmojiCompat
import androidx.emoji2.text.EmojiSpan
import com.vivotek.myprototype.backend.model.UserManagementV2
import com.vivotek.myprototype.manager.OrgRole
import com.vivotek.myprototype.backend.model.RoleOrgAdminID
import com.vivotek.myprototype.backend.model.RoleOrgMemberID
import com.vivotek.myprototype.backend.model.RoleOrgOwnerID
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfo(
    val id: String, // 只有 me 會有資料
    val email: String,
    val orgRole: OrgRole?,
    private var userName: String,
    var userNameEx: String = "",
    var initialLetter: String = "",
) : Parcelable {

    constructor(user: UserManagementV2) : this(
        "",
        user.email,
        when (user.role.id) {
            RoleOrgOwnerID -> OrgRole.Owner
            RoleOrgAdminID -> OrgRole.Admin
            RoleOrgMemberID -> OrgRole.Member
            else -> OrgRole.Custom
        },
        user.username ?: "",
    )

    init {
        updateUserNameEx()
        updateInitialLetter()
    }

    fun getUserName(): String {
        return userName
    }

    fun setUserName(userName: String) { // 2
        this.userName = userName
        updateUserNameEx()
        updateInitialLetter()
    }

    private fun updateUserNameEx() {
        if (userName.isNotEmpty()) {
            userNameEx = userName
            return
        }
        userNameEx = email.substringBefore("@")
    }

    private fun updateInitialLetter() {
        if (userNameEx.isEmpty()) {
            initialLetter = ""
            return
        }
        initialLetter = userNameEx.take(1).uppercase()
    }
}
