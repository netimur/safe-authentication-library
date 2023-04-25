package com.netimur.safeauthentication.cryptography.keygenerator.prebuilt

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import com.netimur.safeauthentication.cryptography.keygenerator.KeyGenerator
import javax.crypto.SecretKey

class KeyGenImplementation: AbstractGenerator(), KeyGenerator {
    override fun generateKey(keyAlias: String): SecretKey {
        val algorithmSpecification: KeyGenParameterSpec = KeyGenParameterSpec.Builder(
            keyAlias,
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
        )
            .setBlockModes(BLOCK_MODE)
            .setEncryptionPaddings(PADDING)
            .setUserAuthenticationRequired(false)
            .setRandomizedEncryptionRequired(true)
            .build()
        keyGenerator.init(algorithmSpecification)
        return keyGenerator.generateKey()
    }
}