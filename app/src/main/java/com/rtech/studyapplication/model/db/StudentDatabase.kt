package com.rtech.studyapplication.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rtech.studyapplication.model.Student
import com.rtech.studyapplication.model.dao.StudentDao

@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {

    abstract val studentDao: StudentDao
    companion object {
        lateinit var instance: StudentDatabase
        fun getDbInstance(context: Context): StudentDatabase {
            synchronized(this) {
                instance = Room.databaseBuilder(
                    context,
                    StudentDatabase::class.java,
                    "student_db")
                    .build()
            }
            return instance
        }
    }
}