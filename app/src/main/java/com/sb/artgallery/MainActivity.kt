package com.sb.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sb.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGalleryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .statusBarsPadding()
                            .padding(horizontal = 25.dp)
                            .safeDrawingPadding()
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        ImageFrame(
                            image = R.drawable.dmitry_spravko_uugcia_ztmw_unsplash,
                            title = "Gallado",
                            modifier = Modifier.padding(10.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        DescriptionCard(title = "Gallado", description = "test")
                        Spacer(modifier = Modifier.height(16.dp))
                        NavButtons()
                    }
                }

            }
        }
    }
}

@Composable
fun ImageFrame(
    @DrawableRes image: Int, title: String, modifier: Modifier = Modifier
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = modifier.height(500.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = modifier.width(300.dp),
            alignment = Alignment.BottomCenter
        )
    }

}

@Composable
fun DescriptionCard(title: String, description: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Left,
            style = TextStyle(fontSize = 32.sp),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Composable
fun NavButtons(modifier: Modifier =Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Previous")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArtGalleryTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(horizontal = 25.dp)
                    .safeDrawingPadding()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                ImageFrame(
                    image = R.drawable.dmitry_spravko_uugcia_ztmw_unsplash,
                    title = "Gallado",
                )
                Spacer(modifier = Modifier.height(8.dp))
                DescriptionCard(title = "Gallado", description = "test")
                Spacer(modifier = Modifier.height(16.dp))
                NavButtons()
            }
        }
    }
}