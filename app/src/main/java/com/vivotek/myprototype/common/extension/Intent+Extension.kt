package com.vivotek.myprototype.common.extension

import android.content.Intent
import android.os.Build
import java.io.Serializable

inline fun <reified T : Serializable?> Intent.getSerializable(name: String): T {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getSerializableExtra(name, T::class.java) as T
    } else {
        @Suppress("DEPRECATION")
        getSerializableExtra(name) as T
    }
}