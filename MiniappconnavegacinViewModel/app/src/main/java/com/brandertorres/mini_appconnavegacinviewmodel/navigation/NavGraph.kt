package com.brandertorres.mini_appconnavegacinviewmodel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.brandertorres.mini_appconnavegacinviewmodel.TaskViewModel
import com.brandertorres.mini_appconnavegacinviewmodel.ui.TaskDetailScreen
import com.brandertorres.mini_appconnavegacinviewmodel.ui.TaskListScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    viewModel: TaskViewModel
) {
    NavHost(navController = navController, startDestination = Screen.List.route) {
        composable(Screen.List.route) {
            TaskListScreen(
                viewModel = viewModel,
                onTaskClick = { taskId -> navController.navigate(Screen.Detail.createRoute(taskId)) }
            )
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("taskId") { type = NavType.IntType })
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getInt("taskId") ?: -1
            TaskDetailScreen(
                taskId = taskId,
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}