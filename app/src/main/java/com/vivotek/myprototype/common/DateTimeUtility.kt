package com.vivotek.myprototype.common

import android.content.Context
import com.vivotek.myprototype.R
import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

open class DateTimeUtility {
    open fun now(): Instant {
        return Instant.now()
    }
}

fun Instant.toString(format: String, zone: ZoneId = ZoneId.systemDefault()): String {
    val formatter = DateTimeFormatter.ofPattern(format).withZone(zone)
    return formatter.format(this)
}

fun Instant.toUTCString(): String = toString("yyyy-MM-dd'T'HH:mm:ss'Z'", ZoneOffset.UTC)
fun Instant.toUTCString2(): String = toString("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", ZoneOffset.UTC) // 根據 Backend 群的決議，之後會慢慢陸續統一成這個格式
fun Instant.toLocalDateTime(): LocalDateTime = LocalDateTime.ofInstant(this, ZoneId.systemDefault())
fun Instant.minusMinutes(minutes: Long): Instant = minus(minutes, ChronoUnit.MINUTES)
fun Instant.minusHours(hours: Long): Instant = minus(hours, ChronoUnit.HOURS)
fun Instant.plusMinutes(minutes: Long): Instant = plus(minutes, ChronoUnit.MINUTES)
fun Instant.plusHours(hours: Long): Instant = plus(hours, ChronoUnit.HOURS)
fun Instant.plusDays(days: Long): Instant = plus(days, ChronoUnit.DAYS)
fun Long.toInstant(): Instant = Instant.ofEpochMilli(this)
fun String.toInstant(format: String, zone: ZoneId = ZoneId.systemDefault()): Instant {
    val formatter = DateTimeFormatter.ofPattern(format).withZone(zone)
    return Instant.from(formatter.parse(this))
}

fun LocalDateTime.toInstant(): Instant {
    val zonedDateTime = ZonedDateTime.of(this, ZoneId.systemDefault())
    return zonedDateTime.toInstant()
}

@Suppress("LocalVariableName")
fun Duration.toString(context: Context): String { // 目前會忽略奈秒
    if (isZero) {
        return context.getString(R.string.x_sec, 0)
    }
    val SECONDS_PER_HOUR = 60 * 60
    val SECONDS_PER_MINUTE = 60
    val hours = (seconds / SECONDS_PER_HOUR).toInt()
    val minutes = ((seconds % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE).toInt()
    val secs = (seconds % SECONDS_PER_MINUTE).toInt()
    var text = ""
    if (hours != 0) {
        text += context.getString(R.string.x_hour, hours)
    }
    if (minutes != 0) {
        if (hours != 0) text += " "
        text += context.getString(R.string.x_min, minutes)
    }
    if (secs != 0) {
        if (hours != 0 || minutes != 0) text += " "
        text += context.getString(R.string.x_sec, secs)
    }
    return text
}
