package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface NetworkApi {

    // https://jsonplaceholder.typicode.com/posts
    @GET("posts")
    fun getData() : Call<List<JsonData>>
}