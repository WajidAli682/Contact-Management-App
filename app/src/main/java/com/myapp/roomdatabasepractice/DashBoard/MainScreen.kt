package com.myapp.roomdatabasepractice.DashBoard


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapp.roomdatabasepractice.DashBoard.SwipeToDelete.SwipeToDeleteBox
import com.myapp.roomdatabasepractice.core.ContactsViewModel
import com.myapp.roomdatabasepractice.core.mvi.UserActions


@Composable
fun MainScreen(
    goToAddContact: () -> Unit,
    goToEditContact: (Long) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ContactsViewModel
) {
    val contactList = viewModel.contacts.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    val filteredContacts = contactList.value.filter { contacts ->
        contacts.userName.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            MainTopAppBar(
                goToAddContact = goToAddContact
            )
        }
    ) { innerPadding ->

        Column(
            modifier = modifier
                .padding(innerPadding)
                .padding(horizontal = 15.dp)
        ) {

            ContactsSearch(
                textFiledValue = searchQuery,
                onValueChanged = { newValue ->
                    searchQuery = newValue
                }
            )

            if (searchQuery.isEmpty()) {
                if (contactList.value.isNotEmpty()) {
                    LazyColumn(
                        modifier = Modifier.padding(top = 15.dp)
                    ) {
                        items(items = contactList.value, key = { it.userName }) { contacts ->
                            SwipeToDeleteBox(
                                item = contacts,
                                onDelete = {
                                    viewModel.onAction(
                                        action = UserActions.DeleteContact(
                                            contact = contacts
                                        )
                                    )
                                }
                            ) { contact ->
                                SingleContactName(
                                    goToEditContact = { goToEditContact(contact.id) },
                                    name = contact.userName
                                )
                            }
                        }
                    }
                } else {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Text(
                            text = "NO Contacts Available",
                            fontSize = 25.sp,
                            color = Color.Black.copy(alpha = 0.5f),
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier.padding(top = 15.dp)
                ) {
                    items(items = filteredContacts, key = { it.userName }) { contacts ->
                        SwipeToDeleteBox(
                            item = contacts,
                            onDelete = {
                                viewModel.onAction(
                                    action = UserActions.DeleteContact(
                                        contact = contacts
                                    )
                                )
                            }
                        ) { contact ->
                            SingleContactName(
                                goToEditContact = { goToEditContact(contact.id) },
                                name = contact.userName
                            )
                        }
                    }
                }
            }
        }
    }
}