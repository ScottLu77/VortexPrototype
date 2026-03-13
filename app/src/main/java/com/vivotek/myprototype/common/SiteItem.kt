package com.vivotek.myprototype.common

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import com.vivotek.myprototype.R
import com.vivotek.myprototype.backend.model.Site


enum class SiteType {
    Device,
    Default,
    NVR,
    Bridge,
    VSS,
    AccessControlPoint,
    Sensor,
}

enum class SiteID {
    nvr,
    bridge,
    vss,
    default,
}

abstract class BaseSiteState(
    open val id: String,
    open var name: String,
    open val type: SiteType,
    @DrawableRes open val icon: Int,
    open val isExpand: MutableState<Boolean>,
    @StringRes open val nameRes: Int? = null,
)

data class SiteState(
    override val id: String,
    override var name: String,
    override val type: SiteType,
    override val icon: Int,
    override val isExpand: MutableState<Boolean> = mutableStateOf(true),
    val devices: SnapshotStateList<DeviceItem> = mutableStateListOf(),
) : BaseSiteState(id, name, type, icon, isExpand) {
    companion object {

        fun device(site: Site, devices: List<DeviceItem>) = SiteState(
            site.id,
            site.name,
            SiteType.Device,
            R.drawable.icon_general_group_solid,
            devices = devices.toMutableStateList(),
        )

        fun nvr(context: Context, devices: List<DeviceItem>) = SiteState(
            SiteID.nvr.name,
            context.getString(R.string.NVR),
            SiteType.NVR,
            R.drawable.icon_general_device_group_solid,
            devices = devices.toMutableStateList(),
        )

        fun bridge(context: Context, devices: List<DeviceItem>) = SiteState(
            SiteID.bridge.name,
            context.getString(R.string.Bridge),
            SiteType.Bridge,
            R.drawable.icon_general_rx_group_solid,
            devices = devices.toMutableStateList(),
        )

        fun vss(context: Context, devices: List<DeviceItem>) = SiteState(
            SiteID.vss.name,
            context.getString(R.string.VSS),
            SiteType.VSS,
            R.drawable.icon_general_device_group_solid,
            devices = devices.toMutableStateList(),
        )

        fun default(context: Context, devices: List<DeviceItem>) = SiteState(
            SiteID.default.name,
            context.getString(R.string.Ungrouped_Cameras),
            SiteType.Default,
            R.drawable.icon_general_ungroup_solid,
            devices = devices.toMutableStateList(),
        )

    }
}