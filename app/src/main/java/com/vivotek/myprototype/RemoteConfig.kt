package com.vivotek.myprototype

class RemoteConfig {
    companion object {
        var featureUpgradeNVRFirmware = true
        var featureUpgradeOutdatedFirmware = true
        var featureMultipleStorageLocation = true
        var featureNVRArchive = true
        var isNeedForceUpdate = true
        var featureSignInWithSSO = true
        var featureStorageLocations = ""
        var featureMFA = true
        var featureNewForceUpdate = true
        var requiredVersion = ""
        var requiredVersionCode = 0
        var featureSnoozeMessage = true
        var featureSnoozeAll = true
        var featureSiteLocation = true
        var featureSupportVCAEvent = ""
        var featureSupportAIControlSettings = true
        var featureAddResellerHint = true
        var featureSmartSensor = true
        var resellerRequestURL = "" // MN 的話，目前是空字串，要注意判斷
        var unknownDeviceTroubleshootingURL = "" // MN 的話，目前是空字串，要注意判斷
        var featureCustomizedView = true
        var dataDonationInfoURL = ""
        var featureVSSPrompt = true
        var featureTwoWayAudio = true
        var featureAutoSendSystemEvent = true
        var featureNvrChannelFirmwareManuallyUpdate = true
        var featurePatrol = true
    }
}