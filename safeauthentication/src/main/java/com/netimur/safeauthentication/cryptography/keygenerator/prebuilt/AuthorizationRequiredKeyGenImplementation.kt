package com.netimur.safeauthentication.cryptography.keygenerator.prebuilt

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import com.netimur.safeauthentication.cryptography.keygenerator.AuthorizationRequiredKeyGenerator
import javax.crypto.SecretKey

class AuthorizationRequiredKeyGenImplementation : AbstractGenerator(), AuthorizationRequiredKeyGenerator {
    override fun generateAuthorizationRequiredKey(keyAlias: String): SecretKey {
        val algorithmSpecification: KeyGenParameterSpec = KeyGenParameterSpec.Builder(
            keyAlias, KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
        )
            .setBlockModes(BLOCK_MODE)
            .setEncryptionPaddings(PADDING)
            .setUserAuthenticationRequired(true)
            .setRandomizedEncryptionRequired(true).build()
        keyGenerator.init(algorithmSpecification)
        return keyGenerator.generateKey()
    }
}