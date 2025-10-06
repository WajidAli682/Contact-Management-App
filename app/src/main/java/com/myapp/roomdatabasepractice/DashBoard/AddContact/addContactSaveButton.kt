package com.myapp.roomdatabasepractice.DashBoard.AddContact



import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddContactSaveButton(
    modifier: Modifier = Modifier,
    saveContact : () -> Unit
) {

    Button(
        onClick = {saveContact()},
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4082F0)
        ),
        modifier = modifier.fillMaxWidth()
            .height(50.dp)
    ) {

        Text(
            text = "Save",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.alpha( 0.8f)
        )
    }

}


