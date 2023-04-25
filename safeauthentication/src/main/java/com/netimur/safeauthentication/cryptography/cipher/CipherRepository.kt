package com.netimur.safeauthentication.cryptography.cipher

import javax.crypto.Cipher

interface CipherRepository {
    fun getEncryptionCipher(keyAlias: String): Cipher
    fun getDecryptionCipher(keyAlias: String, iv: ByteArray): Cipher

}