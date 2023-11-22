package com.harbourspace.pet_adoption

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.harbourspace.pet_adoption.data.UnsplashItem
import com.harbourspace.pet_adoption.theme.Pet_adoptionTheme

enum class TAB(val tabName: String) {
    IMAGES("Images"),
    COLLECTION("Collections")
}

class Cards: ComponentActivity() {

    private val unsplashViewModel : UnsplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        unsplashViewModel.getUnsplashImages()

        setContent {
            Pet_adoptionTheme {

                val selected = remember { mutableIntStateOf(0) }


                Column {
                    val actions = listOf(TAB.IMAGES, TAB.COLLECTION)
                    TabRow(selectedTabIndex = selected.intValue) {
                        actions.forEachIndexed { index, tab ->
                            Tab(
                                selected = selected.intValue == index,
                                onClick = { selected.intValue = index }) {

                                Text(text = tab.tabName)
                            }
                        }
                    }

                    when(selected.intValue) {
                        TAB.IMAGES.ordinal -> {
                            ImagesContent(
                                unsplashVewModel = unsplashViewModel,
                                onAction = { image -> openDetails(image)})
                        }

                        TAB.COLLECTION.ordinal -> {
                            CollectionsContent(
                                unsplashViewModel = unsplashViewModel
                            )
                        }
                    }
                }
            }
        }
    }

    private fun openDetails(image: UnsplashItem) {
        val intent = Intent(this@Cards, CardDetails::class.java)
        intent.putExtra("extra.image", image)
        startActivity(intent)
    }
}
