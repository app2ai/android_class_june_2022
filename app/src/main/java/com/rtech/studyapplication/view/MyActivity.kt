package com.rtech.studyapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rtech.studyapplication.R
import com.rtech.studyapplication.model.Student
import com.rtech.studyapplication.viewmodel.StudentViewModel

class MyActivity : AppCompatActivity() {

    // Loosly couple
    private lateinit var viewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
        viewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        observeViewModel()
        viewModel.getStudentData()
    }

    private fun observeViewModel() {
        viewModel.studentLiveData.observe(this, Observer { student->
            assignDataToView(student)
        })
    }

    private fun assignDataToView(it: Student?) {
        findViewById<TextView>(R.id.txtName).apply {
            text = it?.name
        }

        findViewById<TextView>(R.id.txtClassAndRn).apply {
            text = "${it?.classN} ${it?.rollNo}"
        }
    }
}