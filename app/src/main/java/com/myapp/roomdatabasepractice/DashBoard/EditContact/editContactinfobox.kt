package com.myapp.roomdatabasepractice.DashBoard.EditContact

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapp.roomdatabasepractice.core.ContactsViewModel
import com.myapp.roomdatabasepractice.core.database.ContactsEntity
import com.myapp.roomdatabasepractice.core.mvi.UserActions


@Composable
fun EditContactInfobox(
    singleContact: ContactsEntity?,
    contactId: Long,
    viewModel: ContactsViewModel,
    modifier: Modifier = Modifier,
    backHandler: () -> Unit
) {
    var userName by remember { mutableStateOf("") }
    var userNumber by remember { mutableStateOf("") }
    var userEmail by remember { mutableStateOf("") }

    LaunchedEffect(singleContact) {
        singleContact?.let { contact ->
            userName = contact.userName
            userNumber = contact.userNumber
            userEmail = contact.userEmail
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {

        InputField(label = "Name", value = userName) { data -> userName = data }
        Spacer(Modifier.height(20.dp))

        InputField(label = "Number", value = userNumber) { data -> userNumber = data }
        Spacer(Modifier.height(20.dp))

        InputField(label = "Email", value = userEmail) { data -> userEmail = data }

        Spacer(Modifier.height(50.dp))

        EditContactDeleteAndSaveButton(
            updateContact = {
                viewModel.onAction(
                    UserActions.SaveContact(
                        contact = ContactsEntity(
                            userName = userName,
                            userNumber = userNumber,
                            userEmail = userEmail,
                            id = contactId
                        )
                    )
                )
                backHandler()
            },
            deleteContact = {
                singleContact.let {
                    viewModel.onAction(
                        action = UserActions.DeleteContact(
                            contact = ContactsEntity(
                                userName = userName,
                                userNumber = userNumber,
                                userEmail = userEmail,
                                id = contactId
                            )
                        )
                    )
                }
                backHandler()
            }
        )
    }
}

@Composable
fun InputField(label: String, value: String, onValueChange: (String) -> Unit) {
    Text(
        text = label,
        color = Color(0xFF333333),
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    )

    Spacer(Modifier.height(6.dp))

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            fontSize = 18.sp,
            color = Color.Black
        ),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .shadow(2.dp, RoundedCornerShape(10.dp))
            .background(Color(0xFFF9F9F9), RoundedCornerShape(10.dp))
            .border(1.dp, Color(0xFFDDDDDD), RoundedCornerShape(10.dp))
            .padding(horizontal = 14.dp, vertical = 12.dp),
        decorationBox = { innerTextField ->
            Box(
                contentAlignment = Alignment.CenterStart
            ) {
                innerTextField()
            }
        }
    )
}

