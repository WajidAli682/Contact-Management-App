package com.myapp.roomdatabasepractice.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ContactsEntity::class] ,
    version = 1
)
abstract class ContactsRoomDB: RoomDatabase(){

    abstract val contactsDao: ContactsDao

}
