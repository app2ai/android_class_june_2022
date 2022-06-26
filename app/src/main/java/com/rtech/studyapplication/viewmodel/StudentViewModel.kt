package com.rtech.studyapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rtech.studyapplication.model.Student
import com.rtech.studyapplication.model.repo.StudentApiRepo

class StudentViewModel: ViewModel() {

    // LiveData Data aaya -> Observer -> subsriber -> Data beja
    // VM -> P -> C -> Logic likhte hai
    // ViewModel -> Source
    // logic clas + RL
    // MMMV vs other
    // 1. Boilerplate code
    // 2. Coupling
    // 3. Loose coupling

    private var _studentLiveData = MutableLiveData<Student>()
    val studentLiveData: LiveData<Student> = _studentLiveData

    fun getStudentData(){
        val repo = StudentApiRepo()
        _studentLiveData.value = repo.makeAStudent()
    }
}