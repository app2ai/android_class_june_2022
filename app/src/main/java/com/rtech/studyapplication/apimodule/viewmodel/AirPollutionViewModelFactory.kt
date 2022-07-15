package com.rtech.studyapplication.apimodule.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rtech.studyapplication.apimodule.model.repo.WeatherRepository

@Suppress("UNCHECKED_CAST")
class AirPollutionViewModelFactory(val repo: WeatherRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AirPolutionViewModel(repo) as T
    }
}