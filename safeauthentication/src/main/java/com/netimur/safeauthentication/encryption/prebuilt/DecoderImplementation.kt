package com.netimur.safeauthentication.encryption.prebuilt

import com.netimur.safeauthentication.encryption.Decoder
import javax.crypto.Cipher

class DecoderImplementation(private val decryptionCipher: Cipher) : Decoder<String> {
    override fun decryptData(encryptedData: ByteArray): String {
        return String(decryptionCipher.doFinal(encryptedData))
    }
}