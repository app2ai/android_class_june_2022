package com.rtech.studyapplication.apimodule.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rtech.studyapplication.apimodule.model.data.GeoCodingData
import com.rtech.studyapplication.apimodule.model.data.WeatherAirQualityIndex
import com.rtech.studyapplication.apimodule.model.repo.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AirPolutionViewModel(val repo: WeatherRepository) : ViewModel(){
    private var _weatherResponseLiveData = MutableLiveData<WeatherAirQualityIndex>()
    val weatherResponseLiveData: LiveData<WeatherAirQualityIndex> = _weatherResponseLiveData

    private var _geocodeResponseLiveData = MutableLiveData<GeoCodingData>()
    val geocodeResponseLiveData: LiveData<GeoCodingData> = _geocodeResponseLiveData

    // calling from View/F/A
    fun callPollutionApi(lat: Double, lon: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repo.getWeatherAirPollutionIndexDetails(lat, lon)
            _weatherResponseLiveData.value = data
        }
    }

    fun callGeocodeApi(cityName: String, limit: Int){
        viewModelScope.launch(Dispatchers.IO) {
            val data = repo.getGeoCodingDataFromAPI(cityName, limit)
            _geocodeResponseLiveData.value = data
        }
    }
}