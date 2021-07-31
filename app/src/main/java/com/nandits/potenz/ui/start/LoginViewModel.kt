package com.nandits.potenz.ui.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.nandits.potenz.data.Repository
import com.nandits.potenz.data.model.UserModel

class LoginViewModel(private val repository: Repository): ViewModel() {
    fun login(name: String, body: UserModel) = repository.login(name, body).asLiveData()
    fun saveUser(userModel: UserModel) = repository.saveUser(userModel)
    fun getListUser() = repository.getListUser().asLiveData()
    fun getUser(name: String) = repository.getUserWName(name).asLiveData()
}