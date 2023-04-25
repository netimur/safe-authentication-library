package com.netimur.safeauthentication.cryptography.secretkey

import javax.crypto.SecretKey

interface KeyRepository {
    fun getSecretKey(keyAlias: String): SecretKey
    fun saveSecretKey(key: SecretKey, keyAlias: String)
}