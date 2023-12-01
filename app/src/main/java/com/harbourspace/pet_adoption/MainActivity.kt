package com.harbourspace.pet_adoption

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.auth.FirebaseAuth
import com.harbourspace.pet_adoption.repository.AppPreferences
import com.harbourspace.pet_adoption.ui.theme.Pet_adoptionTheme
import com.harbourspace.pet_adoption.view.WigglesMain

class MainActivity : ComponentActivity() {

    private val unsplashViewModel: UnsplashViewModel by viewModels()

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        unsplashViewModel.searchImages("pet profile")

        FirebaseAuth
            .getInstance()
            .signOut()

        setContent {
            val isDarkTheme =
                remember { mutableStateOf(AppPreferences(this@MainActivity).isDarkTheme()) }
            val toggleTheme: () -> Unit = {
                isDarkTheme.value = !isDarkTheme.value
                AppPreferences(this@MainActivity).setForceDarkTheme(isDarkTheme.value)
            }

            Pet_adoptionTheme(
                darkTheme = isDarkTheme.value
            ) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    WigglesMain(
                        unsplashViewModel = unsplashViewModel,
                        isDarkTheme,
                        toggleTheme
                    )
                }
            }
        }
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