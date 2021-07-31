package com.nandits.potenz.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.google.gson.JsonObject
import com.nandits.potenz.data.Repository
import com.nandits.potenz.data.model.UserModel
import com.nandits.potenz.data.remote.Resource

class PaymentViewModel(private val repository: Repository): ViewModel() {
    fun buyTicket(total: String): LiveData<Resource<UserModel>> {
        val body: JsonObject = JsonObject().apply {
            addProperty("subscription", total)
        }
        return repository.updateUser(body).asLiveData()
    }
}