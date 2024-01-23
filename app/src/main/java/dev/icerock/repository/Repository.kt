package dev.icerock.repository

import dev.icerock.dto.Contact
import dev.icerock.ui.R

class Repository {

    fun saveContact() = listOf(
        Contact(0, "Aleksey", "Mikhailov", R.drawable.avatar),
        Contact(1, "Vasya", "", R.drawable.avatar),
        Contact(2, "Petr", "", R.drawable.avatar),
        Contact(3, "Kot", "", R.drawable.avatar)
    )
}