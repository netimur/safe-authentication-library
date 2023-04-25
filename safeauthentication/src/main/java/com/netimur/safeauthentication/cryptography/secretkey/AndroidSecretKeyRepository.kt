package com.netimur.safeauthentication.cryptography.secretkey

import javax.crypto.SecretKey

interface AndroidSecretKeyRepository : SecretKeyRepository {
    fun getAuthorizedKey(keyAlias: String): SecretKey
}