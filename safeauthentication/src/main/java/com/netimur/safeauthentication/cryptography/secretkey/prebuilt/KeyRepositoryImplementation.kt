package com.netimur.safeauthentication.cryptography.secretkey.prebuilt

import com.netimur.safeauthentication.cryptography.keygenerator.SafeAuthKeyGenerator
import com.netimur.safeauthentication.cryptography.keystore.Keystore
import com.netimur.safeauthentication.cryptography.secretkey.KeyRepository
import javax.crypto.SecretKey

class KeyRepositoryImplementation(
    keyStore: Keystore,
    keyGenerator: SafeAuthKeyGenerator
) : AbstractKeyRepository(keyStore, keyGenerator),
    KeyRepository {
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

}