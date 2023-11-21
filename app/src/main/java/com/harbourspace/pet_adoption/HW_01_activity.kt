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

        val url = if(intent.hasExtra("extra.image")) {
            intent.extras?.get("extra.image")
        } else {
            null
        }
        // .data(url)
        // parcelize ?
        // extra.image - global param
        setContent {
            Pet_adoptionTheme {

                val search = remember { mutableStateOf("")}
                OutlinedTextField(
                    value = search.value,
                    onValueChange = { value ->
                        search.value = value
                    })

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
                                    val intent =
                                        Intent(this@HW1Activity, LayoutActivity::class.java)
                                    intent.putExtra("extra.image", image.urls.regular)
                                    startActivity(intent)
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

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.avatar),
            contentDescription = "TODO",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 10.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }
    }
}

@Composable
fun Conversation(messages: List<Int>) {
    LazyColumn {
        items(messages) {
            Image(
                painter = painterResource(id = it),
                contentDescription = "str")
        }
    }
}


//@Preview(
//    name="Dark Mode",
//    device = "id:pixel_5",
//    showSystemUi = true,
//    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewMessageCard() {
    Pet_adoptionTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }
}

//@Preview(
//    name="Light Mode",
//    device = "id:pixel_5",
//    showSystemUi = true,
//    showBackground = true)
@Composable
fun PreviewConversation() {
    Pet_adoptionTheme {
        val sampleData = listOf<Int>(
            R.drawable.avatar,
            R.drawable.cat)

        Conversation(messages = sampleData)
    }
}

@Preview(
    name="Dark Mode",
    device = "id:pixel_5",
    showSystemUi = true,
    showBackground = true)
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