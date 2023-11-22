package com.harbourspace.pet_adoption

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harbourspace.pet_adoption.data.UnsplashItem
import com.harbourspace.pet_adoption.theme.Pet_adoptionTheme

class CardDetails : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Pet_adoptionTheme {

                val imageObj = if(intent.hasExtra("extra.image")) {
                    intent.extras!!.get("extra.image") as UnsplashItem
                } else {
                    null
                }
                // .data(imageObj.urls?.regular?)
                // extra.image - global param (values file, const, etc
                LazyColumn {
                    item {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp),
                            painter = painterResource(id = R.drawable.cat),
                            contentScale = ContentScale.Crop,
                            contentDescription = stringResource(id = R.string.img_desc)
                        )
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

@Preview(
    name="Dark Mode",
    device = "id:pixel_5",
    showSystemUi = true,
    showBackground = true)
@Composable
fun PreviewActivity() {
    Pet_adoptionTheme {

        LazyColumn {
            item {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    painter = painterResource(id = R.drawable.cat),
                    contentScale = ContentScale.Crop,
                    contentDescription = stringResource(id = R.string.img_desc)
                )
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
        }
    }
}