package com.netimur.safeauthentication.cryptography.secretkey

import javax.crypto.SecretKey

interface AuthorizationRequiredKeyRepository {
    fun getAuthRequiredKey(keyAlias: String): SecretKey
}