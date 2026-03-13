package com.vivotek.myprototype.common.extension

fun String.isHigherVersionThan(anotherVersion: String): Boolean {
    if (anotherVersion == this) return false
    val anotherVersionArray = anotherVersion.split(".").map { it.trim().toIntOrNull() ?: 0 }
    val thisVersionArray = this.split(".").map { it.trim().toIntOrNull() ?: 0 }
    try {
        for (index in 0 until 3) {
            if (thisVersionArray[index] == anotherVersionArray[index]) continue
            else return thisVersionArray[index] > anotherVersionArray[index]
        }
        return false
    } catch (exception: Exception) {
        return false
    }
}

inline fun String?.ifNullOrEmpty(defaultValue: () -> String): String = if (isNullOrEmpty()) defaultValue() else this

fun String?.hasValue() = !isNullOrEmpty()

fun String.alarmKeyMapping(): String {
    // 因為 sensor alarm setting type 跟 message type 不同，所以需要轉換
    // 其他的 alarm 不需要
    return when(this){
        "VapeDetection" -> "VAPE_DETECTION"
        "THCDetection" -> "THC_DETECTION"
        "SmokingDetection" -> "SMOKING_DETECTION"
        "AirMaskingDetection" -> "AIR_MASKING_DETECTION"
        "HelpSounds" -> "HELP_SOUNDS"
        "AggressionSounds" -> "AGGRESSION_SOUNDS"
        "GunshotDetection" -> "GUNSHOT_DETECTION"
        "LoudSound" -> "LOUD_SOUND"
        "MotionDetection" -> "MOTION_DETECTION"
        "HighOccupancyCount" -> "HIGH_OCCUPANCY_COUNT"
        "LightLevel" -> "LIGHT_LEVEL"
        "PanicButton" -> "PANIC_BUTTON"
        "DeviceTamper" -> "DEVICE_TAMPER"
        "Temperature" -> "TEMPERATURE"
        "Humidity" -> "HUMIDITY"
        "HealthIndex" -> "HEALTH_INDEX"
        "AirQualityIndex" -> "AIR_QUALITY_INDEX"
        "CO" -> "CO"
        "CO2" -> "CO2"
        "TVOC" -> "TVOC"
        "PM1" -> "PM1"
        "PM10" -> "PM10"
        "PM2.5" -> "PM2_5"
        "NO2" -> "NO2"
        "NH3" -> "NH3"
        "Pressure" -> "PRESSURE"
        else -> {this}
    }
}