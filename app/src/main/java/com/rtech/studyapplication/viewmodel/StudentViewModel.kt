package com.rtech.studyapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rtech.studyapplication.model.Student
import com.rtech.studyapplication.model.repo.StudentRepo
import kotlinx.coroutines.launch

class StudentViewModel(private val repo: StudentRepo): ViewModel() {
    private var _studentLiveData = MutableLiveData<List<Student>?>()
    val studentLiveData: LiveData<List<Student>?> = _studentLiveData

    fun getStudentData(){
        viewModelScope.launch {
            _studentLiveData.postValue(repo.getStudents())
        }
    }

    fun addStudent(std: Student){
        viewModelScope.launch {
            repo.addStudent(std)
        }
        getStudentData()
    }
}