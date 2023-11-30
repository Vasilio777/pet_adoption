package com.harbourspace.pet_adoption.navigation

import androidx.annotation.StringRes
import com.harbourspace.pet_adoption.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    data object Home : Screen("home", R.string.text_home)
    data object Details : Screen("details", R.string.text_details)
}
