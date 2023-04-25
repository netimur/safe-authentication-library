package com.netimur.safeauthentication.cryptography.cipher.prebuilt

import android.os.Build
import android.security.keystore.KeyProperties
import androidx.annotation.RequiresApi
import com.netimur.safeauthentication.cryptography.cipher.CipherRepository
import com.netimur.safeauthentication.cryptography.cipher.SafeAuthCipherRepository
import com.netimur.safeauthentication.cryptography.secretkey.SafeAuthKeyRepository
import com.netimur.safeauthentication.cryptography.secretkey.prebuilt.SafeAuthKeyRepositoryImplementation
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec

class CipherRepositoryImplementation(
) : AbstractCipherRepository(SafeAuthKeyRepositoryImplementation()), CipherRepository {

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