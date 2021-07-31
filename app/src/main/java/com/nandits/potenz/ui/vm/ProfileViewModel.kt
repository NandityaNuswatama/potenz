package com.nandits.potenz.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.nandits.potenz.data.Repository

class ProfileViewModel(private val repository: Repository) : ViewModel() {
    fun logOut() = repository.logOut()
    fun getUser() = repository.getUser().asLiveData()
}