package com.vivotek.myprototype.common

@Suppress("unused")
enum class CarotaOTAState {
    Connected,
    Received,
    Cancel,
    Downloading,
    DownloadSuccess,
    DownloadFailed,
    MD5ValidationSuccess,
    MD5ValidationFailed,
    PKIValidationSuccess,
    PKIValidationFailed,
    Upgrading,            // 10
    UpgradeSuccess,       // 11
    UpgradeFailed,        // 12
    RollbackSuccess,
    RollbackFailed;

    companion object {
        private val FIRMWARE_UPGRADING_ORDINALS = setOf(
            Downloading.ordinal,
            DownloadSuccess.ordinal,
            Upgrading.ordinal,
        )

        fun isFirmwareUpgrading(stateOrdinal: Int?): Boolean =
            stateOrdinal in FIRMWARE_UPGRADING_ORDINALS
    }
}