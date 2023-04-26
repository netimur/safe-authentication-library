package com.netimur.safeauthentication.encryption.prebuilt

import com.netimur.safeauthentication.encryption.SealedObjectEncoder
import javax.crypto.Cipher
import javax.crypto.SealedObject

class PlainSealedObject(private val data: String, private val cipher: Cipher) :
    SealedObjectEncoder {

    private val encryptedSealedObject: SealedObject by lazy {
        SealedObject(data, cipher)
    }

    override fun encryptData(): SealedObject {
        return encryptedSealedObject
    }

}