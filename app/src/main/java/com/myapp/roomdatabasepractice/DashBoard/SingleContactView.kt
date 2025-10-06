package com.myapp.roomdatabasepractice.DashBoard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SingleContactName(
    goToEditContact: () -> Unit,
    name: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                goToEditContact()
            }
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = name,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(vertical = 15.dp)
        )
        HorizontalDivider()
    }
}



