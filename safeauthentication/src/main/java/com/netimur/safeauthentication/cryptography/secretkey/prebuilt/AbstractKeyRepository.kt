package com.netimur.safeauthentication.cryptography.secretkey.prebuilt

import com.netimur.safeauthentication.cryptography.keygenerator.SafeAuthKeyGenerator
import com.netimur.safeauthentication.cryptography.keystore.Keystore

abstract class AbstractKeyRepository(
    protected val keyStore: Keystore,
    protected val keyGenerator: SafeAuthKeyGenerator
) {
}