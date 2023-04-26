package com.netimur.safeauthentication.cryptography.cipher

import javax.crypto.Cipher

interface AuthorizationRequiredCipherRepository {
    fun getAuthorizationRequiredEncryptionCipher(keyAlias: String): Cipher
    fun getAuthorizationRequiredDecryptionCipher(keyAlias: String, iv: ByteArray): Cipher
}