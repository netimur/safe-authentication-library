package com.netimur.safeauthentication.cryptography.keystore

import java.security.KeyStore
import java.security.KeyStoreException
import javax.crypto.SecretKey

class AndroidKeystore : Keystore {
    companion object {
        private const val androidKeyStoreSystem: String = "AndroidKeyStore"
        private const val proprietaryKeystore: String = "jks"
    }

    private val keyStore: KeyStore = try {
        KeyStore.getInstance(androidKeyStoreSystem)
    } catch (keyStoreException: KeyStoreException) {
        KeyStore.getInstance(proprietaryKeystore)
    }


    init {
        keyStore.load(null)
    }

    override fun saveKey(key: SecretKey, alias: String) {
        keyStore.setKeyEntry(alias, key, null, null)
    }

    override fun getKey(alias: String): SecretKey {
        return keyStore.getKey(alias, null) as SecretKey
    }

    override fun containsKey(alias: String): Boolean {
        val aliasesList = keyStore.aliases()
        while (aliasesList.hasMoreElements()) {
            if (alias == aliasesList.nextElement()) {
                return true
            }
        }
        return false
    }
}