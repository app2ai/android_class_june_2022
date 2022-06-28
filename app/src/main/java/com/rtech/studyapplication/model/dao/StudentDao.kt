package com.rtech.studyapplication.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.rtech.studyapplication.model.Student

@Dao
interface StudentDao {
    @Query("Select * From student")
    fun getAllStudent(): LiveData<List<Student>>
}