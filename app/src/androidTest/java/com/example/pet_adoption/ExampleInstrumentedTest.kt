package com.example.pet_adoption

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.harbourspace.pet_adoption", appContext.packageName)
    }

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testUIComponent() {
        composeTestRule.setContent {
            BasicTextField(value = "", onValueChange = { /* handle text change */ })
        }

        // UI testing
        composeTestRule
            .onNodeWithText("Your text field hint", useUnmergedTree = true)
            .assertExists()
            .performTextInput("Test input")

        composeTestRule.onNodeWithText("Test input").assertIsDisplayed()
    }
}