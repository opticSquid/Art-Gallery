package com.sb.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.sb.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGalleryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxWidth()
                    ) {
                        ImageFrame(
                            image = R.drawable.dmitry_spravko_uugcia_ztmw_unsplash,
                            altText = "Gallado"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ImageFrame(@DrawableRes image: Int, altText: String, modifier: Modifier = Modifier) {
    Card {
        Image(painter = painterResource(id = image), contentDescription = altText)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtGalleryTheme {
        ImageFrame(image = R.drawable.alwen_kqlimsmgxsw_unsplash, altText = "test")
    }
}