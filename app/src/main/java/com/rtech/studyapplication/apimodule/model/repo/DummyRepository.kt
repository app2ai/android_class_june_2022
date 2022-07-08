package com.rtech.studyapplication.apimodule.model.repo

import com.rtech.studyapplication.apimodule.model.service.ApiService
import com.rtech.studyapplication.apimodule.model.data.DummyData

class DummyRepository(val api: ApiService) {
    suspend fun getApiData(): DummyData? {
        println("API: Repo tk aaya")
        return api.getApiData().body()
    }
}