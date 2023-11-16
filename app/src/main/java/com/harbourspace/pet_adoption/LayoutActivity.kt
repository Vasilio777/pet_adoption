package com.harbourspace.pet_adoption

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.harbourspace.pet_adoption.R
import androidx.compose.material.icons.*

class LayoutActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.excersise)

        updateIncludedLayout(R.id.details_camera, "Camera", "NIKON D3200")
        updateIncludedLayout(R.id.details_iso, "Focal Length", "180mm")
        updateIncludedLayout(R.id.details_focal_l, "ISO", "100")
        updateIncludedLayout(R.id.details_aperture, "Aperture", "f5.0")
        updateIncludedLayout(R.id.details_shutter, "Shutter Speed", "1/125s")
        updateIncludedLayout(R.id.details_dim, "Dimensions", "3906 x 4882")

        updateIncludedLayout(R.id.meta_views, "Views", "8.8M")
        updateIncludedLayout(R.id.meta_downloads, "Downloads", "99.1K")
        updateIncludedLayout(R.id.meta_likes, "Likes", "1.8K")

        updateTag(R.id.tag_01, "barcelona")
        updateTag(R.id.tag_02, "spain")

        val headerOverlay = findViewById<ImageButton>(R.id.header_overlay)

        findViewById<ImageButton>(R.id.btn_header).setOnClickListener {
            headerOverlay.visibility = View.VISIBLE
        }

        headerOverlay.setOnClickListener {
            headerOverlay.visibility = View.INVISIBLE
        }
    }

     private fun updateIncludedLayout(layoutId: Int, text1: String, text2: String) {
        val includedLayout = findViewById<View>(layoutId)

        val textView1 = includedLayout.findViewById<TextView>(R.id.text_bold)
        val textView2 = includedLayout.findViewById<TextView>(R.id.text_light)

        textView1.text = text1
        textView2.text = text2
    }

    private fun updateTag(id: Int, text: String) {
        val btn = findViewById<Button>(id)

        btn.text = text
    }
}
