package com.netimur.safeauthentication.encryption.prebuilt

import com.netimur.safeauthentication.encryption.SealedObjectDecoder
import javax.crypto.Cipher
import javax.crypto.SealedObject

class CipherSealedObject(
    private val sealedObject: SealedObject,
    private val decryptionCipher: Cipher
) :
    SealedObjectDecoder<String> {

    override fun decrypt(): String {
        return sealedObject.getObject(decryptionCipher) as String
    }
}