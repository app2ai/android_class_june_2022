package com.rtech.studyapplication.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rtech.studyapplication.model.Student

@Dao
interface StudentDao {
    @Query("Select * From student")
    suspend fun getAllStudent(): List<Student>

    @Insert
    suspend fun addStudent(std: Student)
}