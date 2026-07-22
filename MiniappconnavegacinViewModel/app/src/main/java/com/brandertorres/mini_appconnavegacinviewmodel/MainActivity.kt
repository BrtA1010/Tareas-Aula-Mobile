package com.brandertorres.mini_appconnavegacinviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.brandertorres.mini_appconnavegacinviewmodel.navigation.AppNavGraph
import com.brandertorres.mini_appconnavegacinviewmodel.ui.theme.MiniappConNavegaciónViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiniappConNavegaciónViewModelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    val taskViewModel: TaskViewModel = viewModel()

                    AppNavGraph(
                        navController = navController,
                        viewModel = taskViewModel
                    )
                }
            }
        }
    }
}