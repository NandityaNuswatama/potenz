package com.nandits.potenz.data.remote

import com.google.gson.JsonObject
import com.nandits.potenz.data.model.UserModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    
    @PUT("user/{name}.json")
    suspend fun login(
        @Path("name") name: String,
        @Body body: UserModel
    ): Response<UserModel>
    
    @GET("user.json")
    suspend fun getUsers(): Response<JsonObject>
    
    @GET("user/{name}.json")
    suspend fun getUser(
        @Path("name") name: String
    ): Response<UserModel>
}