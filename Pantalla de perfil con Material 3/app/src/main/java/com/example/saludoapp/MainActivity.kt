package com.example.saludoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PerfilScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilScreen() {
    // 1. Estado para controlar el modo oscuro
    var darkMode by remember { mutableStateOf(false) }

    // 2. Definimos las paletas de colores dinámicas
    val coloresModoOscuro = darkColorScheme(
        primary = Color(0xFFEF5350), // Un rojo duro para los acentos
        background = Color(0xFF09090B), // Fondo mate oscuro sádico
        surface = Color(0xFF18181B), // El color de las tarjetas en modo oscuro
        onBackground = Color.White,
        onSurface = Color.White
    )

    val coloresModoClaro = lightColorScheme(
        primary = Color(0xFFD32F2F),
        background = Color(0xFFF4F4F5),
        surface = Color.White,
        onBackground = Color.Black,
        onSurface = Color.Black
    )

    // 3. Aplicamos el tema dinámicamente según el estado de 'darkMode'
    MaterialTheme(
        colorScheme = if (darkMode) coloresModoOscuro else coloresModoClaro
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Mi Perfil") },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Edit, "Editar")
                        }
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {},
                    containerColor = MaterialTheme.colorScheme.primary // Usa el color del tema
                ) {
                    Icon(Icons.Default.CameraAlt, "Foto")
                }
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background) // Pinta el fondo dinámico
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Avatar circular
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "BT",
                        color = Color.White,
                        fontSize = 24.sp
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Tarjeta 1: Datos Personales
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Nombre: Brander Torres", style = MaterialTheme.typography.bodyLarge)
                        Text("Carrera: Desarrollo de Software", style = MaterialTheme.typography.bodyMedium)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Tarjeta 2: Contacto
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Email: Brandellabrega@gmail.com", style = MaterialTheme.typography.bodyMedium)
                        Text("Teléfono: 829-215-0196", style = MaterialTheme.typography.bodyMedium)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Tarjeta 3: Habilidades
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Habilidades", style = MaterialTheme.typography.titleSmall)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("• Aprendiendo Kotlin")
                        Text("• Creacion de webs con Next")
                        Text("• Uso justo de IA")
                        Text("• Github ")
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Fila del Switch para controlar el Modo Oscuro
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Dark Mode", fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground)
                    Spacer(modifier = Modifier.weight(1f))
                    Switch(
                        checked = darkMode,
                        onCheckedChange = { darkMode = it }
                    )
                }
            }
        }
    }
}