package com.myapp.roomdatabasepractice.core.mvi

import com.myapp.roomdatabasepractice.core.database.ContactsEntity

sealed interface UserActions {

    data class SaveContact(val contact: ContactsEntity) : UserActions
    data class DeleteContact(val contact: ContactsEntity) : UserActions

}