package com.rtech.studyapplication.apimodule.model.service

import androidx.room.Delete
import androidx.room.Update
import com.rtech.studyapplication.apimodule.model.data.DummyData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST

interface ApiService {
    // HTTP method
    @GET("/demos/marvel/")
    suspend fun getApiData(): Response<DummyData>
}
