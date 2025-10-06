package com.myapp.roomdatabasepractice.DashBoard.EditContact


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
fun EditContactDeleteAndSaveButton(
    modifier: Modifier = Modifier,
    updateContact : () -> Unit,
    deleteContact : () -> Unit
) {

    Row (
        modifier = modifier.fillMaxWidth()
    ){
        Button(
            onClick = {
              deleteContact()
            },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red.copy(alpha = 0.2f)
            ),
            modifier = modifier
                .fillMaxWidth()
                .height(50.dp)
                .weight(1f)
        ) {

            Text(
                text = "Delete",
                fontSize = 20.sp,
                color = Color(0xffb97b75),

            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Button(
            onClick = {
                updateContact()
            },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4082F0)
            ),
            modifier = modifier
                .fillMaxWidth()
                .height(50.dp)
                .weight(1f)
        ) {

            Text(
                text = "Save",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.alpha(0.8f)
            )
        }
    }

}


