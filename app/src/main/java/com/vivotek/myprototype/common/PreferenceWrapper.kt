package com.vivotek.myprototype.common

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.core.content.edit

open class PreferenceWrapper {

    companion object {
        const val KEY_ACCOUNT = "account"
        const val KEY_FIRST_NAME = "first_name"
        const val KEY_LAST_NAME = "last_name"
        const val KEY_SELECTED_MAIN_VIEW_TAB = "selected_main_view_tab"
        const val KEY_SITE = "site"
        const val KEY_RESOLVED_EVENT_ID = "resolved_event_id"
        const val KEY_LAST_CREATED_LOCATION = "last_created_location"
        const val KEY_THEME_MODE = "theme_mode"
        const val KEY_REMOTE_ACCESS = "remote_access"
        const val KEY_BOTTOM_TABS = "bottom_tabs"
        const val KEY_DRAG_AND_DROP_HINT = "drag_and_drop_hint"
    }

    private fun getAppPreferences(context: Context) = context.getSharedPreferences("Default", MODE_PRIVATE)

    open fun putStringSet(context: Context, key: String, value: String) {
        val preference = getAppPreferences(context)
        val originalStringSet = getStringSet(context, key)
        val newStringSet = mutableSetOf<String>()

        originalStringSet.forEach { newStringSet.add(it) }
        newStringSet.add(value)
        preference.edit { putStringSet(key, newStringSet) }
    }

    open fun getStringSet(context: Context, key: String): MutableSet<String> {
        val preference = getAppPreferences(context)
        return preference.getStringSet(key, mutableSetOf()) ?: mutableSetOf()
    }

    open fun putString(context: Context, key: String, value: String) {
        val preference = getAppPreferences(context)
        preference.edit { putString(key, value) }
    }

    open fun getString(context: Context, key: String): String {
        val preference = getAppPreferences(context)
        return preference.getString(key, "") ?: ""
    }

    open fun getString(context: Context, key: String, defValue: String): String {
        val preference = getAppPreferences(context)
        return preference.getString(key, defValue) ?: defValue
    }

    open fun putInt(context: Context, key: String, value: Int) {
        val preference = getAppPreferences(context)
        preference.edit { putInt(key, value) }
    }

    open fun getInt(context: Context, key: String, default: Int = 0): Int {
        val preference = getAppPreferences(context)
        return preference.getInt(key, default)
    }

    open fun putBoolean(context: Context, key: String, value: Boolean) {
        val preference = getAppPreferences(context)
        preference.edit { putBoolean(key, value) }
    }

    open fun getBoolean(context: Context, key: String, default: Boolean = false): Boolean {
        val preference = getAppPreferences(context)
        return preference.getBoolean(key, default)
    }

    open fun getBoolean(context: Context, key: String): Boolean? {
        val preference = getAppPreferences(context)
        return if (preference.contains(key)) {
            preference.getBoolean(key, false)
        } else {
            null
        }
    }
}