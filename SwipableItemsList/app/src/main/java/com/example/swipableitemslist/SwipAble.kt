package com.example.swipableitemslist

import android.annotation.SuppressLint
import android.provider.ContactsContract
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swipableitemslist.ui.theme.CustomGreen
import com.example.swipableitemslist.ui.theme.Shapes
import com.example.swipableitemslist.ui.theme.Teal200
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SwipAble(color : Color,emailFrom : String,cardState : MutableState<Boolean> ) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val undo = SwipeAction(
            background = Teal200,
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_undo_24),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 30.dp, end = 30.dp)
                )
            },
            onSwipe = {
                cardState.value = false
            }
        )

        AnimatedVisibility(visible = cardState.value, exit = fadeOut() + shrinkHorizontally()) {
            SwipeableActionsBox(
                startActions = listOf(undo),
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .clip(Shapes.medium),
                    border = BorderStroke(1.dp,color = Gray),
                    backgroundColor = color,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(30.dp)
                            .background(color),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(text = emailFrom,fontSize = 20.sp)
                    }
                }
            }
        }
    }
    Spacer(modifier = Modifier.padding(bottom = 4.dp))
}


@Preview
@Composable
fun DDJEIDJEI() {
//    SwipAble()
}