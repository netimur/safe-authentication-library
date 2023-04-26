package com.netimur.safeauthentication

import android.content.Context
import android.content.SharedPreferences
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.netimur.safeauthentication.cryptography.cipher.SafeAuthCipherRepository
import com.netimur.safeauthentication.cryptography.cipher.prebuilt.SafeAuthCipherRepositoryImplementation
import com.netimur.safeauthentication.encryption.Decoder
import com.netimur.safeauthentication.encryption.Encoder
import com.netimur.safeauthentication.encryption.SealedObjectEncoder
import com.netimur.safeauthentication.encryption.prebuilt.DecoderImplementation
import com.netimur.safeauthentication.encryption.prebuilt.EncoderImplementation
import com.netimur.safeauthentication.encryption.prebuilt.PlainSealedObject
import com.netimur.safeauthentication.repository.Savable
import com.netimur.safeauthentication.repository.prebuilt.SharedPreferencesSavable

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.netimur.safeauthentication.test", appContext.packageName)
    }

  /*  @Test
    fun saveRestoreData() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val data = "secret data"

        val keyAlias = "MyKeyAlias"
        val safeAuth: SafeAuthCipherRepository = SafeAuthCipherRepositoryImplementation()
        val encryptionCipher = safeAuth.getEncryptionCipher(keyAlias)
        val decryptionCipher = safeAuth.getDecryptionCipher(keyAlias, encryptionCipher.iv)

        val encoder: Encoder<String> = EncoderImplementation(encryptionCipher)
        val decoder: Decoder<String> = DecoderImplementation(decryptionCipher)

        val toSave = String(encoder.encryptData(data))
        val sp = appContext.getSharedPreferences(Context.MODE_PRIVATE)
        val savable:Savable = SharedPreferencesSavable()
    }*/
    @Test
    fun encryptDecryptData() {
        val data = "secret data"

        val keyAlias = "MyKeyAlias"
        val safeAuth: SafeAuthCipherRepository = SafeAuthCipherRepositoryImplementation()
        val encryptionCipher = safeAuth.getEncryptionCipher(keyAlias)
        val decryptionCipher = safeAuth.getDecryptionCipher(keyAlias, encryptionCipher.iv)

        val encoder: Encoder<String> = EncoderImplementation(encryptionCipher)
        val decoder: Decoder<String> = DecoderImplementation(decryptionCipher)

        val encryptedData = encoder.encryptData(data)
        val decryptedData = decoder.decryptData(encryptedData)
        assertEquals(data, decryptedData)
    }

    @Test
    fun encryptTwice() {
        val data = "secret data"

        val keyAlias = "MyKeyAlias"
        val safeAuth: SafeAuthCipherRepository = SafeAuthCipherRepositoryImplementation()
        val encryptionCipher = safeAuth.getEncryptionCipher(keyAlias)
        val decryptionCipher = safeAuth.getDecryptionCipher(keyAlias, encryptionCipher.iv)

        val encoder: Encoder<String> = EncoderImplementation(encryptionCipher)
        val decoder: Decoder<String> = DecoderImplementation(decryptionCipher)

        var encryptedData = encoder.encryptData(data)
        assertThrows(java.lang.IllegalStateException::class.java) {
            encoder.encryptData(data)
        }
    }

    @Test
    fun reuseSealedObject() {
        val data = "secret data"

        val keyAlias = "MyKeyAlias"
        val safeAuth: SafeAuthCipherRepository = SafeAuthCipherRepositoryImplementation()
        val encryptionCipher = safeAuth.getEncryptionCipher(keyAlias)
        val decryptionCipher = safeAuth.getDecryptionCipher(keyAlias, encryptionCipher.iv)

        val plainSealedObject:SealedObjectEncoder = PlainSealedObject(data, encryptionCipher)
        plainSealedObject.encryptData()
        assertThrows(java.lang.IllegalStateException::class.java) {
            plainSealedObject.encryptData()
        }
    }
}