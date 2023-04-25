package com.netimur.safeauthentication.cryptography.secretkey

import com.netimur.safeauthentication.cryptography.keygenerator.SafeAuthKeyGenerator
import com.netimur.safeauthentication.cryptography.keystore.Keystore
import com.netimur.safeauthentication.cryptography.secretkey.AndroidSecretKeyRepository
import javax.crypto.SecretKey

class SecretKeyRepositoryImplementation(
    private val keyStore: Keystore,
    private val keyGenerator: SafeAuthKeyGenerator
) :
    AndroidSecretKeyRepository {
    override fun getSecretKey(keyAlias: String): SecretKey {
        val key = if (keyStore.containsKey(keyAlias)) {
            keyStore.getKey(keyAlias)
        } else {
            keyGenerator.generateKey(keyAlias)
        }
        return key
    }

    override fun saveSecretKey(key: SecretKey, keyAlias: String) {
        keyStore.saveKey(key, keyAlias)
    }

    override fun getAuthorizedKey(keyAlias: String): SecretKey {
        val key = if (keyStore.containsKey(keyAlias)) {
            keyStore.getKey(keyAlias)
        } else {
            keyGenerator.generateAuthorizedKey(keyAlias)
        }
        return key
    }
}