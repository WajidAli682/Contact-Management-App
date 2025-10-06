package com.myapp.roomdatabasepractice.core.Navigation

import kotlinx.serialization.Serializable

sealed class NavigationScreens {


    @Serializable
    object MainScreen{

        @Serializable
        object AddContactScreen

        @Serializable
        data class EditContact(val id: Long)

    }




}