package com.netimur.safeauthentication.cryptography.hash

interface MessageDigestRepository {
    fun getMessageDigest(): java.security.MessageDigest
}