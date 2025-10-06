package com.myapp.roomdatabasepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.myapp.roomdatabasepractice.core.ContactsViewModel
import com.myapp.roomdatabasepractice.core.Navigation.Navigation
import com.myapp.roomdatabasepractice.ui.theme.RoomDatabasePracticeTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomDatabasePracticeTheme {


                val navHostController = rememberNavController()

                val myViewModel: ContactsViewModel = koinViewModel()

                Navigation(
                    navHostController = navHostController,
                    userActions = myViewModel::onAction,
                    viewModel = myViewModel

                )

            }
        }
    }


}

