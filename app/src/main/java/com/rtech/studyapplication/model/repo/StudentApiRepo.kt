package com.rtech.studyapplication.model.repo

import com.rtech.studyapplication.model.Student

class StudentApiRepo {
    fun makeAStudent(): Student{
        return Student("Kushal", "C12", 10)
    }
}