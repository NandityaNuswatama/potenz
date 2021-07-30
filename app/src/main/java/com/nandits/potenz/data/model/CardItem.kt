package com.nandits.potenz.data.model

data class CardItem(
    val image: Int,
    val title: String,
    var url: String = "",
    var isSelected: Boolean = false
)
