package com.netimur.safeauthentication.cryptography.secretkey

import com.netimur.safeauthentication.cryptography.keygenerator.SafeAuthKeyGenImplementation
import com.netimur.safeauthentication.cryptography.keygenerator.SafeAuthKeyGenerator
import com.netimur.safeauthentication.cryptography.keystore.AndroidKeystore
import com.netimur.safeauthentication.cryptography.keystore.Keystore

class SafeAuthKeyRepositoryImplementation(
    keystore: Keystore = AndroidKeystore(),
    keygen: SafeAuthKeyGenerator = SafeAuthKeyGenImplementation()
) :
    SafeAuthKeyRepository,
    AuthorizedKeyRepository by AuthorizedKeyRepositoryImplementation(keystore, keygen),
    KeyRepository by KeyRepositoryImplementation(keystore, keygen)