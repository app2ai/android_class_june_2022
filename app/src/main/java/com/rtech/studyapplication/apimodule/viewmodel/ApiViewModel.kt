package com.rtech.studyapplication.apimodule.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rtech.studyapplication.apimodule.model.data.DummyData
import com.rtech.studyapplication.apimodule.model.repo.DummyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApiViewModel(val repo: DummyRepository): ViewModel() {
    private var _apiDataLiveData = MutableLiveData<DummyData?>()
    val apiDataLiveData: LiveData<DummyData?> = _apiDataLiveData

    fun getApiData(){
        viewModelScope.launch {
            val data = repo.getApiData()
            _apiDataLiveData.postValue(data)
        }
    }
}