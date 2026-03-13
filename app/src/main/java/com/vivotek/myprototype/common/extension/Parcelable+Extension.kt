package com.vivotek.myprototype.common.extension

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable

fun Parcelable.marshall(): ByteArray {
    val out = Parcel.obtain()
    out.writeParcelable(this, 0)
    val byteArray = out.marshall()
    out.recycle()
    return byteArray
}

inline fun <reified T : Parcelable> ByteArray.unmarshall(): T {
    val parcel = Parcel.obtain()
    parcel.unmarshall(this, 0, this.size)
    parcel.setDataPosition(0)
    val parcelable: T = parcel.readParcelable(T::class.java.classLoader)!!
    parcel.recycle()
    return parcelable
}

inline fun <reified T : Parcelable> Intent.getParcelable(name: String): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelableExtra(name, T::class.java)
    } else {
        @Suppress("DEPRECATION")
        getParcelableExtra(name)
    }
}

inline fun <reified T : Parcelable> Intent.getParcelableArrayList(identifierParameter: String): java.util.ArrayList<T>? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getParcelableArrayListExtra(identifierParameter, T::class.java)
    } else {
        @Suppress("DEPRECATION")
        this.getParcelableArrayListExtra(identifierParameter)
    }
}

inline fun <reified T : Parcelable> Intent.getParcelableArray(name: String): Array<T>? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelableArrayExtra(name, T::class.java)
    } else {
        @Suppress("DEPRECATION")
        getParcelableArrayExtra(name)?.map { it as T }?.toTypedArray()
    }
}

inline fun <reified T : Parcelable> Bundle.getParcelableEx(name: String): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelable(name, T::class.java)
    } else {
        @Suppress("DEPRECATION")
        getParcelable(name)
    }
}

inline fun <reified T : Parcelable> Bundle.getParcelableArrayEx(name: String): Array<T>? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelableArray(name, T::class.java)
    } else {
        @Suppress("UNCHECKED_CAST", "DEPRECATION")
        getParcelableArray(name) as Array<T>?
    }
}
