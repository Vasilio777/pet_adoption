package com.harbourspace.pet_adoption

import android.content.Intent
import android.content.res.Configuration
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.harbourspace.pet_adoption.theme.Pet_adoptionTheme

class HW1Activity: ComponentActivity() {

    private val unsplashViewModel : UnsplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        unsplashViewModel.getUnsplashImages()

//        val url = if(intent.hasExtra("extra.image")) {
//            intent.extras?.get("extra.image")
//        } else {
//            null
//        }
        // .data(url)
        // parcelize ?
        // extra.image - global param
        setContent {
            Pet_adoptionTheme {

//                val search = remember { mutableStateOf("")}
//                OutlinedTextField(
//                    value = search.value,
//                    onValueChange = { value ->
//                        search.value = value
//                    })

                val unsplashImages = unsplashViewModel.items.observeAsState(emptyList())
                LazyColumn {
                    items(unsplashImages.value) {image ->
                        val painter = rememberAsyncImagePainter(model = ImageRequest.Builder(LocalContext.current)
                            .data(image.urls.regular)
                            .crossfade(true)
                            .build()
                        )
                        
                        Text(
                            text = image.user.name
                        )
                        
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .clickable {
//                                    val intent =
//                                        Intent(this@HW1Activity, LayoutActivity::class.java)
//                                    intent.putExtra("extra.image", image.urls.regular)
//                                    startActivity(intent)
                                },
                            contentScale = ContentScale.Crop,
                            painter = painter,
                            contentDescription = stringResource(id = R.string.img_desc)
                        )
                    }
                }
            }
        }
    }
}
