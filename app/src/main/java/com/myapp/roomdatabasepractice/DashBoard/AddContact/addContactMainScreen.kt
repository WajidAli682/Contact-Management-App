package com.myapp.roomdatabasepractice.DashBoard.AddContact

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.myapp.roomdatabasepractice.core.database.ContactsEntity
import com.myapp.roomdatabasepractice.core.makeToast
import com.myapp.roomdatabasepractice.core.mvi.UserActions

@Composable
fun AddContactMainScreen(
    modifier: Modifier = Modifier,
    userActions: (UserActions) -> Unit,
    backHandler: () -> Unit
) {

    var userName by remember { mutableStateOf("") }

    var userNumber by remember { mutableStateOf("") }

    var userEmail by remember { mutableStateOf("") }

    val context = LocalContext.current

    Scaffold(
        topBar = { AddContactAppBar() }
    ) { innerPadding ->

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            AddContactInfobox(
                userName = userName,
                userNumber = userNumber,
                userEmail = userEmail,
                onNameChanged = { name ->
                    userName = name
                },
                onNumberChanged = { number ->
                    userNumber = number
                },
                onEmailChanged = { email ->
                    userEmail = email
                }
            )

            AddContactSaveButton(
                modifier = Modifier.padding(top = 80.dp),
                saveContact = {
                    if (userName.isNotEmpty() && userNumber.isNotEmpty() && userEmail.isNotEmpty()) {
                        userActions(
                            UserActions.SaveContact(
                                contact = ContactsEntity(
                                    userName = userName,
                                    userNumber = userNumber,
                                    userEmail = userEmail
                                )
                            )
                        )
                        backHandler()
                    }else{
                        makeToast(
                            context = context,
                            message = " All Fields Are Required "
                        )
                    }
                }
            )
        }
    }
}




