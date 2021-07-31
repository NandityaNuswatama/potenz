package com.nandits.potenz.data

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
    
    fun logOut() = userPreference.eraseData()
}