package com.netimur.safeauthentication.cryptography.keygenerator

import javax.crypto.SecretKey

interface AuthorizationRequiredKeyGenerator {
    fun generateAuthorizationRequiredKey(keyAlias: String): SecretKey
}