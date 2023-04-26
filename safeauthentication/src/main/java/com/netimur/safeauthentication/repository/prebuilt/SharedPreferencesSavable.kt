package com.netimur.safeauthentication.repository.prebuilt

import android.content.SharedPreferences
import com.netimur.safeauthentication.repository.Savable

class SharedPreferencesSavable(
    private val sharedPref: SharedPreferences,
    private val value: String,
    private val key: String
) : Savable {

    override fun save() {
        with(sharedPref.edit()) {
            putString(key, value)
            apply()
        }
    }
}