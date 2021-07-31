package com.nandits.potenz.data.remote

import com.google.gson.JsonObject
import com.nandits.potenz.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

class RemoteDataSource(private val apiService: ApiService) {
    fun createUser(name: String, body: UserModel): Flow<Resource<UserModel>> {
        return flow {
            emit(Resource.Loading())
            try {
                val response = apiService.login(name, body)
                if (response.isSuccessful) {
                    emit(Resource.Success(response.body() as UserModel))
                } else {
                    emit(Resource.Error(response.message()))
                    Timber.e(response.message())
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.toString()))
                Timber.e(e)
            }
        }.flowOn(Dispatchers.IO)
    }
    
    fun getUsers(): Flow<Resource<JsonObject>> {
        return flow {
            try {
                emit(Resource.Loading())
                val response = apiService.getUsers()
                if (response.isSuccessful) emit(Resource.Success(response.body() as JsonObject))
                else {
                    emit(Resource.Error(response.message()))
                    Timber.e(response.message())
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.toString()))
                Timber.e(e)
            }
        }.flowOn(Dispatchers.IO)
    }
    
    fun getUser(name:String): Flow<Resource<UserModel>> {
        return flow {
            try {
                emit(Resource.Loading())
                val response = apiService.getUser(name)
                if (response.isSuccessful) emit(Resource.Success(response.body() as UserModel))
                else {
                    emit(Resource.Error(response.message()))
                    Timber.e(response.message())
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.toString()))
                Timber.e(e)
            }
        }.flowOn(Dispatchers.IO)
    }
    
    fun updateUser(name: String, body: JsonObject): Flow<Resource<UserModel>> {
        return flow {
            emit(Resource.Loading())
            try {
                val response = apiService.updateUser(name, body)
                if (response.isSuccessful) {
                    emit(Resource.Success(response.body() as UserModel))
                } else {
                    emit(Resource.Error(response.message()))
                    Timber.e(response.message())
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.toString()))
                Timber.e(e)
            }
        }.flowOn(Dispatchers.IO)
    }
}