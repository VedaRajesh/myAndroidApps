package com.example.roomdatabaseproject.Components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.roomdatabaseproject.RoomDatabase.RoomEntity
import com.example.roomdatabaseproject.R
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@Composable
fun CardItem(
    note : RoomEntity,
    onSwipeRemove: (RoomEntity) -> Unit
) {
    val swipeState = remember {
        mutableStateOf(true)
    }

    val delete = SwipeAction(
        onSwipe = {
            onSwipeRemove(note)
            swipeState.value = false
        },
        icon = { Icon(
            painter = painterResource(id = R.drawable.ic_baseline_delete_24),
            contentDescription = null,
            modifier = Modifier.padding(start = 30.dp)
        )},
        background = Red,
    )
    AnimatedVisibility(visible = swipeState.value,enter = expandHorizontally(expandFrom = Alignment.End)) {
        Spacer(modifier = Modifier.padding(top = 30.dp))
        Column {
            SwipeableActionsBox(
                endActions = listOf(delete),
                modifier = Modifier
                    .padding(top = 13.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 22.dp,
                            topEnd = 22.dp,
                            bottomEnd = 22.dp
                        )
                    )
            ) {
                Card(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                topStart = 22.dp,
                                topEnd = 22.dp,
                                bottomEnd = 22.dp
                            )
                        )
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    border = BorderStroke(2.dp, Color.Green),
                    shape = RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp, bottomEnd = 22.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .wrapContentHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = note.firstName, fontWeight = FontWeight.Bold, modifier = Modifier
                                .padding(vertical = 3.dp), fontSize = 20.sp
                        )
                        Text(
                            text = "Work: ${note.aboutUserSelf}",
                            fontWeight = FontWeight.Medium,
                            color = Black,
                            modifier = Modifier
                                .padding(vertical = 3.dp)
                        )
                        Text(text = "Age:${note.age}")
                    }
                }
            }

        }
    }
}


@Preview
@Composable
fun IJDEIDJEIjdeIEJDOIJED() {
    CardItem(
       RoomEntity(firstName = "Rohan.R",aboutUserSelf = "DJEIDJEIJDEIDJEIjdJE",age = "3")
    ){

    }
}