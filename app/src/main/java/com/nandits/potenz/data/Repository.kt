package com.nandits.potenz.data

import com.google.gson.JsonObject
import com.nandits.potenz.data.local.UserPreference
import com.nandits.potenz.data.model.UserModel
import com.nandits.potenz.data.remote.RemoteDataSource
import com.nandits.potenz.utils.DataMapper
import kotlinx.coroutines.flow.map

class Repository(
    private val remoteDataSource: RemoteDataSource,
    private val userPreference: UserPreference
) {
    fun login(name: String, body: UserModel) = remoteDataSource.createUser(name, body)
    
    fun getListUser() = remoteDataSource.getUsers().map {DataMapper.mapBuddiesToList(it)}
    
    fun getUser() = remoteDataSource.getUser(userPreference.getName().toString())
    
    fun getUserWName(name: String) = remoteDataSource.getUser(name)
    
    fun saveUser(user: UserModel) = userPreference.saveUser(user)
    
    fun getTicket() = userPreference.getTicket()
    
    fun logOut() = userPreference.eraseData()
    
    fun updateUser(body: JsonObject) = remoteDataSource.updateUser(userPreference.getName().toString(), body)
    
    fun updateTicketLocale(num: String) = userPreference.updateTicket(num)
}