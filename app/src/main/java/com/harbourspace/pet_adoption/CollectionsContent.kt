package com.harbourspace.pet_adoption

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest


@Composable
fun CollectionsContent(
    unsplashViewModel: UnsplashViewModel
) {
    val collection = unsplashViewModel.collection.observeAsState(emptyList())

    LazyColumn {
        items(collection.value) {collection ->
            val painter = rememberAsyncImagePainter(model = ImageRequest.Builder(LocalContext.current)
                .data(collection.cover_photo.urls.regular)
                .crossfade(true)
                .build()
            )

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clickable {  },
                painter = painter,
                contentDescription = "ola"
            )
        }
    }

}