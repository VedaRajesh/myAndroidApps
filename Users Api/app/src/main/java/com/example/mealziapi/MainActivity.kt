package com.example.mealziapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color.Companion.Blue
import com.example.mealziapi.remoteData.PostService
import com.example.mealziapi.remoteData.dto.PostResponse
import com.example.mealziapi.ui.theme.MealziApiTheme
import io.ktor.client.*

class MainActivity : ComponentActivity() {

    private val scrvice = PostService.creat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val postss = produceState<List<PostResponse>>(
                initialValue = emptyList(),
                producer = {
                    value = scrvice.getPost()
                }
            )

            MealziApiTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            modifier = Modifier,
                            backgroundColor = Color.Green,
                            title = {
                                Text(text = "User Api")
                            },
                            navigationIcon = {
                                Icon(Icons.Default.Home, contentDescription = "djdjd",
                                    modifier = Modifier
                                        .size(40.dp)
                                )
                            }
                        )
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        LazyColumn {
                            items(postss.value) { // Temih TODO
                                Column(modifier = Modifier.fillMaxWidth()) {
                                    Text(text = "NAME ${it.name}", fontSize = 25.sp)
                                    Spacer(modifier = Modifier.padding(5.dp))

                                    Text(
                                        text = "EMAIL ${it.email}",
                                        fontSize = 20.sp,
                                        color = Blue
                                    )

                                    Spacer(modifier = Modifier.padding(5.dp))
                                    Text(text = "DISCRIPTIOIN ${it.body}", fontSize = 15.sp)

                                }

                            }
                        }
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}
