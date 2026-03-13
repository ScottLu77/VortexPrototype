package com.vivotek.myprototype.uicomponent.deviceselection

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vivotek.myprototype.R
import com.vivotek.myprototype.backend.model.DeviceType.*
import com.vivotek.myprototype.common.CameraType.*
import com.vivotek.myprototype.common.DeviceItem
import com.vivotek.myprototype.common.getLatestThumbnailGlideModel
import com.vivotek.myprototype.common.uiPreview
import com.vivotek.myprototype.manager.DeviceManager
import com.vivotek.myprototype.uicomponent.common.CheckBox
import com.vivotek.myprototype.uicomponent.common.clickable2
import com.vivotek.myprototype.uicomponent.common.Thumbnail
import com.vivotek.myprototype.uicomponent.font.Caption
import com.vivotek.myprototype.uicomponent.font.Subtitle1
import com.vivotek.myprototype.uicomponent.headerbar.MenuButton
import com.vivotek.myprototype.uicomponent.icon.GeneralIcon


fun getDeviceStatusIcon(device: DeviceItem): Pair<Int?, String> = when (device.thingType) {
    unknownDevice -> R.drawable.icon_status_unknown_solid_normal to "UAT_UNKNOWN_DEVICE"
    nvr, bridge, vss -> null to "" // NVR/Bridge/VSS don't show camera status icons in row
    ipspeaker, poeSwitch -> null to ""
    else -> when { // camera, nvrchannel, vsschannel
        device.firmwareUpgrading -> when (device.cameraType) {
            Fisheye -> R.drawable.icon_status_camera_fisheye_updating_solid_normal to "UAT_FISHEYE_CAMERA_UPDATING"
            PTZ -> R.drawable.icon_status_camera_ptz_updating_solid_normal to "UAT_PTZ_CAMERA_UPDATING"
            else -> R.drawable.icon_status_camera_default_updating_solid_normal to "UAT_NORMAL_CAMERA_UPDATING"
        }
        !device.online -> when (device.cameraType) { // offline
            Fisheye -> R.drawable.icon_status_camera_fisheye_disconnected_solid_normal to "UAT_FISHEYE_CAMERA_OFFLINE"
            PTZ -> R.drawable.icon_status_camera_ptz_disconnected_solid_normal to "UAT_PTZ_CAMERA_OFFLINE"
            else -> R.drawable.icon_status_camera_default_disconnected_solid_normal to "UAT_NORMAL_CAMERA_OFFLINE"
        }
        device.recording -> when (device.cameraType) {
            Fisheye -> R.drawable.icon_status_camera_fisheye_recording_solid_normal to "UAT_FISHEYE_CAMERA_ONLINE_RECORDING"
            PTZ -> R.drawable.icon_status_camera_ptz_recording_solid_normal to "UAT_PTZ_CAMERA_ONLINE_RECORDING"
            else -> R.drawable.icon_status_camera_default_recording_solid_normal to "UAT_NORMAL_CAMERA_ONLINE_RECORDING"
        }
        else -> when (device.thingType) { // online && no_recording
            camera -> R.drawable.icon_status_alert_solid to "UAT_NORMAL_CAMERA_ONLINE_NO_RECORDING"
            else -> when (device.cameraType) {
                Fisheye -> R.drawable.icon_status_camera_fisheye_solid_normal to "UAT_FISHEYE_CAMERA_ONLINE_NO_RECORDING"
                PTZ -> R.drawable.icon_status_camera_ptz_solid_normal to "UAT_PTZ_CAMERA_ONLINE_NO_RECORDING"
                else -> R.drawable.icon_status_camera_default_solid_normal to "UAT_NORMAL_CAMERA_ONLINE_NO_RECORDING"
            }
        }
    }
}

@DrawableRes
fun getDeviceThumbnailIcon(device: DeviceItem): Int? = when (device.thingType) {
    unknownDevice -> R.drawable.illustration_non
    ipspeaker -> R.drawable.icon_general_speaker_solid
    poeSwitch -> R.drawable.icon_general_poe_solid
    nvr, vss -> when {
        device.firmwareUpgrading -> R.drawable.icon_status_device_solid_updating_dark
        device.online -> R.drawable.icon_status_device_solid_dark
        else -> R.drawable.icon_status_device_solid_disconnected_dark
    }
    bridge -> when {
        device.firmwareUpgrading -> R.drawable.icon_general_rx_updating_solid
        device.online -> R.drawable.icon_general_rx_solid
        else -> R.drawable.icon_general_rx_disconneted_solid
    }
    else -> when { // camera, nvrchannel, vsschannel
        device.firmwareUpgrading -> R.drawable.illustration_restart_dark
        else -> null // Load thumbnail from network
    }
}


/**
 * A composable that displays a device row item for device picker or device list.
 *
 * @param device The device item to display
 * @param checkedState Optional checkbox state for multi-select mode
 * @param onCheckedChange Optional callback when checkbox is toggled
 * @param menuButton Optional menu button configuration
 * @param onClick Optional callback when the row is clicked
 */
@Composable
fun LazyItemScope.DeviceRowItem(
    device: DeviceItem,
    checkedState: State<Boolean>? = null,
    onCheckedChange: ((Boolean) -> Unit)? = null,
    menuButton: MenuButton? = null,
    onClick: (() -> Unit)? = null,
) {
    Row(
        modifier = Modifier
            .animateItem()
            .fillMaxWidth()
            .height(76.dp)
            .background(colorResource(R.color.surface02))
            .clickable2(onClick)
            .semantics { testTagsAsResourceId = true }
            .testTag("deviceItemLayout"),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (checkedState != null) {
            CheckBox(
                modifier = Modifier.padding(start = 8.dp),
                checked = checkedState.value,
                onCheckedChange = { onCheckedChange?.invoke(it) },
            )
        }

        val deviceIcon = remember { getDeviceThumbnailIcon(device) }
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .size(80.dp, 60.dp)
                .background(colorResource(R.color.black)),
        ) {
            if (deviceIcon != null) {
                Image(
                    painter = painterResource(deviceIcon),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.Center),
                    colorFilter = ColorFilter.tint(colorResource(R.color.icon02))
                )
            } else {
                Thumbnail(
                    modifier = Modifier.fillMaxSize(),
                    model = device.getLatestThumbnailGlideModel(),
                )
            }
        }

        // Status icon
        val (statusIcon, statusUatDesc) = remember { getDeviceStatusIcon(device) }
        if (statusIcon != null) {
            Image(
                painter = painterResource(statusIcon),
                contentDescription = statusUatDesc,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(24.dp)
                    .testTag("statusIcon"),
            )
        }

        // Device name and description
        val name = remember {
            when (device.thingType) {
                unknownDevice -> device.mac.chunked(2).joinToString("-")
                else -> device.name
            }
        }

        val description = when (device.thingType) { // DeviceType
            unknownDevice -> device.name.ifEmpty { null }
            nvr -> {
                val count = DeviceManager.shared().findChannels(device.key).count().toString()
                stringResource(id = R.string.nvr_management_channel_count, count)
            }
            vss -> {
                val count = DeviceManager.shared().findVSSCameras(device.key).count().toString()
                stringResource(id = R.string.nvr_management_channel_count, count)
            }
            bridge -> {
                when (val count = DeviceManager.shared().findBridgePeripheral(device.key).count()) {
                    1 -> stringResource(id = R.string.bridge_device_count, count.toString())
                    else -> stringResource(id = R.string.bridge_device_count_s, count.toString())
                }
            }
            nvrchannel, vsschannel -> DeviceManager.shared().findParent(device)?.name ?: ""
            else -> null
        }

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = name,
                modifier = Modifier.testTag("deviceName"),
                style = Subtitle1,
                color = colorResource(R.color.text02),
            )
            description?.let {
                Text(
                    text = it,
                    style = Caption,
                    color = colorResource(R.color.text05),
                )
            }
        }

        // Menu button
        if (menuButton != null) {
            GeneralIcon(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .testTag("deviceMoreButton"),
                icon = menuButton.icon,
                enabled = menuButton.enabled,
                specialColor = menuButton.specialColor,
                onClick = menuButton.onClick,
            )
        }
    }
}

// ============== Previews ==============

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Composable
private fun PreviewDeviceRowItemCamera() {
    val device = DeviceItem.uiPreview().copy(
        name = "Front Door Camera",
        online = true,
        recording = true,
    )
    PreviewWrapper {
        DeviceRowItem(
            device = device,
            onClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDeviceRowItemCameraOffline() {
    val device = DeviceItem.uiPreview().copy(
        name = "Backyard Camera",
        online = false,
        recording = false,
    )
    PreviewWrapper {
        DeviceRowItem(
            device = device,
            onClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDeviceRowItemWithCheckbox() {
    val device = DeviceItem.uiPreview().copy(
        name = "Living Room Camera",
        online = true,
        recording = true,
    )
    val checkedState = remember { mutableStateOf(true) }
    PreviewWrapper {
        DeviceRowItem(
            device = device,
            checkedState = checkedState,
            onCheckedChange = {},
            onClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDeviceRowItemWithMore() {
    val device = DeviceItem.uiPreview().copy(
        name = "Garage Camera",
        online = true,
        recording = false,
        thingType = camera,
    )
    PreviewWrapper {
        DeviceRowItem(
            device = device,
            menuButton = MenuButton(
                icon = R.drawable.icon_general_more_solid,
                enabled = true,
                specialColor = R.color.icon14,
                onClick = {},
            ),
            onClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDeviceRowItemNVR() {
    val device = DeviceItem.uiPreview().copy(
        name = "Office NVR",
        thingType = nvr,
        online = true,
    )
    PreviewWrapper {
        DeviceRowItem(
            device = device,
            menuButton = MenuButton(
                icon = R.drawable.icon_general_more_solid,
                enabled = true,
                specialColor = R.color.icon14,
                onClick = {},
            ),
            onClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDeviceRowItemBridge() {
    val device = DeviceItem.uiPreview().copy(
        name = "Warehouse Bridge",
        thingType = bridge,
        online = true,
    )
    PreviewWrapper {
        DeviceRowItem(
            device = device,
            onClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDeviceRowItemUnknown() {
    val device = DeviceItem.uiPreview().copy(
        mac = "0002D1AA818C",
        name = "Unknown Camera Name",
        thingType = unknownDevice,
    )
    PreviewWrapper {
        DeviceRowItem(
            device = device,
            onClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDeviceRowItemFisheye() {
    val device = DeviceItem.uiPreview().copy(
        name = "Lobby Fisheye",
        cameraType = Fisheye,
        online = true,
        recording = true,
    )
    PreviewWrapper {
        DeviceRowItem(
            device = device,
            onClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDeviceRowItemPTZ() {
    val device = DeviceItem.uiPreview().copy(
        name = "Parking Lot PTZ",
        cameraType = PTZ,
        online = true,
        recording = true,
    )
    PreviewWrapper {
        DeviceRowItem(
            device = device,
            onClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDeviceRowItemFirmwareUpgrading() {
    val device = DeviceItem.uiPreview().copy(
        name = "Updating Camera",
        online = true,
        firmwareUpgrading = true,
    )
    PreviewWrapper {
        DeviceRowItem(
            device = device,
            onClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDeviceRowItemWithDelete() {
    val device = DeviceItem.uiPreview().copy(
        name = "Device to Delete",
        online = true,
        recording = true,
    )
    PreviewWrapper {
        DeviceRowItem(
            device = device,
            menuButton = MenuButton(
                icon = R.drawable.icon_general_delete_line,
                enabled = true,
                specialColor = R.color.icon17,
                onClick = {},
            ),
            onClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDeviceRowItemFreePlan() {
    val device = DeviceItem.uiPreview().copy(
        name = "Free Plan Camera",
        online = true,
        recording = true,
    )
    PreviewWrapper {
        DeviceRowItem(
            device = device,
            menuButton = MenuButton(
                icon = R.drawable.icon_general_more_solid,
                enabled = true,
                specialColor = R.color.icon14,
                onClick = {},
            ),
            onClick = {},
        )
    }
}

@Composable
private fun PreviewWrapper(content: @Composable LazyItemScope.() -> Unit) {
    androidx.compose.foundation.lazy.LazyColumn {
        item { content() }
    }
}
