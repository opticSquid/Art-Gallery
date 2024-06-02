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
import com.sb.artgallery.entity.Art
import com.sb.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    val arts: List<Art> = listOf(
        Art(
            image = R.drawable.afonso_vieira_ha9pftjs5em_unsplash,
            title = "Parenting",
            description = """This image shows an adult possibly a male standing behind a his child probably helping the child walk. They are on a sandy beach in front of the sea"""
        ), Art(
            image = R.drawable.alwen_kqlimsmgxsw_unsplash,
            title = "Paparazzi",
            description = """The image consists of pink text that says “20 ANOS 71” stacked on top of a black and white image of a woman holding a camera. The camera has a pink flash attached to it.  The woman is facing away from the camera and has short dark hair. She’s wearing a black collared shirt with a pocket on one side and dark pants or jeans. The camera is black and appears to be a 35mm film camera. It has a large lens in the front and a viewfinder on the top. There is a strap attached to the camera that goes around the woman's neck. Attached to the top of the camera is a rectangular flash unit that appears to be made of pink plastic. I can’t tell what kind of camera it is or what brand it is.  There is no other writing or imagery visible."""
        ), Art(
            image = R.drawable.anton_khmelnitsky_uggnq6v9dlu_unsplash,
            title = "Out of walled Garden",
            description = """The image shows a large cactus growing on top of a white wall.  The cactus is green and appears to be multi-armed, with some stems reaching out horizontally.  There are also what appear to be smaller cacti growing around the base of the larger cactus"""
        ), Art(
            image = R.drawable.dmitry_spravko_uugcia_ztmw_unsplash,
            title = "Mercury Monterrey",
            description = """The image you sent me is a close-up of the rear end of a pink car. The car is parked in a parking lot. There is a chrome bumper with two taillights on either side. There is also a license plate in the center of the bumper, but the text is illegible. The text on the trunk lid says “Mercury Monterey”. The Mercury Monterey was a full-sized luxury car that was produced by the Mercury division of Ford from 1952 to 1975. It was one of Mercury's most popular models, and it was known for its stylish design and comfortable ride. The Monterey was available in a variety of body styles, including sedans, coupes, and station wagons. The car in the image appears to be in good condition, and it is likely a classic car that is being preserved by its owner."""
        ), Art(
            image = R.drawable.julia_solonina_vegtrucaevq_unsplash,
            title = "The Hotel",
            description = """The image shows a full moon rising over a calm ocean. In the foreground, there is a beach with white sand. There are four palm trees on the beach, all leaning towards the ocean.  In the distance, behind the palm trees, there is a large building with a well-lit rectangular structure on top,  This building could be a hotel or a resort."""
        ), Art(
            image = R.drawable.mak_besdg_wppf4_unsplash,
            title = "Cherry Blossom",
            description = """The photo captures a picturesque scene of a park overflowing with cherry blossoms.  Large, fluffy clusters of pink flowers drape the branches of the trees, creating a canopy overhead.  Several people stand beneath the blossoms, enjoying the springtime beauty. Some people are gazing upwards, likely marveling at the flowers, while others chat amongst themselves. The overall feel of the image is peaceful and serene."""
        )
    )

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
fun NavButtons(modifier: Modifier = Modifier) {
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