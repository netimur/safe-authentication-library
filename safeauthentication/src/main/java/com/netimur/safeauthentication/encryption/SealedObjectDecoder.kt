package com.netimur.safeauthentication.encryption

interface SealedObjectDecoder<out T> {
    fun decrypt(): T
}