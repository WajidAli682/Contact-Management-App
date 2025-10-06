package com.myapp.roomdatabasepractice.DashBoard.AddContact

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactAppBar(modifier: Modifier = Modifier) {

    TopAppBar(
        title = {
            Text(
                text = "Add New Contact",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        }
    )

}