package com.rtech.studyapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rtech.studyapplication.model.repo.StudentRepo

@Suppress("UNCHECKED_CAST")
class StudentViewModelFactory(private val studentRepo: StudentRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StudentViewModel(studentRepo) as T
    }
}