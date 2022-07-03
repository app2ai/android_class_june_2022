package com.rtech.studyapplication.localmodule.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rtech.studyapplication.localmodule.model.Student
import com.rtech.studyapplication.localmodule.model.dao.StudentDao

@Database(entities = [Student::class], version = 1, exportSchema = false)
public abstract class StudentDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    companion object {
        @Volatile
        private var INSTANCE: StudentDatabase? = null

        fun getDbInstance(context: Context): StudentDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    StudentDatabase::class.java,
                    "studentdb")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}