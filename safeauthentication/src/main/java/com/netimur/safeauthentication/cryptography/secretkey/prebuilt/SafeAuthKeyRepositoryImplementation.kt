package com.netimur.safeauthentication.cryptography.secretkey.prebuilt

import com.netimur.safeauthentication.cryptography.keygenerator.prebuilt.SafeAuthKeyGenImplementation
import com.netimur.safeauthentication.cryptography.keygenerator.SafeAuthKeyGenerator
import com.netimur.safeauthentication.cryptography.keystore.AndroidKeystore
import com.netimur.safeauthentication.cryptography.keystore.Keystore
import com.netimur.safeauthentication.cryptography.secretkey.AuthorizationRequiredKeyRepository
import com.netimur.safeauthentication.cryptography.secretkey.KeyRepository
import com.netimur.safeauthentication.cryptography.secretkey.SafeAuthKeyRepository

class SafeAuthKeyRepositoryImplementation(
    keystore: Keystore = AndroidKeystore(),
    keygen: SafeAuthKeyGenerator = SafeAuthKeyGenImplementation()
) :
    SafeAuthKeyRepository,
    AuthorizationRequiredKeyRepository by AuthorizationRequiredKeyRepositoryImplementation(keystore, keygen),
    KeyRepository by KeyRepositoryImplementation(keystore, keygen)