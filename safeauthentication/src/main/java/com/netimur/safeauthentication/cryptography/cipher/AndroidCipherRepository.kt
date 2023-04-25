package com.netimur.safeauthentication.cryptography.cipher

import javax.crypto.Cipher

interface AndroidCipherRepository : CipherRepository {
    fun getAuthorizedEncryptionCipher(keyAlias: String): Cipher
    fun getAuthorizedDecryptionCipher(keyAlias: String, iv: ByteArray): Cipher
}