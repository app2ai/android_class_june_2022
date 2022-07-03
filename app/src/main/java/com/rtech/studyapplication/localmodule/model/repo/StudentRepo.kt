package com.rtech.studyapplication.localmodule.model.repo

import com.rtech.studyapplication.localmodule.model.Student
import com.rtech.studyapplication.localmodule.model.dao.StudentDao

class StudentRepo(private val studentDao: StudentDao) {
    suspend fun getStudents(): List<Student> {
        return studentDao.getAllStudent()
    }

    suspend fun addStudent(std: Student){
        studentDao.addStudent(std)
    }
}
