package com.task.booktiket.view

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.task.booktiket.R
import com.task.booktiket.viewModel.AuthViewModel
import kotlin.math.absoluteValue

@Composable
fun FilmInformation(navController: NavController){

    val dates = listOf("fri","sta","sun","mun","tus","tha","whe","fri","sta","sun","mun","tus","tha","whe")
    val listState = rememberLazyListState()

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF130B2B))
    ) {
        Image(
            painterResource(R.drawable.walpaper),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxWidth().size(600.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            brush =Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF09FBD3),
                                Color.Black
                            )
                        ), shape = CircleShape)
                        .background(Color.White.copy(alpha = 0.2f))
                        .clickable { navController.navigate("movies") },
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )

                }
                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            brush =Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFF09FBD3),
                                    Color.Black
                                )
                            ),
                            shape = CircleShape
                        )
                        .background(Color.White.copy(alpha = 0.2f))
                        .clickable {},
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "",
                        tint = Color.White
                    )

                }
            }
            Spacer(modifier = Modifier.height(250.dp))
            Text(
                text = "Doctor strange",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "in the multiverse of madness",
                fontSize = 14.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color(0xFF130B2B).copy(alpha = 0.6f)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "Doctor Strange teams up with a mysterious\nteenage girl who can travel across\nmultiverses, to battle....Read more",
                    color = Color.White.copy(alpha = 0.7f),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp
                )
                Text(
                    text = "select date and time",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(24.dp)
                )
                LazyRow(
                    state = listState,
                    modifier = Modifier.fillMaxWidth().height(200.dp).padding(horizontal = 30.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom
                ) {
                    items(dates.size){index ->
                        val offsetFromMiddle = calculateOffsetFromCenter(listState,index)
                        val scale = calculateScaleForItem(offsetFromMiddle.toInt())
                        val verticalOffset = calculateOffsetForItem(offsetFromMiddle.toInt())
                        val animatedScale = animateFloatAsState(targetValue = scale, label = "")
                        val animatedVertical = animateFloatAsState(targetValue = verticalOffset.value, label = "")
                        Box(
                            modifier = Modifier.fillMaxWidth()
                                .padding(8.dp)
                                .height(80.dp*animatedScale.value)
                                .width(40.dp*animatedScale.value)
                                .graphicsLayer { translationY = animatedVertical.value }
                        ) {
                            Column {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(50.dp*animatedScale.value)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(brush = Brush.horizontalGradient(listOf(Color(0xFF880C51).copy(alpha = 0.4f*animatedScale.value),Color(0xFF2E1371))))
                                        .border(
                                            width = 1.dp,
                                            brush = Brush.horizontalGradient(colors = listOf(Color(0xFF09FBD3).copy(alpha = 0.5f), Color(0xFF2E1371))),
                                            shape = RoundedCornerShape(10.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Column(
                                        modifier = Modifier.fillMaxSize()
                                    ) {
                                        Spacer(modifier = Modifier.height(5.dp*animatedScale.value))
                                        Text(
                                            text = dates[index],
                                            color = Color.White,
                                            fontSize = 8.sp*animatedScale.value,
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.fillMaxWidth()
                                        )
                                        Spacer(modifier = Modifier.height(5.dp*animatedScale.value))
                                        Text(
                                            text = "21",
                                            textAlign = TextAlign.Center,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp*animatedScale.value,
                                            modifier = Modifier.fillMaxWidth()
                                        )
                                    }
                                }
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(40.dp*animatedScale.value).padding(top = 10.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(brush = Brush.horizontalGradient(listOf(Color(0xFF880C51).copy(alpha = 0.2f*animatedScale.value),Color(0xFF2E1371))))
                                        .border(
                                            width = 1.dp,
                                            brush = Brush.horizontalGradient(colors = listOf(Color(0xFF09FBD3).copy(alpha = 0.5f), Color(0xFF2E1371))),
                                            shape = RoundedCornerShape(10.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ){
                                    Text(
                                        text = "19:00",
                                        color = Color.White,
                                        fontSize = 8.sp*animatedScale.value
                                    )
                                }
                            }
                        }
                    }
                }
                Button(
                    modifier = Modifier
                        .padding(30.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .height(60.dp)
                        .background(brush = Brush.horizontalGradient(listOf(Color(0xFFB6116B),Color(0xFF2E1371)))),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White.copy(0f),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(1.dp),
                    onClick = {navController.navigate("chooseSeats")}
                ) {
                    Text(
                        text = "Reservation"
                    )
                }

            }
        }
    }
}

@Composable
fun calculateScaleForItem(offset:Int): Float{
    return when(offset.absoluteValue){
        0 -> 1.7f
        1 -> 1.2f
        else -> 1f
    }
}

@Composable
fun calculateOffsetForItem(offset:Int):Dp{
    return when(offset.absoluteValue){
        0 -> (-150).dp
        1 -> (-70).dp
        else -> 0.dp
    }
}
@SuppressLint("FrequentlyChangedStateReadInComposition")
@Composable
fun calculateOffsetFromCenter(listState: LazyListState, index: Int): Float {
    val visibleItemsInfo = listState.layoutInfo.visibleItemsInfo
    val viewportCenter = listState.layoutInfo.viewportEndOffset / 2

    val itemInfo = visibleItemsInfo.find { it.index == index }

    return if (itemInfo != null) {
        val itemCenter = (itemInfo.offset + itemInfo.size / 2)
        (itemCenter - viewportCenter).toFloat() / itemInfo.size
    } else {
        0f
    }
}