package com.netimur.safeauthentication.cryptography.secretkey.prebuilt

import com.netimur.safeauthentication.cryptography.keygenerator.prebuilt.SafeAuthKeyGenImplementation
import com.netimur.safeauthentication.cryptography.keygenerator.SafeAuthKeyGenerator
import com.netimur.safeauthentication.cryptography.keystore.AndroidKeystore
import com.netimur.safeauthentication.cryptography.keystore.Keystore
import com.netimur.safeauthentication.cryptography.secretkey.AuthorizedKeyRepository
import com.netimur.safeauthentication.cryptography.secretkey.KeyRepository
import com.netimur.safeauthentication.cryptography.secretkey.SafeAuthKeyRepository

class SafeAuthKeyRepositoryImplementation(
    keystore: Keystore = AndroidKeystore(),
    keygen: SafeAuthKeyGenerator = SafeAuthKeyGenImplementation()
) :
    SafeAuthKeyRepository,
    AuthorizedKeyRepository by AuthorizedKeyRepositoryImplementation(keystore, keygen),
    KeyRepository by KeyRepositoryImplementation(keystore, keygen)