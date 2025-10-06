package com.myapp.roomdatabasepractice.core.di

import androidx.room.Room
import com.myapp.roomdatabasepractice.core.ContactsViewModel
import org.koin.core.module.dsl.viewModel
import com.myapp.roomdatabasepractice.core.database.ContactsRoomDB
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


var koinModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            ContactsRoomDB::class.java,
            "contacts_db"
        ).build()
    }

    single {  get<ContactsRoomDB>().contactsDao }


    viewModel { ContactsViewModel(get()) }



}