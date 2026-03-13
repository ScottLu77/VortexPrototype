package com.vivotek.myprototype.common

import com.amplifyframework.datastore.generated.model.LicensePhase
import com.amplifyframework.datastore.generated.model.SupportFeature
import com.vivotek.myprototype.RemoteConfig
import com.vivotek.myprototype.archive.ArchiveFile
import com.vivotek.myprototype.backend.model.DeviceType.*
import com.vivotek.myprototype.backend.model.Protocol
import com.vivotek.myprototype.backend.model.Site
import com.vivotek.myprototype.backend.model.SupportKey
import com.vivotek.myprototype.common.extension.isAnyOf
import com.vivotek.myprototype.main.bottombar.BottomTabItem
import com.vivotek.myprototype.manager.DeviceManager
import com.vivotek.myprototype.manager.OrganizationInfoManager
import com.vivotek.myprototype.manager.PrivilegeProvider
import java.time.Duration

open class FeatureToggle {

    companion object {

        private var _shared: FeatureToggle = FeatureToggle()

        fun shared(): FeatureToggle {
            return _shared
        }
    }

    private val deviceManager
        get() = DeviceManager.shared()

    private val privilegeProvider
        get() = PrivilegeProvider.Companion

    // MARK: - Site

    open fun canCreateSite(): Boolean {
        return hasOrgPrivilege(OrgScope.OrgAdmin)
    }

    open fun canUpdateSiteName(): Boolean {
        return hasOrgPrivilege(OrgScope.OrgAdmin)
    }

    open fun canUpdateSiteLocation(): Boolean {
        return hasOrgPrivilege(OrgScope.OrgAdmin) && RemoteConfig.featureSiteLocation
    }

    open fun canDeleteSite(site: Site): Boolean {
        return hasOrgPrivilege(OrgScope.OrgAdmin)
    }

    // MARK: - Device

    open fun canAddDevice(): Boolean {
        return hasOrgPrivilege(OrgScope.OrgAdmin)
    }

    open fun canAddPeripheralDevice(): Boolean {
        return hasOrgPrivilege(OrgScope.OrgAdmin)
    }

    open fun canMoveDevice(): Boolean {
        return hasOrgPrivilege(OrgScope.OrgAdmin)
    }

    open fun canDeleteDevice(device: DeviceItem): Boolean {
        if (device.thingType.isAnyOf(nvrchannel, vsschannel)) return false
        return hasDevicePrivilege(device, DeviceScope.DeviceAdmin)
    }

    open fun canViewNVR(): Boolean {
        return deviceManager.deviceList.any { it.thingType == nvr }
    }

    open fun canManageNVR(): Boolean {
        return canViewNVR() && hasOrgPrivilege(OrgScope.OrgAdmin)
    }

    open fun canViewVSS(): Boolean {
        return deviceManager.deviceList.any { it.thingType == vss }
    }

    open fun canShowVSSPrompt(): Boolean {
        return RemoteConfig.featureVSSPrompt
    }

    open fun canManageVSS(): Boolean {
        return canViewVSS() && hasOrgPrivilege(OrgScope.OrgAdmin)
    }

    open fun canViewBridge(): Boolean {
        return deviceManager.deviceList.any { it.thingType == bridge }
    }

    open fun canViewBridgePeripheralDevice(): Boolean {
        return !OrganizationInfoManager.isFreePlan
    }

    open fun canAccessLiveStreaming(device: DeviceItem): Boolean {
        return when (device.thingType) {
            camera, nvrchannel, vsschannel -> hasDevicePrivilege(device, DeviceScope.Live)
            else -> false
        }
    }

    open fun canAccessPlaybackStreaming(device: DeviceItem): Boolean {
        return when (device.thingType) {
            camera, nvrchannel, vsschannel -> hasDevicePrivilege(device, DeviceScope.Playback)
            else -> false
        }
    }

    open fun canAccessCloudBackupStreaming(device: DeviceItem): Boolean {
        return device.thingType == camera
    }

    open fun canArchiveVideo(device: DeviceItem): Boolean {
        if (OrganizationInfoManager.isFreePlan) return false
        return when (device.thingType) {
            camera -> hasDevicePrivilege(device, DeviceScope.ArchiveCreate)
            nvrchannel -> hasDevicePrivilege(device, DeviceScope.ArchiveCreate) && RemoteConfig.featureNVRArchive
            else -> false
        }
    }

    open fun canExportVideo(device: DeviceItem): Boolean {
        return when (device.thingType) {
            nvrchannel, vsschannel -> hasDevicePrivilege(device, DeviceScope.Export)
            else -> false
        }
    }

    // MARK: - Device Settings

    private val THUMBNAIL_UPLOAD_FREQUENCY = 1L * 60      // 多久上傳 1 次 (s)
    private val THUMBNAIL_PER_FILE = 3                    // 每次上傳內含幾張
    private val FREE_THUMBNAIL_UPLOAD_FREQUENCY = 5L * 60 // 多久上傳 1 次 (s)
    private val FREE_THUMBNAIL_PER_FILE = 1               // 每次上傳內含幾張
    val LATEST_BUFFER: Duration = Duration.ofMinutes(2) // 預估 device 會在多少時間內上傳圖片完畢

    open fun playbackThumbnailUploadInterval(): Duration {
        return if (OrganizationInfoManager.isFreePlan) {
            Duration.ofSeconds(FREE_THUMBNAIL_UPLOAD_FREQUENCY)
        } else {
            Duration.ofSeconds(THUMBNAIL_UPLOAD_FREQUENCY)
        }
    }

    open fun canUpdateSettings(device: DeviceItem): Boolean {
        if (OrganizationInfoManager.licensePhase == LicensePhase.RenewalOverdue) return false
        return when (device.thingType) {
            bridge, camera, nvr, vss, vsschannel -> hasDevicePrivilege(device, DeviceScope.DeviceSettings)
            nvrchannel -> device.wizardFinished == true && hasDevicePrivilege(device, DeviceScope.DeviceSettings)
            else -> false
        }
    }

    open fun canUpdateDeviceName(device: DeviceItem): Boolean {
        return canUpdateSettings(device)
    }

    open fun canUpdateFirmware(device: DeviceItem): Boolean {
        return when (device.thingType) {
            bridge, camera -> canUpdateSettings(device)
            nvr -> canUpdateSettings(device) &&
                    RemoteConfig.featureUpgradeNVRFirmware &&
                    device.firmwareVersion != "4.4.0.4"
            nvrchannel -> {
                val parent = findParent(device) ?: return false
                canUpdateSettings(device) &&
                        RemoteConfig.featureNvrChannelFirmwareManuallyUpdate &&
                        parent.support(SupportKey.ChannelFwUpgrade) &&
                        device.protocol == Protocol.VIVOTEK
            }
            else -> false
        }
    }

    open fun canUpdateTimezone(device: DeviceItem): Boolean {
        return when (device.thingType) {
            bridge, camera, nvr -> canUpdateSettings(device)
            else -> false
        }
    }

    open fun canSetupWizard(device: DeviceItem): Boolean {
        return when (device.thingType) {
            nvr -> hasDevicePrivilege(device, DeviceScope.DeviceAdmin)
            nvrchannel -> {
                val parent = findParent(device) ?: return false
                hasDevicePrivilege(parent, DeviceScope.DeviceAdmin)
            }
            else -> false
        }
    }

    open fun canSetOrientation(device: DeviceItem): Boolean {
        return device.thingType == camera && canUpdateSettings(device)
    }

    open fun canSetPowerLineFrequency(device: DeviceItem): Boolean {
        return device.thingType == camera && canUpdateSettings(device)
    }

    open fun canReboot(device: DeviceItem): Boolean {
        return when (device.thingType) {
            bridge, camera, nvr, vss -> hasDevicePrivilege(device, DeviceScope.DeviceSettings)
            else -> false
        }
    }

    open fun canRestore(device: DeviceItem): Boolean {
        return when (device.thingType) {
            camera -> hasDevicePrivilege(device, DeviceScope.DeviceSettings)
            else -> false
        }
    }

    open fun canControlPTZ(device: DeviceItem): Boolean {
        return when (device.thingType) {
            camera, nvrchannel, vsschannel ->
                device.cameraType == CameraType.PTZ && hasDevicePrivilege(device, DeviceScope.Live)
            else -> false
        }
    }

    open fun canControlPTZPreset(device: DeviceItem): Boolean {
        return when (device.thingType) {
            camera -> device.cameraType == CameraType.PTZ &&
                    (device.support(SupportKey.PTZ_V2) || device.support(SupportKey.PTZ_V3)) &&
                    hasDevicePrivilege(device, DeviceScope.Live)
            nvrchannel -> {
                val parent = findParent(device) ?: return false
                device.cameraType == CameraType.PTZ &&
                        (parent.support(SupportKey.PTZ_V2) || parent.support(SupportKey.PTZ_V3)) &&
                        hasDevicePrivilege(device, DeviceScope.Live)
            }
            else -> false
        }
    }

    open fun canRemoteControlDoor(device: DeviceItem): Boolean {
        val canControlDoor = hasDevicePrivilege(device, DeviceScope.Lock) ||
                hasDevicePrivilege(device, DeviceScope.Unlock)
        return !OrganizationInfoManager.isFreePlan && canControlDoor
    }

    open fun canViewDeviceSpeaker(device: DeviceItem): Boolean {
        return RemoteConfig.featureTwoWayAudio &&
                device.support(SupportKey.AUDIO_OUT) &&
                hasDevicePrivilege(device, DeviceScope.DeviceSettings)
    }

    open fun canTalkToDeviceSpeaker(device: DeviceItem): Boolean {
        return canViewDeviceSpeaker(device) && device.mainLicenseType != LicenseType.XPro
    }

    open fun canViewDeviceInformation(device: DeviceItem): Boolean {
        return device.thingType != unknownDevice && device.wizardFinished != false
    }

    open fun canUpgradeOutdatedFirmware(): Boolean {
        return RemoteConfig.featureUpgradeOutdatedFirmware
    }

    open fun canAccessStreaming(archive: ArchiveFile): Boolean {
        val device = deviceManager.findDevice(archive.deviceID) ?: return false
        return hasDevicePrivilege(device, DeviceScope.ArchivePlay)
    }
    open fun canShare(archive: ArchiveFile): Boolean {
        val device = deviceManager.findDevice(archive.deviceID) ?: return false
        return hasDevicePrivilege(device, DeviceScope.ArchiveShare)
    }
    open fun canDownload(archive: ArchiveFile): Boolean {
        val device = deviceManager.findDevice(archive.deviceID) ?: return false
        return hasDevicePrivilege(device, DeviceScope.ArchiveDownload)
    }
    open fun canDelete(archive: ArchiveFile): Boolean {
        val device = deviceManager.findDevice(archive.deviceID) ?: return false
        return hasDevicePrivilege(device, DeviceScope.ArchiveDelete)
    }

    // MARK: - AI

    open fun canSetAIControls(): Boolean {
        return RemoteConfig.featureSupportAIControlSettings && hasOrgPrivilege(OrgScope.OrgAdmin)
    }

    // MARK: - Snooze Rule

    open fun canSnoozeMessage(): Boolean {
        return RemoteConfig.featureSnoozeMessage
    }

    open fun canSnoozeAllForMe(): Boolean {
        return RemoteConfig.featureSnoozeAll
    }

    open fun canViewSnoozeRule(device: DeviceItem): Boolean {
        return canSnoozeMessage() && hasDevicePrivilege(device, DeviceScope.AllUsers)
    }

    open fun canNewEveryoneSnoozeRule(device: DeviceItem): Boolean {
        return canSnoozeMessage() && hasDevicePrivilege(device, DeviceScope.EventSnoozeOrg)
    }

    open fun canEditEveryoneSnoozeRule(device: DeviceItem): Boolean {
        return canSnoozeMessage() && hasDevicePrivilege(device, DeviceScope.EventSnoozeOrg)
    }

    open fun canNewOnlyMeSnoozeRule(device: DeviceItem): Boolean {
        return canSnoozeMessage() && hasDevicePrivilege(device, DeviceScope.AllUsers)
    }

    open fun canEditOnlyMeSnoozeRule(device: DeviceItem): Boolean {
        return canSnoozeMessage() && hasDevicePrivilege(device, DeviceScope.AllUsers)
    }

    // MARK: - Alarm Setting

    open fun canViewAlarmManagement(): Boolean {
        return hasOrgPrivilege(OrgScope.Alarm)
    }

    // MARK: - Customized View

    open fun canShareCustomizedView(): Boolean {
        return hasOrgPrivilege(OrgScope.CustomizedViewSendCopy)
    }

    // MARK: - Organization & System

    open fun canViewOrganizationInfo(): Boolean {
        return hasOrgPrivilege(OrgScope.OrgAdmin)
    }

    open fun canManageDataStorageLocation(): Boolean {
        return RemoteConfig.featureMultipleStorageLocation
    }

    open fun canReceivePushNotification(): Boolean {
        return true
    }

    // MARK: - User Management & Authentication

    open fun canSignInWithSSO(): Boolean {
        return RemoteConfig.featureSignInWithSSO
    }

    open fun canSetMFAOnAccount(): Boolean {
        return RemoteConfig.featureMFA
    }

    // MARK: - Reseller & License

    open fun canManageReseller(): Boolean {
        return hasOrgPrivilege(OrgScope.OrgAdmin)
    }

    open fun canUpgradeLicensePlan(): Boolean {
        return OrganizationInfoManager.isFreePlan && hasOrgPrivilege(OrgScope.OrgAdmin)
    }

    open fun canRenewLicense(): Boolean {
        return canManageReseller() &&
                OrganizationInfoManager.licensePhase != LicensePhase.GracePeriod &&
                OrganizationInfoManager.licensePhase != LicensePhase.RenewalOverdue
    }

    open fun canShowResellerBindingHint(): Boolean {
        return RemoteConfig.featureAddResellerHint && canManageReseller()
    }

    open fun canToggleAutoSendSystemIssue(): Boolean {
        return canManageReseller() && RemoteConfig.featureAutoSendSystemEvent
    }

    open fun canOpenStreamingPage(): Boolean {
        return OrganizationInfoManager.licensePhase != LicensePhase.RenewalOverdue
    }

    // MARK: - UI & Navigation

    open fun canView(tab: BottomTabItem): Boolean {
        return when (tab) {
            BottomTabItem.View -> hasAnyDeviceWithPrivilege(DeviceScope.Live)
            BottomTabItem.CustomView -> RemoteConfig.featureCustomizedView && hasOrgPrivilege(OrgScope.AllUsers)
            BottomTabItem.Message -> hasAnyDeviceWithPrivilege(DeviceScope.AllUsers)
            BottomTabItem.Archive -> OrganizationInfoManager.isFreePlan || hasAnyDeviceWithPrivilege(DeviceScope.ArchiveRead)
            BottomTabItem.AIHub -> OrganizationInfoManager.isFreePlan ||
                    hasAnyDeviceWithPrivilege(DeviceScope.AiSearch) ||
                    hasAnyDeviceWithPrivilege(DeviceScope.AiEventInsight)
            BottomTabItem.ThinkSearch -> OrganizationInfoManager.isFreePlan || hasAnyDeviceWithPrivilege(DeviceScope.AiSearch)
            BottomTabItem.SearchLight -> false
            BottomTabItem.FloorPlan -> OrganizationInfoManager.support.contains(SupportFeature.FloorPlan)
            else -> true
        }
    }

    open fun canAccess(tab: BottomTabItem): Boolean {
        return when (tab) {
            BottomTabItem.Archive -> !OrganizationInfoManager.isFreePlan
            BottomTabItem.AIHub -> {
                val hasXProPlanDevice = deviceManager.deviceList.any {
                    it.mainLicenseType == LicenseType.XPro
                }
                !OrganizationInfoManager.isFreePlan && hasXProPlanDevice
            }
            else -> true
        }
    }

    open fun canTouch(tab: BottomTabItem): Boolean {
        return when (tab) {
            BottomTabItem.View, BottomTabItem.More -> true
            else -> !OrganizationInfoManager.isLicenseOverdue
        }
    }

    // MARK: - Helper Methods

    private fun findParent(device: DeviceItem): DeviceItem? {
        return deviceManager.deviceList.firstOrNull {
            it.mac == device.mac && it.derivant == DERIVANT_NONE
        }
    }

    private fun hasAnyDeviceWithPrivilege(privilege: DeviceScope): Boolean {
        return hasAllDevicesPrivilege(privilege) ||
                deviceManager.deviceList.any { privilegeProvider.canDoDevice(it.key2, privilege) }
    }

    private fun hasAllDevicesPrivilege(privilege: DeviceScope): Boolean {
        val allDevices = DevicePrimaryKey2("?", "?")
        return privilegeProvider.canDoDevice(allDevices, privilege)
    }

    private fun hasOrgPrivilege(privilege: OrgScope): Boolean {
        return privilegeProvider.canDoOrg(privilege)
    }

    private fun hasDevicePrivilege(device: DeviceItem, privilege: DeviceScope): Boolean {
        return privilegeProvider.canDoDevice(device.key2, privilege)
    }
}