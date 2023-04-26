package com.netimur.safeauthentication.biometrics

import androidx.biometric.BiometricManager

class BiometricsStatusFactoryImplementation : BiometricsStatusFactory {
    override fun createStatus(androidBiometricsStatus: Int): BiometricsAvailabilityStatus {
        return when (androidBiometricsStatus) {
            BiometricManager.BIOMETRIC_SUCCESS -> BiometricsAvailabilityStatus.Success
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> BiometricsAvailabilityStatus.ErrorHardwareUnavailable
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> BiometricsAvailabilityStatus.ErrorNoHardware
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> BiometricsAvailabilityStatus.ErrorNoneEnrolled
            else -> BiometricsAvailabilityStatus.Unknown
        }
    }
}