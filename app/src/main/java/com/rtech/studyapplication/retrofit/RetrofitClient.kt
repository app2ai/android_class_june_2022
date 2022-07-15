package com.rtech.studyapplication.retrofit

import com.rtech.studyapplication.apimodule.model.service.ApiService
import com.rtech.studyapplication.apimodule.model.service.WeatherApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// object keyword -> singleton class
object RetrofitClient {
    val weatherAPIKey = "5e262d194a16d0e8a4aa9b7c7e38cd66"
    val service: ApiService
    get() {
        return Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    val weatherService: WeatherApiService
        get(){
            return Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApiService::class.java)
        }

    val okHttpClient: OkHttpClient
        get(){
            return OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .build()
        }
}