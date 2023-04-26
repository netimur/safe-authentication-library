package com.netimur.safeauthentication.repository.prebuilt

import android.content.SharedPreferences
import com.netimur.safeauthentication.repository.Restorable

class SharedPreferencesRestorable(
    private val sharedPref: SharedPreferences,
    private val key: String
) : Restorable<String> {
    private val defaultValue: String = ""

    override fun restore(): String {
        return sharedPref.getString(key, defaultValue) ?: defaultValue
    }

}