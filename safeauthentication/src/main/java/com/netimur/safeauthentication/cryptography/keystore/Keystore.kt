package com.netimur.safeauthentication.cryptography.keystore

import javax.crypto.SecretKey

interface Keystore {
    fun saveKey(key: SecretKey, alias: String)
    fun getKey(alias: String): SecretKey
    fun containsKey(alias: String): Boolean
}