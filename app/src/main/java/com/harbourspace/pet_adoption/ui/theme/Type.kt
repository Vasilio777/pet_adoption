package com.harbourspace.pet_adoption.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.harbourspace.pet_adoption.R

private val Sailec = FontFamily(
        Font(R.font.sailec_regular),
        Font(R.font.sailec_medium, FontWeight.W500),
        Font(R.font.sailec_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
        titleLarge = TextStyle(
                fontFamily = Sailec,
                fontWeight = FontWeight.W600,
                fontSize = 30.sp
        ),
        titleMedium = TextStyle(
                fontFamily = Sailec,
                fontWeight = FontWeight.W600,
                fontSize = 24.sp
        ),
        titleSmall = TextStyle(
                fontFamily = Sailec,
                fontWeight = FontWeight.W600,
                fontSize = 20.sp
        ),
        labelMedium = TextStyle(
                fontFamily = Sailec,
                fontWeight = FontWeight.W500,
                fontSize = 16.sp
        ),
        labelSmall = TextStyle(
                fontFamily = Sailec,
                fontWeight = FontWeight.W500,
                fontSize = 14.sp
        ),
        bodyMedium = TextStyle(
                fontFamily = Sailec,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
        ),
        bodySmall = TextStyle(
                fontFamily = Sailec,
                fontSize = 14.sp,
                lineHeight = 20.sp
        )
//        button = labelSmall
//        ),
//        caption = bodySmall
//        ),
//        overline = bodySmall
//
//        )
)