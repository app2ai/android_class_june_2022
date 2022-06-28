package com.rtech.studyapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rtech.studyapplication.model.Student
import com.rtech.studyapplication.model.repo.StudentRepo

class StudentViewModel(private val repo: StudentRepo): ViewModel() {
    private var _studentLiveData = MutableLiveData<List<Student>>()
    val studentLiveData: LiveData<List<Student>> = _studentLiveData

    fun getStudentData(){
        _studentLiveData.value = repo.getStudents()
    }
}