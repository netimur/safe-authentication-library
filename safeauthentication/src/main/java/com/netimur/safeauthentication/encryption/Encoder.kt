package com.netimur.safeauthentication.encryption

interface Encoder<in T> {
    fun encryptData(data: T): ByteArray
}