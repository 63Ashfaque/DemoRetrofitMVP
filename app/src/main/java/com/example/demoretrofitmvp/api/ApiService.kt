package com.example.demoretrofitmvp.api

import com.example.demoretrofitmvp.model.data.User
import com.example.demoretrofitmvp.model.data.PostItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    //https://jsonplaceholder.typicode.com/users/1
    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Call<User>

    //https://jsonplaceholder.typicode.com/users
    @GET("users")
    fun getUsersList(): Call<List<User>>

    //https://jsonplaceholder.typicode.com/posts?userId=1
    @GET("posts")
    fun getUserPostData(@Query("userId") id: Int):Call<List<PostItem>>
}