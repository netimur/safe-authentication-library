package com.netimur.safeauthentication.cryptography.keygenerator

import javax.crypto.SecretKey

interface AuthorizedKeyGenerator {
    fun generateAuthorizedKey(keyAlias: String): SecretKey
}