package com.rtech.studyapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rtech.studyapplication.R
import com.rtech.studyapplication.model.Student
import com.rtech.studyapplication.model.db.StudentDatabase
import com.rtech.studyapplication.model.repo.StudentRepo
import com.rtech.studyapplication.viewmodel.StudentViewModel
import com.rtech.studyapplication.viewmodel.StudentViewModelFactory
import kotlinx.android.synthetic.main.activity_my.btnOk

class MyActivity : AppCompatActivity() {

    // Loosly couple
    private lateinit var viewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
        val dao = StudentDatabase.getDbInstance(applicationContext).studentDao
        val studentRepo = StudentRepo(dao)
        viewModel = ViewModelProvider(this, StudentViewModelFactory(studentRepo)).get(StudentViewModel::class.java)
        observeViewModel()
        viewModel.getStudentData()
    }

    private fun observeViewModel() {
        viewModel.studentLiveData.observe(this, Observer { students->
            assignDataToView(students)
        })
    }

    private fun assignDataToView(it: List<Student>) {
        findViewById<TextView>(R.id.txtName).apply {
            text = it.toString()
        }
    }
}