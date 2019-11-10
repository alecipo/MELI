package com.example.test.services

import com.example.test.models.Product
import com.example.test.models.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MeliServices {

    @GET("sites/MLA/search")
    fun getBySearch(@Query("q") item: String): Call<SearchResponse>

    @GET("items/{id}")
    fun getProduct(@Path("id") id: String): Call<Product>
}