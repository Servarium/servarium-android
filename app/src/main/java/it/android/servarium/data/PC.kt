package it.android.servarium.data

data class PC(
    val id: Int,
    val name: String,
    val os: String,
    val imageRes: Int,
    val isOnline: Boolean
)