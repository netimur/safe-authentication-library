package com.netimur.safeauthentication.encryption.prebuilt

import com.netimur.safeauthentication.encryption.Encoder
import javax.crypto.Cipher

class EncoderImplementation(private val cipher: Cipher) : Encoder<String> {

    override fun encryptData(data: String): ByteArray {
        return cipher.doFinal(data.toByteArray())
    }
}