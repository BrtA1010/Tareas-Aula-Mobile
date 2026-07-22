package com.brandertorres.mini_appconnavegacinviewmodel.data

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val isDone: Boolean = false
)

val sampleTasks = listOf(
    Task(1, "Comprar víveres", "Leche, pan, huevos y frutas para la semana."),
    Task(2, "Estudiar Kotlin", "Repasar corrutinas y Jetpack Compose Navigation."),
    Task(3, "Hacer ejercicio", "30 minutos de cardio y estiramiento."),
    Task(4, "Pagar servicios", "Luz, agua e internet antes del día 25."),
    Task(5, "Llamar al dentista", "Agendar cita para limpieza dental.")
)