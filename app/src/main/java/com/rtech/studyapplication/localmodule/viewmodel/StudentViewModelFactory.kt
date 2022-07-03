package com.rtech.studyapplication.localmodule.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rtech.studyapplication.localmodule.model.repo.StudentRepo

@Suppress("UNCHECKED_CAST")
class StudentViewModelFactory(private val studentRepo: StudentRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StudentViewModel(studentRepo) as T
    }
}