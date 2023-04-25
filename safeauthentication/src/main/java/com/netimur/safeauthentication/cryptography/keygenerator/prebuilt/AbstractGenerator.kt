package com.netimur.safeauthentication.cryptography.keygenerator.prebuilt

import android.security.keystore.KeyProperties
import java.security.NoSuchProviderException
import javax.crypto.KeyGenerator

abstract class AbstractGenerator {
    companion object {
        private const val ALGORITHM: String = KeyProperties.KEY_ALGORITHM_AES
        private const val ANDROID_KEYSTORE_SYSTEM: String = "AndroidKeyStore"
        const val BLOCK_MODE: String = KeyProperties.BLOCK_MODE_CBC
        const val PADDING: String = KeyProperties.ENCRYPTION_PADDING_PKCS7
    }

    protected val keyGenerator: KeyGenerator = try {
        KeyGenerator.getInstance(
            ALGORITHM,
            ANDROID_KEYSTORE_SYSTEM
        )
    } catch (providerException: NoSuchProviderException) {
        KeyGenerator.getInstance(ALGORITHM)
    }
}