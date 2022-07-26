package com.rtech.studyapplication.localmodule.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rtech.studyapplication.R
import com.rtech.studyapplication.apimodule.view.AirPollutionActivity
import com.rtech.studyapplication.apimodule.view.ApiActivity
import com.rtech.studyapplication.localmodule.model.Student
import com.rtech.studyapplication.localmodule.model.db.StudentDatabase
import com.rtech.studyapplication.localmodule.model.repo.StudentRepo
import com.rtech.studyapplication.localmodule.viewmodel.StudentViewModel
import com.rtech.studyapplication.localmodule.viewmodel.StudentViewModelFactory
import com.rtech.studyapplication.notificationmodule.NotificationActivity
import com.rtech.studyapplication.test.Test
import kotlinx.android.synthetic.main.activity_my.btnGoToNext
import kotlinx.android.synthetic.main.activity_my.btnGoToPol
import kotlinx.android.synthetic.main.activity_my.btnOk
import kotlinx.android.synthetic.main.activity_my.txtClass
import kotlinx.android.synthetic.main.activity_my.txtName
import kotlinx.android.synthetic.main.activity_my.txtRollNo

class MyActivity : AppCompatActivity() {

    // Losly couple
    private lateinit var viewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
        val dao = StudentDatabase.getDbInstance(applicationContext).studentDao()
        val studentRepo = StudentRepo(dao)
        viewModel = ViewModelProvider(this, StudentViewModelFactory(studentRepo)).get(StudentViewModel::class.java)
        observeViewModel()
        viewModel.getStudentData()
        btnOk.setOnClickListener {
            viewModel.addStudent(Student(0, txtName.text.toString(), txtRollNo.text.toString(), txtClass.text.toString().toInt()))
        }
        btnGoToNext.setOnClickListener {
            val intent = Intent(this, ApiActivity::class.java)
            startActivity(intent)
        }
        btnGoToPol.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun observeViewModel() {
        viewModel.studentLiveData.observe(this, Observer { students->
            assignDataToView(students)
        })
    }

    private fun assignDataToView(it: List<Student>?) {
        findViewById<TextView>(R.id.txtClassAndRn).apply {
            text = it.toString()
        }
    }

    override fun onStart() {
        super.onStart()
        val data = Test.test(this)
        for (dd in data.customers.customer){
            for (d in dd.extended_fields.field){
                print("Value of: ${d}")
            }
        }
    }
}