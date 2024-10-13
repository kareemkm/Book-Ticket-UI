package com.task.booktiket.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.task.booktiket.R

@Composable
fun ChooseSeats(navController: NavController){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF130B2B))
            .background(
                brush = Brush.radialGradient(
                    radius =600f,
                    colors = listOf(
                        Color(0xFF09FBD3).copy(alpha = 0.4f),
                        Color(0xFF09FBD3).copy(alpha = 0f)

                    ),
                    center = Offset(850f,1900f)
                )
            )
            .background(
            brush = Brush.radialGradient(
                radius =600f,
                colors = listOf(
                    Color(0xFFB6116B).copy(alpha = 0.4f),
                    Color(0xFFB6116B).copy(alpha = 0f)
                ),
                center = Offset(150f,1900f)
            )
        )
    ) {
        Image(
            painter = painterResource(R.drawable.line1),
            contentDescription = null,
            alpha = 0.5f,
            modifier = Modifier.fillMaxWidth()
                .size(180.dp)
                .padding(top = 100.dp)
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
                            ), shape = CircleShape
                        )
                        .background(Color.White.copy(alpha = 0.2f))
                        .clickable { navController.navigate("filmInformation") },
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )

                }
                Text(
                    text = "Choose Seats",
                    color = Color.White,
                    fontSize = 24.sp
                )
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
                        .background(Color.White.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "",
                        tint = Color.White
                    )

                }
            }
            Spacer(modifier = Modifier.height(160.dp))
            Image(
                painter = painterResource(R.drawable.asets),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(horizontal = 20.dp).height(200.dp).width(370.dp)
            )
            Spacer(modifier = Modifier.height(60.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Row(verticalAlignment = Alignment.CenterVertically){
                    Box(modifier = Modifier.clip(shape = CircleShape).size(10.dp).background(Color.White)){}
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "available", fontSize = 16.sp, color = Color.White)
                }
                Row(verticalAlignment = Alignment.CenterVertically){
                    Box(modifier = Modifier.clip(shape = CircleShape).size(10.dp).background(Color(0xFFB6116B))){}
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Reserved", fontSize = 16.sp, color = Color.White)
                }
                Row(verticalAlignment = Alignment.CenterVertically){
                    Box(modifier = Modifier.clip(shape = CircleShape).size(10.dp).background(Color(0xFF09FBD3))){}
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Selected", fontSize = 16.sp, color = Color.White)
                }
            }
            Spacer(modifier = Modifier.height(80.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFFB6116B).copy(alpha = 0.3f),
                                Color(0xFF09FBD3).copy(alpha = 0.3f)
                            )
                        )
                    )
                    .background(Color.White.copy(alpha = 0.1f))
                    .border(
                        width = 1.dp,
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFFB6116B),
                                Color(0xFF09FBD3)
                            )
                        ),
                        shape = RoundedCornerShape(0.dp)
                    )
            ){
                Row {
                    Column(
                        modifier = Modifier.fillMaxHeight().weight(1f)
                    ) {
                        Spacer(modifier = Modifier.height(50.dp))
                        Row(modifier = Modifier.padding(start = 30.dp), verticalAlignment = Alignment.CenterVertically){
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp),
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = "April 28,2024  .  6 p.m",
                                color = Color.White,

                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(modifier = Modifier.padding(start = 30.dp), verticalAlignment = Alignment.CenterVertically){
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp),
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = "Vip section   .  Seat 9 ,10",
                                color = Color.White,

                                )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(modifier = Modifier.padding(start = 30.dp), verticalAlignment = Alignment.CenterVertically){
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp),
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = "Total: \$ 30",
                                color = Color.White,

                                )
                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxHeight().width(110.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .clip(RoundedCornerShape(topStart = 50.dp, bottomStart = 50.dp))
                                .background(Color(0xFF02796D))
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFF09FBD3),
                                    shape = RoundedCornerShape(topStart = 50.dp, bottomStart = 50.dp)
                                ), contentAlignment = Alignment.Center
                        ){
                            Box(
                                modifier = Modifier
                                    .size(65.dp)
                                    .clip(shape = CircleShape)
                                    .background(Color(0xFF53A698))
                                    .border(
                                        width = 1.dp,
                                        brush = Brush.horizontalGradient(
                                            colors = listOf(
                                                Color(0xFF09FBD3),
                                                Color(0xFF09FBD3).copy(alpha = 0f)
                                            )
                                        ),
                                        shape = CircleShape
                                    ).clickable { navController.navigate("mobileTicket") },
                                contentAlignment = Alignment.Center
                            ){
                                Text(
                                    text = "Buy",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}