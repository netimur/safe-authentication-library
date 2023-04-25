package com.netimur.safeauthentication.cryptography.keygenerator

import com.netimur.safeauthentication.cryptography.keygenerator.AuthorizedKeyGenerator
import com.netimur.safeauthentication.cryptography.keygenerator.KeyGenerator

interface SafeAuthKeyGenerator : KeyGenerator, AuthorizedKeyGenerator
