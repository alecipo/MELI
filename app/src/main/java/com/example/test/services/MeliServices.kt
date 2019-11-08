package com.example.test.services

import com.example.test.models.SearchResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object RetrofitClientInstance {

    private var retrofit: Retrofit? = null

    val retrofitInstance: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(ConstantURL.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
}

interface GetDataService {

    @GET("search")
    fun getBySearch(@Query("q") item: String): Call<SearchResponse>
}