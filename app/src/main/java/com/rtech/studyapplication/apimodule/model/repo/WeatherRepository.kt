package com.rtech.studyapplication.apimodule.model.repo

import com.rtech.studyapplication.apimodule.model.data.GeoCodingData
import com.rtech.studyapplication.apimodule.model.data.WeatherAirQualityIndex
import com.rtech.studyapplication.apimodule.model.service.WeatherApiService
import com.rtech.studyapplication.retrofit.RetrofitClient.weatherAPIKey

// SST
class WeatherRepository constructor(val wservice: WeatherApiService) {
    suspend fun getWeatherAirPollutionIndexDetails(
        lat: Double,
        lon: Double
    ): WeatherAirQualityIndex? {
        return wservice.weatherData(apiKay = weatherAPIKey, lon = lon, lat = lat).body()
    }

    suspend fun getGeoCodingDataFromAPI(
        cityName: String,
        limit: Int
    ): GeoCodingData? {
        return wservice.geoCodingApiData(cityName, limit, weatherAPIKey).body()
    }
}