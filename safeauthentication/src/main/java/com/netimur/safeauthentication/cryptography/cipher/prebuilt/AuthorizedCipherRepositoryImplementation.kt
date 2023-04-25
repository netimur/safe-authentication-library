package com.netimur.safeauthentication.cryptography.cipher.prebuilt

import com.netimur.safeauthentication.cryptography.cipher.AuthorizedCipherRepository
import com.netimur.safeauthentication.cryptography.secretkey.prebuilt.SafeAuthKeyRepositoryImplementation
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec

class AuthorizedCipherRepositoryImplementation : AbstractCipherRepository(SafeAuthKeyRepositoryImplementation()),
    AuthorizedCipherRepository {

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
}