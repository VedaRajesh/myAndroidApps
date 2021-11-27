package com.example.learningbannerui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.learningbannerui.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun LearningBannerUi(
    color: Color? = Black,
    courseName: String = "JetPack Compose",
    courseTextColor: Color = Black,
    descriptionText: String = "2022 Complete Python BootCamp From Zero to Hero in Python",
    discriptionColor: Color = White,
    ratingStars: Float = 0.5f,
    couseImage: Int = R.drawable.jetpack_compose,
    bannerModifier: Modifier?,
    onesClickable: (() -> Unit)?,
    elevation: Dp = 2.dp
) {
    Card(
        modifier = bannerModifier!!
            .width(170.dp)
            .height(240.dp),
        shape = Shapes.medium,
        elevation = elevation,
        onClick = onesClickable!!
        ,
    ) {
        Column(
            modifier = Modifier
                .background(brush = Brush.verticalGradient(
                    listOf(
                        White,
                        White,
                        color!!
                    ),
                ))
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),
            ) {
                Image( // MAIN IMAGE
                    painter = rememberImagePainter(
                        couseImage
                    ),
                    contentDescription = "image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp),
                    contentScale = ContentScale.Crop
                )
            }
            val myFont = Font(R.font.cagliostro)
            Column(
                modifier = Modifier
                    .padding(
                        start = 5.dp,
                        top = 10.dp
                    )
            ) {
                Text(
                    // COURSE NAME
                    text = courseName,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(5.dp),
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = courseTextColor,
                    fontWeight = FontWeight.Medium,
                )

                Text(
                    // DISCRIPTION
                    text = descriptionText,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp),
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    color = discriptionColor,
                )
                RatingStars(ratingStars = ratingStars)
            }
        }
    }
}

@Composable
fun RatingStars(ratingStars: Float) {
    val tostContex = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 4.dp,
                start = 14.dp
            )
    ) {
        Image(
            painter = rememberImagePainter(
                if (ratingStars == 1f || ratingStars == 0f) {
                    R.drawable.one
                } else if (ratingStars == 2f) {
                    R.drawable.two_stars
                } else if (ratingStars == 1.5f) {
                    R.drawable.one_and_half
                } else if (ratingStars == 2.5f) {
                    R.drawable.two_and_half
                } else if (ratingStars == 3f) {
                    R.drawable.three
                } else if (ratingStars == 3.5f) {
                    R.drawable.three_and_half
                } else if (ratingStars == 4f || ratingStars > 5f) {
                    R.drawable.four
                } else if(ratingStars == 0.5f) (
                    R.drawable.half

                )else {
                    Toast.makeText(tostContex, "Not a valid Rating value", Toast.LENGTH_LONG).show()
                }
            ),
            contentDescription = "rating Star"
        )
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun HelloDefault() {
}