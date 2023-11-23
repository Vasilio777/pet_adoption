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
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.harbourspace.pet_adoption.data.UnsplashItem
import com.harbourspace.pet_adoption.theme.Pet_adoptionTheme

class HW2Activity: ComponentActivity() {

    private val unsplashViewModel : UnsplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        unsplashViewModel.getUnsplashImages()

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
                        PetCard(image)
                    }
                }
            }
        }
    }

    @Composable
    fun PetCard(inImage: UnsplashItem) {
        val painter = rememberAsyncImagePainter(model = ImageRequest.Builder(LocalContext.current)
            .data(inImage.urls.regular)
            .crossfade(true)
            .build()
        )

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        val intent = Intent(this@HW2Activity, DetailsActivity::class.java)
                        intent.putExtra("extra.image", inImage.urls.regular)
                        startActivity(intent)
                    },

                contentScale = ContentScale.Crop,
                painter = painter,
                contentDescription = stringResource(id = R.string.img_desc)
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomStart)
                        .background(color = Color.LightGray.copy(alpha = 0.2f))
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.BottomStart),
                        text = inImage.user.name
                    )
                }
            }
        }
    }
}


//@Preview(
//    name="Dark Mode",
//    device = "id:pixel_5",
//    showSystemUi = true,
//    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun PetCardPreview() {
//    Pet_adoptionTheme {
//
//    }
//}