package com.myapp.roomdatabasepractice.DashBoard.EditContact

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myapp.roomdatabasepractice.core.ContactsViewModel


@Composable
fun EditContactMainScreen(
    modifier: Modifier = Modifier,
    backHandler: () -> Unit,
    contactId: Long,
    viewModel: ContactsViewModel
) {

    val singleContact by viewModel.getContactById(contactId).collectAsState(initial = null)






    Scaffold(
        topBar = { EditContactTopAppBar() }) { innerPadding ->

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            EditContactInfobox(
                contactId = contactId,
                viewModel = viewModel,
                backHandler = backHandler,
                singleContact = singleContact

            )

            /*   EditContactDeleteAndSaveButton(
                   modifier = Modifier.padding(top = 50.dp), updateContact = {
                       *//*viewModel.onAction(
                        UserActions.SaveContact(
                            contact = ContactsEntity(
                                userName = userName,
                                userNumber = userNumber,
                                userEmail = userEmail,
                                id = contactId
                            )
                        )*//*
                    //)
                    backHandler()
                }, backHandler = backHandler
            )*/
        }
    }
}

