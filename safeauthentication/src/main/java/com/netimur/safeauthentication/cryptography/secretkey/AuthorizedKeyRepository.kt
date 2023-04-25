package com.netimur.safeauthentication.cryptography.secretkey

import javax.crypto.SecretKey

interface AuthorizedKeyRepository {
    fun getAuthorizedKey(keyAlias: String): SecretKey
}