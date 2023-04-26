package com.netimur.safeauthentication.encryption

interface Decoder<out T> {
    fun decryptData(encryptedData: ByteArray): T
}