package com.netimur.safeauthentication.cryptography.cipher

import android.os.Build
import android.security.keystore.KeyProperties
import androidx.annotation.RequiresApi
import com.netimur.safeauthentication.cryptography.secretkey.SafeAuthKeyRepository
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec

class CipherRepositoryImplementation(
    private val keyRepository: SafeAuthKeyRepository
) :
    AndroidCipherRepository {
    companion object {
        private const val ALGORITHM: String = KeyProperties.KEY_ALGORITHM_AES
        private const val BLOCK_MODE: String = KeyProperties.BLOCK_MODE_CBC
        private const val PADDING: String = KeyProperties.ENCRYPTION_PADDING_PKCS7
        private const val TRANSFORMATION: String = "$ALGORITHM/$BLOCK_MODE/$PADDING"
        private const val ENCRYPT_MODE: Int = Cipher.ENCRYPT_MODE
        private const val DECRYPT_MODE: Int = Cipher.DECRYPT_MODE
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getAuthorizedEncryptionCipher(keyAlias: String): Cipher {
        val secretKey = keyRepository.getAuthorizedKey(keyAlias)
        val cipher: Cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(ENCRYPT_MODE, secretKey)
        return cipher
    }

    override fun getAuthorizedDecryptionCipher(keyAlias: String, iv: ByteArray): Cipher {
        val secretKey = keyRepository.getAuthorizedKey(keyAlias)
        val cipher: Cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(DECRYPT_MODE, secretKey, IvParameterSpec(iv))
        return cipher
    }

    override fun getEncryptionCipher(keyAlias: String): Cipher {
        val authorizedKey = keyRepository.getSecretKey(keyAlias)
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(ENCRYPT_MODE, authorizedKey)
        return cipher
    }

    override fun getDecryptionCipher(keyAlias: String, iv: ByteArray): Cipher {
        val authorizedKey = keyRepository.getSecretKey(keyAlias)
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(DECRYPT_MODE, authorizedKey, IvParameterSpec(iv))
        return cipher
    }
}