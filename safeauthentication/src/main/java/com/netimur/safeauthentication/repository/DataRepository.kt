package com.netimur.safeauthentication.repository

interface DataRepository<out T> {
    fun saveData()
    fun restoreData(): T
}