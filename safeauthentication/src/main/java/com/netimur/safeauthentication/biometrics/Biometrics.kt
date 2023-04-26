package com.netimur.safeauthentication.biometrics

import android.content.Context
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL

class Biometrics {
    fun getStatus(context: Context): BiometricsAvailabilityStatus {
        val status: Int =
            BiometricManager.from(context).canAuthenticate(BIOMETRIC_STRONG or DEVICE_CREDENTIAL)
        return BiometricsStatusFactoryImplementation().createStatus(status)
    }
}