package com.netimur.safeauthentication.cryptography.keygenerator

import javax.crypto.SecretKey

interface KeyGenerator {
    fun generateKey(keyAlias:String): SecretKey
}