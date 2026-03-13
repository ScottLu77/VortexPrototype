package com.vivotek.myprototype.common

enum class DeviceScope(val key: String) {
    AllUsers("/device/all-users"), // 避免使用，不特別判斷，因為會從 Server 收到資料就代表有這個權限
    Live("/device/live"),
    Playback("/device/playback"),
    Export("/device/export-video"),
    DeviceSettings("/device/settings"),
    Talkdown("/device/talkdown"),
    Lock("/device/lock"),
    Unlock("/device/unlock"),
    DeviceAdmin("/device/admin-restricted"),
    EventSnoozeOrg("/device/event/snooze-for-org"),
    ArchiveCreate("/device/archive/create"),
    ArchiveRead("/device/archive/read"),
    ArchiveUpdate("/device/archive/update"),
    ArchivePlay("/device/archive/play"),
    ArchiveDownload("/device/archive/download"),
    ArchiveShare("/device/archive/share"),
    ArchiveDelete("/device/archive/delete"),
    AiSearch("/device/ai/search"),
    AiSearchFeedback("/device/ai/search/feedback"),
    AiEventInsight("/device/ai/event-insight"),
}

enum class OrgScope(val key: String) {
    AllUsers("/org/all-users"),
    OrgAdmin("/org/admin-restricted"),
    Alarm("/org/system/alarm/*"),
    OrgDelete("/org/delete"),
    CustomizedViewSendCopy("/org/customized-view/send-copy"),
}
