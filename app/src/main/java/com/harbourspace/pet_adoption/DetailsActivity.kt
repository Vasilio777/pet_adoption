package com.harbourspace.pet_adoption

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.harbourspace.pet_adoption.R
import androidx.compose.material.icons.*

class DetailsActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_page)
    }
}