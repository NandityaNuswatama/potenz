package com.nandits.potenz.ui.profile

import androidx.lifecycle.ViewModel
import com.nandits.potenz.data.Repository

class ProfileViewModel(private val repository: Repository) : ViewModel() {
    fun logOut() = repository.logOut()
}