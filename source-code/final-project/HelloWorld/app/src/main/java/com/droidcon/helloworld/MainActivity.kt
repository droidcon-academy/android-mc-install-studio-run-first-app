package com.droidcon.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorld()
        }
    }
}

@Composable
fun HelloWorld() {
    // Box for Background
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        // Content: Text, Image, and Button
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Localized Text State
            var message by remember { mutableStateOf("") }
            Text(
                text = message.ifEmpty { stringResource(id = R.string.hello_message) }, // Display initial text if message is empty
                color = MaterialTheme.colorScheme.onPrimary // Ensure text color is visible
            )

            // Image Below Text
            Image(
                painter = painterResource(id = R.drawable.robot),
                contentDescription = "Image below text",
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(top = 16.dp)
            )

            // Button Below Image
            val welcomeMessage = stringResource(id = R.string.welcome_message)
            Button(
                onClick = {
                    message = welcomeMessage
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = stringResource(id = R.string.button_text))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHelloComposeWorld() {
    HelloWorld()
}
