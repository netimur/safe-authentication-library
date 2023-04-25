package com.netimur.safeauthentication.cryptography.keygenerator

import com.netimur.safeauthentication.cryptography.keygenerator.*

class SafeAuthKeyGenImplementation :
    SafeAuthKeyGenerator,
    KeyGenerator by KeyGenImplementation(),
    AuthorizedKeyGenerator by AuthorizedKeyGenImplementation()