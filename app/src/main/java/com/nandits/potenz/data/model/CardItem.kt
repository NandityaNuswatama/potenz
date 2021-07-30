package com.nandits.potenz.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardItem(
    val image: Int,
    val title: String,
    var url: String = "",
    var isSelected: Boolean = false
): Parcelable
