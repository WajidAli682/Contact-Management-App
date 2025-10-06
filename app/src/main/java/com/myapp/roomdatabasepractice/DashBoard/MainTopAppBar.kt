package com.myapp.roomdatabasepractice.DashBoard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(
    goToAddContact: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = "Contacts",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "",
                tint = Color.Black,
                modifier = modifier
                    .padding(end = 5.dp)
                    .size(35.dp)
                    .clickable {
                        goToAddContact()
                    }
            )
        }
    )
}
