package com.harbourspace.pet_adoption

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.harbourspace.pet_adoption.repository.AppPreferences
import com.harbourspace.pet_adoption.theme.Pet_adoptionTheme

@Composable
fun Switcher(
    isDarkModeOn: MutableState<Boolean>,
    updateDarkTheme: () -> Unit
) {
    Switch(
        checked = isDarkModeOn.value,
        onCheckedChange = {updateDarkTheme() }
    )
}

class DetailsActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as AppApplication).repository)
    }

    fun showDogs() {
        mainViewModel.getDogsFromDatabase().observe(this) {
            Log.d(TAG, "Found on db: $it")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val isDarkModeOn = remember { mutableStateOf(AppPreferences(this@DetailsActivity).getDarkThemeState()) }

            Pet_adoptionTheme(
                darkTheme = isDarkModeOn.value
            ) {

                val url = if(intent.hasExtra("extra.image")) {
                    intent.extras?.get("extra.image")
                } else {
                    null
                }

                val painter = if (url != null) {
                    rememberAsyncImagePainter(
                        model = ImageRequest.Builder(
                            LocalContext.current
                        )
                            .data(url)
                            .crossfade(true)
                            .build()
                    )
                } else {
                    painterResource(id = R.drawable.cat)
                }

                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    LazyColumn {
                        item {
                            Switcher(
                                isDarkModeOn = isDarkModeOn,
                                updateDarkTheme = {
                                    isDarkModeOn.value = !isDarkModeOn.value
                                    AppPreferences(this@DetailsActivity).setDarkThemeState(isDarkModeOn.value)
                                }
                            )
                        }

                        item {
                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(250.dp)) {
                                Image(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    painter = painter,
                                    contentScale = ContentScale.Crop,
                                    contentDescription = stringResource(id = R.string.img_desc)
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(8.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .align(Alignment.BottomStart)
                                            .background(color = Color.LightGray.copy(alpha = 0.2f))
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .padding(8.dp)
                                                .align(Alignment.BottomStart),
                                        ) {
                                            Icon(
                                                modifier = Modifier
                                                    .padding(end = 4.dp),
                                                imageVector = Icons.Default.LocationOn,
                                                contentDescription = stringResource(id = R.string.img_desc)
                                            )
                                            Text(text = "Bangkok")
                                        }
                                    }
                                }
                            }

                        }

                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(80.dp)
                                    .padding(16.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .padding(end = 16.dp)
                                            .clip(CircleShape)
                                            .size(50.dp),
                                        contentScale = ContentScale.Crop,
                                        painter = painterResource(id = R.drawable.avatar),
                                        contentDescription = stringResource(id = R.string.img_desc),
                                    )
                                    Text(text = "Biel Morro", fontWeight = FontWeight.Bold)
                                }

                                Row(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Icon(
                                        modifier = Modifier
                                            .padding(horizontal = 20.dp),
                                        imageVector = Icons.Outlined.Download,
                                        contentDescription = stringResource(id = R.string.img_desc))
                                    Icon(
                                        imageVector = Icons.Outlined.FavoriteBorder,
                                        contentDescription = stringResource(id = R.string.img_desc))
                                    Icon(
                                        modifier = Modifier
                                            .padding(horizontal = 20.dp),
                                        imageVector = Icons.Outlined.BookmarkBorder,
                                        contentDescription = stringResource(id = R.string.img_desc))
                                }
                            }
                        }

                        item {
                            Row(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Column(
                                    modifier = Modifier.weight(1.0f)
                                ) {
                                    AddImageInformation(
                                        title = stringResource(id = R.string.details_camera_title),
                                        subtitle = stringResource(id = R.string.details_camera_default)
                                    )
                                }

                                Column(
                                    modifier = Modifier.weight(1.0f)
                                ) {
                                    AddImageInformation(
                                        title = stringResource(id = R.string.details_aperture_title),
                                        subtitle = stringResource(id = R.string.details_aperture_default)
                                    )
                                }
                            }
                        }

                        item {
                            Row(
                                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                            ) {
                                Column(
                                    modifier = Modifier.weight(1.0f)
                                ) {
                                    AddImageInformation(
                                        title = stringResource(id = R.string.details_focal_title),
                                        subtitle = stringResource(id = R.string.details_focal_default)
                                    )
                                }

                                Column(
                                    modifier = Modifier.weight(1.0f)
                                ) {
                                    AddImageInformation(
                                        title = stringResource(id = R.string.details_shutter_title),
                                        subtitle = stringResource(id = R.string.details_shutter_default)
                                    )
                                }
                            }
                        }

                        item {
                            Row(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Column(
                                    modifier = Modifier.weight(1.0f)
                                ) {
                                    AddImageInformation(
                                        title = stringResource(id = R.string.details_iso_title),
                                        subtitle = stringResource(id = R.string.details_iso_default)
                                    )
                                }

                                Column(
                                    modifier = Modifier.weight(1.0f)
                                ) {
                                    AddImageInformation(
                                        title = stringResource(id = R.string.details_dimensions_title),
                                        subtitle = stringResource(id = R.string.details_dimensions_default)
                                    )
                                }
                            }
                        }

                        item {
                            Divider(
                                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                                thickness = 1.dp,
                                color = Color.LightGray
                            )
                        }

                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {

                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    AddImageInformation(
                                        title = stringResource(id = R.string.details_views_title),
                                        subtitle = stringResource(id = R.string.details_views_default)
                                    )
                                }

                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    AddImageInformation(
                                        title = stringResource(id = R.string.details_downloads_title),
                                        subtitle = stringResource(id = R.string.details_downloads_default)
                                    )
                                }

                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    AddImageInformation(
                                        title = stringResource(id = R.string.details_likes_title),
                                        subtitle = stringResource(id = R.string.details_likes_default)
                                    )
                                }
                            }
                        }

                        item {
                            Divider(
                                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                                thickness = 1.dp,
                                color = Color.LightGray
                            )
                        }

                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {
                                Button(
                                    modifier = Modifier
                                        .padding(end = 8.dp),
                                    onClick = { /*TODO*/ },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.DarkGray,
                                        contentColor = Color.White)) {
                                    Text(text = "barcelona")
                                }

                                Button(onClick = { /*TODO*/ },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.DarkGray,
                                        contentColor = Color.White)) {
                                    Text(text = "spain")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AddImageInformation(
    title: String,
    subtitle: String
) {

    Text(
        text = title,
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold
    )

    Text(
        text = subtitle,
        fontSize = 15.sp
    )
}

@Preview
@Composable
fun previewIt() {

}