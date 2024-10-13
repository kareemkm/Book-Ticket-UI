package com.task.booktiket.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.task.booktiket.R
import com.task.booktiket.viewModel.AuthViewModel
import kotlin.math.abs

@Composable
fun Movies(viewModel: AuthViewModel,navController: NavController){

    val categories = listOf("All Movies","For Kids ","My Tickets")
    var selectedCategory  by remember { mutableStateOf("All Movies") }

    val types = listOf("Action","Comedy","Romance","Thriller","Fantasy")
    var selectedTypes by remember { mutableStateOf("Action") }

    val images = listOf(
        R.drawable.film1,
        R.drawable.film2,
        R.drawable.film3,
        R.drawable.film1,
        R.drawable.film2,
        R.drawable.film3,
        R.drawable.film1,
        R.drawable.film2,
        R.drawable.film3,
        R.drawable.film1,
        R.drawable.film2,
        R.drawable.film3,


    )
    val lazyState = rememberLazyListState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF2E1371),
                        Color(0xFF130B2B)
                    )
                )
            )
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFFFE53BB).copy(alpha = 0.4f),
                            Color(0xFFFE53BB).copy(alpha = 0f)
                        ),
                        center = Offset(900f, 1500f),
                        radius = 600f
                    )
                )
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF09FBD3).copy(alpha = 0.4f),
                            Color(0xFF09FBD3).copy(alpha = 0f)
                        ),
                        center = Offset(200f, 700f),
                        radius = 600f
                    )
                )
        ){
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyRow (
                    modifier = Modifier.fillMaxWidth().padding(top = 60.dp, bottom = 16.dp).padding(horizontal = 30.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    items(categories){category ->
                        val isSelected =selectedCategory == category
                        Text(
                            text = category,
                            textAlign = TextAlign.Center,
                            color = if (isSelected)  Color(0xFF09FBD3) else Color.White,
                            fontWeight = if (isSelected )FontWeight.Bold else null,
                            modifier = Modifier
                                .padding(horizontal = if (isSelected) 40.dp else 0.dp)
                                .clickable {
                                selectedCategory = category
                            }
                        )
                    }
                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    item{
                        Text(
                            text = "Coming Soon",
                            fontSize = 24.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(start = 16.dp)
                        )
                    }
                    item {
                        Image(
                            painter = painterResource(R.drawable.coming_card),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp)

                        )
                    }
                    item {
                        LazyRow(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            items(types){type ->
                                val isSelected = selectedTypes == type
                                Text(
                                    text = type,
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .clip(RoundedCornerShape(5.dp))
                                        .background(if (isSelected) Color(0xFFB6116B) else Color(0xFF1E1F27))
                                        .padding(5.dp).clickable {
                                            selectedTypes = type
                                        }
                                )
                            }
                        }
                    }
                    item{
                        Text(
                            text = "Now Showing",
                            fontSize = 24.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(start = 16.dp)
                        )
                    }
                    item { Spacer(modifier = Modifier.height(16.dp)) }
                    item {
                        LazyRow(
                            state = lazyState,
                            modifier = Modifier.fillMaxWidth().height(300.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            items(images.size){index ->
                                val scale = remember { mutableFloatStateOf(1f) }
                                val animatedScale = animateFloatAsState(targetValue = scale.floatValue, label = "")
                                Image(
                                    painter = painterResource(id = images[index]),
                                    contentDescription = "",
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier
                                        .padding(10.dp).clip(shape = RoundedCornerShape(10.dp))
                                        .height(220.dp*animatedScale.value).width(148.dp*animatedScale.value)
                                        .onGloballyPositioned {layoutCoordinates ->
                                            val parentCoordinates = layoutCoordinates.parentCoordinates ?: return@onGloballyPositioned
                                            val parentWidth = parentCoordinates.size.width*2
                                            val imageCenter = layoutCoordinates.positionInParent().x + layoutCoordinates.size.width / 2
                                            val distanceFromCenter = abs(imageCenter - parentWidth / 2)
                                            scale.floatValue = if (distanceFromCenter < (parentWidth / 3 - 100.dp.value)) 1.3f else 1f
                                        }
                                        .clickable { navController.navigate("filmInformation") }
                                )
                            }
                        }
                    }
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "13+",
                                fontSize = 12.sp,
                                color = Color.White,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(Color(0xFF484747))
                                    .padding(5.dp)
                            )
                            Text(
                                text = "Action",
                                fontSize = 12.sp,
                                color = Color.White,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(Color(0xFF484747))
                                    .padding(5.dp)
                                    .clickable {
                                        viewModel.signOut()
                                        navController.navigate("signing"){
                                            popUpTo("movies"){inclusive = true}
                                        }
                                    }
                            )
                            Text(
                                text = "IMAX",
                                fontSize = 12.sp,
                                color = Color.White,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(Color(0xFF484747))
                                    .padding(5.dp)
                            )

                        }
                    }
                }
            }
        }
    }
}