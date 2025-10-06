package com.myapp.roomdatabasepractice.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.roomdatabasepractice.core.database.ContactsDao
import com.myapp.roomdatabasepractice.core.database.ContactsEntity
import com.myapp.roomdatabasepractice.core.mvi.UserActions
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ContactsViewModel(
    private val dao: ContactsDao
) : ViewModel() {




    val contacts : StateFlow<List<ContactsEntity>> = dao.getByuUsernameAsc()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())



    fun onAction(action: UserActions) {
        when (action) {

            is UserActions.SaveContact -> {
                viewModelScope.launch {
                    dao.insertOrUpdateContacts(
                        contactsEntity = action.contact
                    )
                }

            }

            is UserActions.DeleteContact -> {
                viewModelScope.launch {
                    dao.deleteContact(
                        contactsEntity = action.contact
                    )
                }

            }


        }

    }

    fun getContactById(id: Long): StateFlow<ContactsEntity?> =
        dao.getContactById(id)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

}