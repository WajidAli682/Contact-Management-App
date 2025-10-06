package com.myapp.roomdatabasepractice.core.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.myapp.roomdatabasepractice.DashBoard.AddContact.AddContactMainScreen
import com.myapp.roomdatabasepractice.DashBoard.EditContact.EditContactMainScreen
import com.myapp.roomdatabasepractice.DashBoard.MainScreen
import com.myapp.roomdatabasepractice.core.ContactsViewModel
import com.myapp.roomdatabasepractice.core.mvi.UserActions


@Composable
fun Navigation(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    userActions: (UserActions) -> Unit,
    viewModel: ContactsViewModel
) {


    NavHost(
        navController = navHostController,
        startDestination = NavigationScreens.MainScreen
    ) {

        myNavGraph(
            navHostController = navHostController,
            userActions = userActions,
            viewModel = viewModel
        )
    }

}


fun NavGraphBuilder.myNavGraph(
    navHostController: NavHostController,
    userActions: (UserActions) -> Unit,
    viewModel: ContactsViewModel
) {


    composable<NavigationScreens.MainScreen> {
        MainScreen(
            goToAddContact = { navHostController.navigate(route = NavigationScreens.MainScreen.AddContactScreen) },
            goToEditContact = { data ->
                navHostController.navigate(route = NavigationScreens.MainScreen.EditContact(data))
            },
            viewModel = viewModel,

            )
    }

    composable<NavigationScreens.MainScreen.AddContactScreen> {
        AddContactMainScreen(
            userActions = userActions,
            backHandler = { navHostController.navigateUp() }
        )
    }

    composable<NavigationScreens.MainScreen.EditContact> {entry->

        val contactId = entry.toRoute<NavigationScreens.MainScreen.EditContact>()
        EditContactMainScreen(
            backHandler = { navHostController.navigateUp() },
            contactId = contactId.id,
            viewModel = viewModel,
        )

    }

}