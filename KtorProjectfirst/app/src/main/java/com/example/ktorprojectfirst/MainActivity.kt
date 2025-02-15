package com.example.ktorprojectfirst

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ktorprojectfirst.data.PostsService
import com.example.ktorprojectfirst.data.dto.PostResponse
import com.example.ktorprojectfirst.ui.theme.KtorProjectFirstTheme

class MainActivity : ComponentActivity() {

    private val scrvice = PostsService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val posts = produceState<List<PostResponse>>(
                initialValue = emptyList(),
                producer ={
                    value =scrvice.getPosts()
                } )

            KtorProjectFirstTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn{
                        items(posts.value){
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(text = it.title,fontSize = 29.sp)
                                Spacer(modifier = Modifier.padding(4.dp))
                                Text(text = it.body,fontSize = 14.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}

