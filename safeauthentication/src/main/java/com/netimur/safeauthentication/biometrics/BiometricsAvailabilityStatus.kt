package com.netimur.safeauthentication.biometrics

sealed class BiometricsAvailabilityStatus {
    object Success : BiometricsAvailabilityStatus()
    object ErrorNoHardware:BiometricsAvailabilityStatus()
    object ErrorHardwareUnavailable:BiometricsAvailabilityStatus()
    object ErrorNoneEnrolled:BiometricsAvailabilityStatus()
    object Unknown:BiometricsAvailabilityStatus()
}
