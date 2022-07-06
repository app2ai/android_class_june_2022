package com.rtech.studyapplication.apimodule.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rtech.studyapplication.apimodule.model.repo.DummyRepository

@Suppress("UNCHECKED_CAST")
class ApiViewModelFactory(val repo: DummyRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ApiViewModel(repo) as T
    }
}