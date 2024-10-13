package com.task.booktiket.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.task.booktiket.viewModel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(viewModel: AuthViewModel,  navController: NavController){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isSuccess by remember { mutableStateOf(false) }

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
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFFFE53BB).copy(alpha = 0.3f),
                            Color(0xFFFE53BB).copy(alpha = 0f)
                        ),
                        center = Offset(900f, 1500f),
                        radius = 600f
                    )
                )
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF09FBD3).copy(alpha = 0.3f),
                            Color(0xFF09FBD3).copy(alpha = 0f)
                        ),
                        center = Offset(200f, 600f),
                        radius = 600f
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(60.dp))
                Row(
                    modifier = Modifier.padding(60.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Login",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "",
                        modifier = Modifier.size(30.dp),
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(60.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                        .border(
                            width = 1.dp,
                            color = Color(0xFFFE53BB),
                            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                        )
                        .background(Color.White.copy(alpha = 0.4f)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(60.dp))
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Enter Email", fontSize = 12.sp) },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color(0xFF2E1371),
                            focusedBorderColor = Color(0xFF2E1371),
                            focusedLabelColor = Color(0xFF2E1371),
                            unfocusedLabelColor = Color(0xFF2E1371)
                        ),
                        modifier = Modifier
                            .width(280.dp)
                            .height(80.dp)
                            .padding(10.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Enter password", fontSize = 12.sp) },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color(0xFF2E1371),
                            focusedBorderColor = Color(0xFF2E1371),
                            focusedLabelColor = Color(0xFF2E1371),
                            unfocusedLabelColor = Color(0xFF2E1371)
                        ),
                        modifier = Modifier
                            .width(280.dp)
                            .height(80.dp)
                            .padding(10.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Row(
                        modifier = Modifier
                            .width(250.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "Forget Password ?",
                            color = Color(0xFF757171),

                            )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White.copy(alpha = 0.2f)
                        ),
                        modifier = Modifier
                            .width(280.dp)
                            .height(50.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .border(
                                width = 1.dp,
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFF09FBD3),
                                        Color.Black
                                    )
                                ),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        shape = RoundedCornerShape(0.dp),
                        onClick = {
                            viewModel.login(
                                email = email,
                                password = password,
                                onResult = {success ->
                                    isSuccess = success
                                    if (success){
                                        navController.navigate("movies"){
                                            popUpTo("login"){inclusive = true}
                                        }
                                    }
                                }
                            )
                        }
                    ) {
                        Text(
                            text = "Login",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth().padding(16.dp)
                    ) {
                        HorizontalDivider(
                            modifier = Modifier
                                .weight(1f)
                                .height(1.dp),
                            color = Color.Gray
                        )

                        Text(
                            text = "Or sign up with",
                            color = Color.Gray,
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .clickable {

                                },
                            fontSize = 14.sp,
                        )
                        HorizontalDivider(
                            modifier = Modifier
                                .weight(1f)
                                .height(1.dp),
                            color = Color.Gray
                        )
                    }
                }

            }
        }
    }
}