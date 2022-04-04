package com.example.noteapp.Components

import android.media.AudioMetadata
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.Data.ListDataSource
import com.example.noteapp.Model.Note
import com.example.noteapp.ui.theme.Teal200
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterialApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CardRow(items: Note,click : () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(White),
        backgroundColor = Teal200.copy(0.6f),
        shape = RoundedCornerShape(topEnd = 30.dp, bottomStart = 30.dp),
        elevation = 2.dp,
        onClick = {
            click.invoke()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = items.note,
                fontSize = 20.sp,
                color = Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 10.dp, top = 4.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Text(
                text = items.discription,
                fontSize = 16.sp,
                color = Black,
                modifier = Modifier
                    .padding(start = 10.dp, top = 4.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Text(
                text = items.entryDate.format(DateTimeFormatter.ofPattern("dd|mm|yyyy")),
                fontSize = 16.sp,
                color = Black,
                modifier = Modifier
                    .padding(start = 10.dp, top = 4.dp,bottom = 10.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun DEJDIJEIDJEIoddj() {
    CardRow(ListDataSource().loadData()[1],{})
}