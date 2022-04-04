package com.example.webview

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.webview.ui.theme.Purple200
import com.example.webview.ui.theme.WebViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WebViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var state = remember {
                        mutableStateOf(false)
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val contex = LocalContext.current
                        Button(
                            onClick = {
                                state.value = !state.value
                            },
                            modifier = Modifier,
                            colors = buttonColors(
                                backgroundColor = Purple200
                            )
                        ) {
                            Text(text = "Open Website", fontSize = 20.sp)
                        }
                        if (state.value) {
                            LoadUrl(
                                "https://rohanveda1234.editorx.io/my-site-1"
                            )
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun LoadUrl(url: String) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AndroidView(factory = {
            WebView(it).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                settings.javaClass
                settings.databaseEnabled = true
                settings.setSupportZoom(true)
                loadUrl(url)
            }
        },
            update = { it.loadUrl(url) }
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WebViewTheme {
        Greeting("Android")
    }
}