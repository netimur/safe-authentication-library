package com.netimur.safeauthentication.cryptography.algorithm

import android.security.keystore.KeyProperties
import javax.crypto.Cipher

class EmbeddedAlgorithm {
    companion object {
        public const val ALGORITHM: String = KeyProperties.KEY_ALGORITHM_AES
        public const val BLOCK_MODE: String = KeyProperties.BLOCK_MODE_CBC
        public const val PADDING: String = KeyProperties.ENCRYPTION_PADDING_PKCS7
        public const val TRANSFORMATION: String = "$ALGORITHM/$BLOCK_MODE/$PADDING"
        public const val ENCRYPT_MODE: Int = Cipher.ENCRYPT_MODE
        public const val DECRYPT_MODE: Int = Cipher.DECRYPT_MODE
    }
}