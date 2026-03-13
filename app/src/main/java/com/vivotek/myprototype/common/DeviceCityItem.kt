package com.vivotek.myprototype.common

import com.amplifyframework.datastore.generated.model.DeviceCity
import com.vivotek.myprototype.common.extension.stringResourceId
import com.vivotek.myprototype.common.extension.timeZoneDescription

data class DeviceCityItem(val deviceCity: DeviceCity) {
    var stringResourceId = deviceCity.stringResourceId()
    var timeZoneDescription = deviceCity.timeZoneDescription()
}