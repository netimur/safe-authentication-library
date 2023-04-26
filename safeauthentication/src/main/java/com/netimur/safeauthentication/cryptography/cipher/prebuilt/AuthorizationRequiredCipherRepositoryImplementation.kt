package com.netimur.safeauthentication.cryptography.cipher.prebuilt

import com.netimur.safeauthentication.cryptography.cipher.AuthorizationRequiredCipherRepository
import com.netimur.safeauthentication.cryptography.secretkey.prebuilt.SafeAuthKeyRepositoryImplementation
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec

class AuthorizationRequiredCipherRepositoryImplementation : AbstractCipherRepository(SafeAuthKeyRepositoryImplementation()),
    AuthorizationRequiredCipherRepository {

    override fun getAuthorizationRequiredEncryptionCipher(keyAlias: String): Cipher {
        val secretKey = keyRepository.getAuthRequiredKey(keyAlias)
        val cipher: Cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(ENCRYPT_MODE, secretKey)
        return cipher
    }

    override fun getAuthorizationRequiredDecryptionCipher(keyAlias: String, iv: ByteArray): Cipher {
        val secretKey = keyRepository.getAuthRequiredKey(keyAlias)
        val cipher: Cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(DECRYPT_MODE, secretKey, IvParameterSpec(iv))
        return cipher
    }
}