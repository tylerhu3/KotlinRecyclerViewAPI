/**
 * ApiService.kt - 2020/03/20
 * This is a required interface for retrofit2 to work properly,
 * need to decalred all the RESTful requests we need, the functionName assocaied with it
 * and the return type. Since we only need to grab data, we only have 1 GET request in this
 * interface currently*/
package com.example.zapapp
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    //Retrofit does most of the heavy lifting for us, we just need to declare the function name
    //and what it should return from the GET request
    @GET("/photos")
    fun  fetchAllItems(): Call<List<Item>>
}