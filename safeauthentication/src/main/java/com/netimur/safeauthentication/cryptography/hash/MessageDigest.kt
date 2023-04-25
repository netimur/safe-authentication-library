package com.netimur.safeauthentication.cryptography.hash

interface MessageDigest {
    fun hashMessage(message: String): String
}