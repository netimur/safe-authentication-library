package com.netimur.safeauthentication.cryptography.secretkey.prebuilt

import com.netimur.safeauthentication.cryptography.keygenerator.SafeAuthKeyGenerator
import com.netimur.safeauthentication.cryptography.keystore.Keystore
import com.netimur.safeauthentication.cryptography.secretkey.AuthorizedKeyRepository
import javax.crypto.SecretKey

class AuthorizedKeyRepositoryImplementation(
    keystore: Keystore,
    keyGenerator: SafeAuthKeyGenerator
) : AbstractKeyRepository(keystore, keyGenerator),
    AuthorizedKeyRepository {
    override fun getAuthorizedKey(keyAlias: String): SecretKey {
        val key = if (keyStore.containsKey(keyAlias)) {
            keyStore.getKey(keyAlias)
        } else {
            keyGenerator.generateAuthorizedKey(keyAlias)
        }
        return key
    }
}