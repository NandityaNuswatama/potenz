package com.nandits.potenz.utils

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.nandits.potenz.data.model.UserModel
import com.nandits.potenz.data.remote.Resource

object DataMapper {
    fun mapBuddiesToList(resource: Resource<JsonObject>): Resource<List<UserModel>> {
        return when (resource) {
            is Resource.Loading -> Resource.Loading()
            is Resource.Error -> Resource.Error(message = resource.message.toString())
            is Resource.Success -> Resource.Success(iterateUsersToList(resource.data as JsonObject))
        }
    }
    
    private fun iterateUsersToList(json: JsonObject): List<UserModel> {
        val arrayList = ArrayList<UserModel>()
        for ((_, value) in json.entrySet()) {
            val order = Gson().fromJson(value, UserModel::class.java)
            arrayList.add(order)
        }
        return arrayList
    }
}