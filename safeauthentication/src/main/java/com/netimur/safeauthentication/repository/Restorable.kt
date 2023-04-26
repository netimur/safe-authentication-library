package com.netimur.safeauthentication.repository

interface Restorable<out T> {
    fun restore(): T
}