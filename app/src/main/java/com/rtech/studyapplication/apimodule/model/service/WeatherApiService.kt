package com.rtech.studyapplication.apimodule.model.service

import com.rtech.studyapplication.apimodule.model.data.GeoCodingData
import com.rtech.studyapplication.apimodule.model.data.WeatherAirQualityIndex
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("/data/2.5/air_pollution")
    suspend fun weatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKay: String
    ): Response<WeatherAirQualityIndex>

    @GET("/geo/1.0/direct")
    suspend fun geoCodingApiData(
        @Query("q") city: String,
        @Query("limit") limit: Int,
        @Query("appid") apiKey: String
    ): Response<GeoCodingData>
}
