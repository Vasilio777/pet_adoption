package com.harbourspace.pet_adoption

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.harbourspace.pet_adoption.data.UnsplashItem
import com.harbourspace.pet_adoption.theme.Pet_adoptionTheme

@Composable
fun ImagesContent(
    unsplashVewModel: UnsplashViewModel,
    onAction: (UnsplashItem) -> Unit
) {
    val search = remember { mutableStateOf("") }
    OutlinedTextField(
        value = search.value,
        onValueChange = { value ->
            search.value = value
        })

    val unsplashImages = unsplashVewModel.items.observeAsState(emptyList())
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
                    .clickable { onAction(image) },
                contentScale = ContentScale.Crop,
                painter = painter,
                contentDescription = stringResource(id = R.string.img_desc)
            )

        }
    }
}

//@Preview(
//    name="Dark Mode",
//    device = "id:pixel_5",
//    showSystemUi = true,
//    showBackground = true)
@Composable
fun PetCard() {
    Pet_adoptionTheme {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Surface {
                Text(
                    text = "test"
                )

                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = stringResource(id = R.string.img_desc)
                )
            }
        }
    }
}