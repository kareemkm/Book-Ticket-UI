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
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
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
fun MobileTicket(navController: NavController){

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .blur(100.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF130B2B))
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(Color(0xFF09FBD3).copy(alpha = 0.2f),Color(0xFF09FBD3).copy(alpha = 0f)),
                            center = Offset(200f,600f),
                            radius = 600f
                        )
                    )
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(Color(0xFFFE53BB).copy(alpha = 0.2f),Color(0xFFFE53BB).copy(alpha = 0f)),
                            center = Offset(200f,1800f),
                            radius = 600f
                        )
                    )
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(Color(0xFFFE53BB).copy(alpha = 0.2f),Color(0xFFFE53BB).copy(alpha = 0f)),
                            center = Offset(800f,1100f),
                            radius = 600f
                        )
                    )
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(Color(0xFF09FBD3).copy(alpha = 0.2f),Color(0xFF09FBD3).copy(alpha = 0f)),
                            center = Offset(1000f,1800f),
                            radius = 600f
                        )
                    )
            ) {

            }
        }
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
                        .clickable { navController.navigate("chooseSeats") },
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )

                }
                Text(
                    text = "Mobile Ticket",
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
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "",
                        tint = Color.White
                    )

                }
            }
            Spacer(modifier = Modifier.height(100.dp))
            Box(
                modifier = Modifier
                    .width(250.dp)
                    .height(500.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(width = 1.dp, color = Color(0xFF09FBD3), shape = RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(R.drawable.ticket_image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                  Box(modifier = Modifier.fillMaxWidth().weight(2f))
                  Box(modifier = Modifier
                      .fillMaxWidth()
                      .weight(1f)
                  ) {
                      Image(
                          painter = painterResource(R.drawable.rectangle4),
                          contentDescription = "",
                          contentScale = ContentScale.FillBounds,
                          alpha = 0.7f,
                          modifier = Modifier.fillMaxSize()
                      )
                      Column(modifier = Modifier.fillMaxSize().padding(top = 50.dp).padding(horizontal = 30.dp)) {
                          Row(
                              modifier = Modifier.fillMaxWidth(),
                              verticalAlignment = Alignment.CenterVertically,
                              horizontalArrangement = Arrangement.SpaceBetween
                          ) {
                              Text(
                                  text = "Date:April 24",
                                  fontSize = 14.sp,
                                  color = Color.Black,
                                  fontWeight = FontWeight.Bold
                              )
                              Text(
                                  text = "Time:6 p.m.",
                                  fontSize = 14.sp,
                                  color = Color.Black,
                                  fontWeight = FontWeight.Bold
                              )

                          }
                          Spacer(modifier = Modifier.height(15.dp))
                          Row(
                              modifier = Modifier.fillMaxWidth(),
                              verticalAlignment = Alignment.CenterVertically,
                              horizontalArrangement = Arrangement.SpaceBetween
                          ) {
                              Text(
                                  text = "Row: 2",
                                  fontSize = 14.sp,
                                  color = Color.Black,
                                  fontWeight = FontWeight.Bold
                              )
                              Text(
                                  text = "seats:9,10",
                                  fontSize = 14.sp,
                                  color = Color.Black,
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
