package com.netimur.safeauthentication.encryption

import javax.crypto.SealedObject

interface SealedObjectEncoder {
    fun encryptData(): SealedObject
}