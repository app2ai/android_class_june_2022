package com.rtech.studyapplication.retrofit

import com.rtech.studyapplication.apimodule.model.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// object keyword -> singleton class
object RetrofitClient {
    val service: ApiService
    get() {
        return Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}