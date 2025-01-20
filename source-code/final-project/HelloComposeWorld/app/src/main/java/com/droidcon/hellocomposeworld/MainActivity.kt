package com.droidcon.hellocomposeworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.droidcon.hellocomposeworld.ui.theme.HelloComposeWorldTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloComposeWorldTheme {
                HelloWorld(name = "Android World")
            }
        }
    }
}

@Composable
fun HelloWorld(name: String) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var message by remember { mutableStateOf("") }

            Text(
                text = message.ifEmpty { stringResource(id = R.string.hello_message) },
                color = MaterialTheme.colorScheme.onPrimary
            )

            Image(
                painter = painterResource(id = R.drawable.robot),
                contentDescription = "Below Text Image",
                modifier = Modifier.fillMaxWidth()
            )

            val welcomeMessage = stringResource(id = R.string.welcome_message)

            Button(onClick = {
                message = welcomeMessage
            }, modifier = Modifier.padding(top = 16.dp)) {
                Text(text = stringResource(id = R.string.button_text))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloComposeWorldTheme {
        HelloWorld("Android")
    }
}