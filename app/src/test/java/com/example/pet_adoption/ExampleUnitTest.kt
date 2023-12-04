package com.example.pet_adoption

import android.content.Context
import android.content.SharedPreferences
import androidx.core.util.PatternsCompat
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock

fun String .isValidEmail(): Boolean {

    return !isNullOrEmpty() && PatternsCompat.EMAIL_ADDRESS.matcher(this).matches()
}

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        Assert.assertEquals(4, 2 + 2)
    }

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue("name@email.com".isValidEmail())
    }

}

class MockedContextTest {

    val KEY_DARK_THEME = "dark_theme"
    val KEY_DARK_DEFAULT = 0

    @Mock val mockContext: Context = mock()

    @Mock val mockPrefs: SharedPreferences = mock()

    @Mock val mockEditor: SharedPreferences.Editor = mock()

    @Before
    @Throws(Exception::class)
    fun before() {
        Mockito.`when`(mockContext.getSharedPreferences(anyString(), anyInt()))
            .thenReturn(mockPrefs)
        Mockito.`when`(mockContext.getSharedPreferences(anyString(), anyInt()).edit())
            .thenReturn(mockEditor)
        Mockito.`when`(mockPrefs.getInt(KEY_DARK_THEME, KEY_DARK_DEFAULT))
            .thenReturn(KEY_DARK_DEFAULT)
    }

    @Test
    fun `validate default theme status`() {
        assertEquals(mockPrefs.getInt(KEY_DARK_THEME, KEY_DARK_DEFAULT), KEY_DARK_DEFAULT)
    }
}