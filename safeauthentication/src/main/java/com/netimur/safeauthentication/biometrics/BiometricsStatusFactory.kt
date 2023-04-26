package com.netimur.safeauthentication.biometrics

interface BiometricsStatusFactory {
    fun createStatus(androidBiometricsStatus: Int): BiometricsAvailabilityStatus
}