package com.rtech.studyapplication.apimodule.model.service

import com.rtech.studyapplication.apimodule.model.data.DummyData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    // HTTP method
    @GET("/demos/marvel/")
    suspend fun getApiData(): Response<DummyData>
}
