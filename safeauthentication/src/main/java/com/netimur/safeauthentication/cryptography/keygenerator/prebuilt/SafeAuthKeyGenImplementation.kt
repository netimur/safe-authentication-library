package com.netimur.safeauthentication.cryptography.keygenerator.prebuilt

import com.netimur.safeauthentication.cryptography.keygenerator.*

class SafeAuthKeyGenImplementation :
    SafeAuthKeyGenerator,
    KeyGenerator by KeyGenImplementation(),
    AuthorizedKeyGenerator by AuthorizedKeyGenImplementation()