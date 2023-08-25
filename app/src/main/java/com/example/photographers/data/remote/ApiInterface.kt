package com.example.photographers.data.remote

import com.example.photographers.data.remote.interceptors.HeaderInterceptor
import com.example.photographers.domain.model.Data
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("photographer")
    suspend fun getData(): Response<Data> //Obtain data from api
    companion object {

        private const val BASE_URL = "https://inphototest.app2u.es/api/"
        fun create(): ApiInterface {
            val client = OkHttpClient.Builder()
                .addInterceptor(HeaderInterceptor("test@gmail.com", "1234")) //interceptor header for basic auth for api
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }

    }

}