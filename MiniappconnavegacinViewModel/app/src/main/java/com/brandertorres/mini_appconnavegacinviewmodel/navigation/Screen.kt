package com.brandertorres.mini_appconnavegacinviewmodel.navigation

sealed class Screen(val route: String) {
    object List : Screen("taskList")

    object Detail : Screen("taskDetail/{taskId}") {
        fun createRoute(taskId: Int) = "taskDetail/$taskId"
    }
}