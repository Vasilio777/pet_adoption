package com.harbourspace.pet_adoption.component

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.harbourspace.pet_adoption.LoginActivity
import com.harbourspace.pet_adoption.MainActivity
import com.harbourspace.pet_adoption.R

@Composable
fun TopBar(
    isDarkTheme: MutableState<Boolean>,
    onToggle: () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Hey Spikey,",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.surface
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Adopt a new friend near you!",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.surface
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 24.dp, 36.dp, 0.dp),
            horizontalArrangement = Arrangement.End
        ) {
//            val activity = LocalContext.current as MainActivity

            Icon(
                Icons.Filled.Logout,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp, 24.dp)
                    .padding(0.dp, 24.dp, 36.dp, 0.dp)
                    .clickable(onClick = {
//                        FirebaseAuth
//                            .getInstance()
//                            .signOut()
//                        activity.startActivity(Intent(this@MainActivity, LoginActivity::class.java))
//                        activity.finish()
                    })
            )

            WigglesThemeSwitch(
                checked = isDarkTheme.value,
                onToggle = { onToggle() })
        }
    }
}

@Composable
fun WigglesThemeSwitch(checked: Boolean, onToggle: () -> Unit) {

    val icon = if (checked)
        painterResource(id = R.drawable.ic_light_off)
    else
        painterResource(id = R.drawable.ic_light_on)

    Icon(
        painter = icon,
        contentDescription = null,
        modifier = Modifier
            .size(24.dp, 24.dp)
            .clickable(onClick = onToggle)
    )
}
