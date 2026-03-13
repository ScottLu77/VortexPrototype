package com.vivotek.myprototype.backend.model

import com.google.gson.annotations.SerializedName

const val RoleOrgOwnerID = "role-org-owner"
const val RoleOrgAdminID = "role-org-admin"
const val RoleOrgMemberID = "role-org-member"

data class RoleAssignment(
    // role-org-owner
    // role-org-admin
    // role-org-member
    // role-{uuid}     // role-org-member
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
)

data class UserManagementV2(
    // 因為 Server 都給空字串，所以就乾脆不接了
//    @SerializedName("userSub")
//    val id: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("organizationID")
    val organizationID: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("role")
    val role: RoleAssignment,
    @SerializedName("onBoard")
    val onBoard: Boolean?,
    @SerializedName("username")
    val username: String?,
)
