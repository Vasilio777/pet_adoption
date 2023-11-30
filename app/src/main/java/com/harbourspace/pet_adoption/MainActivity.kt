package com.harbourspace.pet_adoption

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.harbourspace.pet_adoption.repository.AppPreferences
import com.harbourspace.pet_adoption.ui.theme.Pet_adoptionTheme
import com.harbourspace.pet_adoption.view.WigglesMain

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkTheme = remember { mutableStateOf(AppPreferences(this@MainActivity).isDarkTheme()) }
            val toggleTheme: () -> Unit = {
                isDarkTheme.value = !isDarkTheme.value
                AppPreferences(this@MainActivity).setForceDarkTheme(isDarkTheme.value)
            }

            Pet_adoptionTheme(
                darkTheme = isDarkTheme.value
            ) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    WigglesMain(isDarkTheme, toggleTheme)
                }
            }
        }
    }

    private fun setDayTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun setDarkTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }
}

@ExperimentalAnimationApi
@Preview("White Theme", widthDp = 360, heightDp = 640,
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun WhitePreview() {
    Pet_adoptionTheme(darkTheme = false) {
//        WigglesMain(toggleTheme = { })
    }
}

@ExperimentalAnimationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640,
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkPreview() {
    Pet_adoptionTheme(darkTheme = true) {
//        WigglesMain(toggleTheme = { })
    }
}