package com.vivotek.myprototype.manager

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.amplifyframework.datastore.generated.model.LicensePhase
import com.amplifyframework.datastore.generated.model.Location
import com.amplifyframework.datastore.generated.model.SupportFeature
import com.vivotek.myprototype.backend.Backend

class OrganizationInfoManager {
    companion object {
        var backend: Backend = Backend()
        var organizationId = ""
        var organizationName = ""
        var pushNotificationToken = ""
        var licensePhase by mutableStateOf<LicensePhase?>(null)
        var licensePlans: List<String> = emptyList()
        var shouldShowLicenseBanner = true
        var isFreePlan: Boolean = false
        var storageLocation: Location? = null
        var isRequiredMFA: Boolean = false
        var snoozeUntil: String = ""
        var support: List<SupportFeature> = emptyList()


        init {
            val organizationInfo = backend.listMyOrganization().firstOrNull()
            organizationInfo?.let {
                organizationId = it.organizationId
                organizationName = it.organizationName
                licensePhase = it.licensePhase
                licensePlans = it.licenseMainPlans ?: emptyList()
                isFreePlan = it.isFreePlan ?: false
                storageLocation = it.storageLocation
                isRequiredMFA = it.isRequiredMfa ?: false
                snoozeUntil = it.snoozeUntil ?: ""
                support = it.support
            }
        }

        val isLicenseOverdue get() = licensePhase == LicensePhase.RenewalOverdue

    }
}