package com.netimur.safeauthentication.cryptography.cipher.prebuilt

import com.netimur.safeauthentication.cryptography.cipher.AuthorizedCipherRepository
import com.netimur.safeauthentication.cryptography.cipher.CipherRepository
import com.netimur.safeauthentication.cryptography.cipher.SafeAuthCipherRepository

class SafeAuthCipherRepositoryImplementation : SafeAuthCipherRepository,
    CipherRepository by CipherRepositoryImplementation(),
    AuthorizedCipherRepository by AuthorizedCipherRepositoryImplementation()