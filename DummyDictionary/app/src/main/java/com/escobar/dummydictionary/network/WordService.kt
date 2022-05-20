package com.escobar.dummydictionary.network

import com.escobar.dummydictionary.network.dto.LoginRequest
import com.escobar.dummydictionary.network.dto.LoginResponse
import com.escobar.dummydictionary.network.dto.WordResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface WordService {

    @GET("/words")
    suspend fun getAllWord(): WordResponse

    @POST("/login")
    suspend fun login(@Body credentials: LoginRequest): LoginResponse
}