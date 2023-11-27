package com.harbourspace.pet_adoption.repository

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

private val KEY_DARK_THEME = "dark_theme"

class AppPreferences(context: Activity) {
    private val preferences = context.getSharedPreferences("unsplash", Context.MODE_PRIVATE)

    fun setDarkThemeState(isDarkTheme: Boolean) {
        with(preferences.edit()) {
            putBoolean(KEY_DARK_THEME, isDarkTheme)
            apply()
        }
    }

    fun getDarkThemeState(): Boolean {
        val isSystemInDarkTheme = AppCompatDelegate.getDefaultNightMode() != AppCompatDelegate.MODE_NIGHT_NO
        return preferences.getBoolean(KEY_DARK_THEME, isSystemInDarkTheme)
    }
}
