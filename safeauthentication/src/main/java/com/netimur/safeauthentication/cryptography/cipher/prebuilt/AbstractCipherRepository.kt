package com.netimur.safeauthentication.cryptography.cipher.prebuilt

import android.security.keystore.KeyProperties
import com.netimur.safeauthentication.cryptography.secretkey.SafeAuthKeyRepository
import javax.crypto.Cipher

abstract class AbstractCipherRepository(
    protected val keyRepository: SafeAuthKeyRepository
) {
    protected val ALGORITHM: String = KeyProperties.KEY_ALGORITHM_AES
    protected val BLOCK_MODE: String = KeyProperties.BLOCK_MODE_CBC
    protected val PADDING: String = KeyProperties.ENCRYPTION_PADDING_PKCS7
    protected val TRANSFORMATION: String = "$ALGORITHM/$BLOCK_MODE/$PADDING"
    protected val ENCRYPT_MODE: Int = Cipher.ENCRYPT_MODE
    protected val DECRYPT_MODE: Int = Cipher.DECRYPT_MODE
}