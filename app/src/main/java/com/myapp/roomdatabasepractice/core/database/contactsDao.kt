package com.myapp.roomdatabasepractice.core.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactsDao {

    @Upsert
    suspend fun insertOrUpdateContacts(contactsEntity: ContactsEntity)

    @Delete
    suspend fun deleteContact(contactsEntity: ContactsEntity)

   @Query( "SELECT * FROM contactsentity ORDER BY userName ASC")
   fun getByuUsernameAsc(): Flow<List<ContactsEntity>>

   @Query( " SELECT * FROM contactsentity WHERE id = :id LIMIT 1")
   fun getContactById(id: Long): Flow<ContactsEntity?>



}