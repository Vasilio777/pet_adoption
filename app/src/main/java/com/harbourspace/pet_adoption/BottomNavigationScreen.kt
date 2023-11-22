package com.harbourspace.pet_adoption

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: BottomNavigationScreen(
        "Home", "Home", Icons.Default.Home
    )

    object About: BottomNavigationScreen(
        "About", "About", Icons.Default.Info
    )

}