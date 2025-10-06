package com.myapp.roomdatabasepractice.core

import android.app.Application
import androidx.room.Room
import com.myapp.roomdatabasepractice.core.database.ContactsRoomDB
import com.myapp.roomdatabasepractice.core.di.koinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppModule: Application() {
    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidContext(this@AppModule)
            modules(
                koinModule
            )
        }

    }

}