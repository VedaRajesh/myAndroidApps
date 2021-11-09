package com.example.mealzapp.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.mealzapp.remote.PostService
import com.example.mealzapp.remote.dto.PostResponce
import com.example.mealzapp.ui.theme.MealzAppTheme
import com.example.mealzapp.ui.theme.Shapes

class MainActivity : ComponentActivity() {

    val service = PostService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val posts = produceState<List<PostResponce>>(
                initialValue = emptyList(),
                producer = {
                    value = service.getPost()
                }
            )
            MealzAppTheme {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(brush = Brush.linearGradient(
                            colors = listOf(
                                Red, White
                            )
                        ))
                ) {
                    items(posts.value) { ad ->
                        Cards(imageData = ad.strCategoryThumb,"doe")
                    }
                }
            }
        }
    }
}

@Composable
fun Cards(imageData : String,name : String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
            .height(130.dp),
        shape = Shapes.medium,
        backgroundColor = White
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, start = 20.dp)
        ) {
            Image(
                painter = rememberImagePainter(imageData),
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
            )
            Text(text = "hfiejfiej")
        }
    }
}