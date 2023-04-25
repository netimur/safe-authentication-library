package com.netimur.safeauthentication.cryptography.cipher

import javax.crypto.Cipher

interface AuthorizedCipherRepository {
    fun getAuthorizedEncryptionCipher(keyAlias: String): Cipher
    fun getAuthorizedDecryptionCipher(keyAlias: String, iv: ByteArray): Cipher
}