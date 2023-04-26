package com.netimur.safeauthentication.cryptography.secretkey.prebuilt

import com.netimur.safeauthentication.cryptography.keygenerator.SafeAuthKeyGenerator
import com.netimur.safeauthentication.cryptography.keystore.Keystore
import com.netimur.safeauthentication.cryptography.secretkey.AuthorizationRequiredKeyRepository
import javax.crypto.SecretKey

class AuthorizationRequiredKeyRepositoryImplementation(
    keystore: Keystore,
    keyGenerator: SafeAuthKeyGenerator
) : AbstractKeyRepository(keystore, keyGenerator),
    AuthorizationRequiredKeyRepository {
    override fun getAuthRequiredKey(keyAlias: String): SecretKey {
        val key = if (keyStore.containsKey(keyAlias)) {
            keyStore.getKey(keyAlias)
        } else {
            keyGenerator.generateAuthorizationRequiredKey(keyAlias)
        }
        return key
    }
}