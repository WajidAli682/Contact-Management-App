package com.myapp.roomdatabasepractice.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactsEntity(
    var userName : String,
    var userNumber : String,
    var userEmail : String,

    @PrimaryKey(autoGenerate = true)
    val id : Long = 0
)

