package com.rtech.studyapplication.model.repo

import com.rtech.studyapplication.model.Student
import com.rtech.studyapplication.model.dao.StudentDao

class StudentRepo(private val studentDao: StudentDao) {
    fun getStudents(): List<Student>? {
        return studentDao.getAllStudent().value
    }
}
