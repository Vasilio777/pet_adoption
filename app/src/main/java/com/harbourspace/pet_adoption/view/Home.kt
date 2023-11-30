package com.harbourspace.pet_adoption.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.harbourspace.pet_adoption.UnsplashViewModel
import com.harbourspace.pet_adoption.component.ItemDogCard
import com.harbourspace.pet_adoption.component.TopBar
import com.harbourspace.pet_adoption.model.Dog

@Composable
fun Home(
    navController: NavHostController,
    unsplashViewModel: UnsplashViewModel,
    dogList: List<Dog>,
    isDarkTheme: MutableState<Boolean>,
    toggleTheme: () -> Unit) {
    LazyColumn {
        item {
            TopBar(
                isDarkTheme,
                onToggle = {
                    toggleTheme()
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        items(dogList) {
            val unsplashImages = unsplashViewModel.items.observeAsState(emptyList())

            unsplashImages.value.forEachIndexed { id, el ->
                ItemDogCard(
                    el.urls.regular,
                    dogList[id % dogList.size],
                    onItemClicked = { dog ->
                        navController.navigate("details/${dog.id}/${dog.name}/${dog.location}")
                    }
                )
            }
        }
    }
}
