package com.rtech.studyapplication.apimodule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rtech.studyapplication.R
import com.rtech.studyapplication.apimodule.model.repo.DummyRepository
import com.rtech.studyapplication.apimodule.viewmodel.ApiViewModel
import com.rtech.studyapplication.apimodule.viewmodel.ApiViewModelFactory
import com.rtech.studyapplication.localmodule.viewmodel.StudentViewModel
import com.rtech.studyapplication.retrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_api.recycler

class ApiActivity : AppCompatActivity() {
    private lateinit var viewModel: ApiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)
        val repo = DummyRepository(RetrofitClient.service)
        viewModel = ViewModelProvider(this, ApiViewModelFactory(repo)).get(ApiViewModel::class.java)
        viewModel.getApiData()
        observeData()
    }

    private fun observeData(){
        viewModel.apiDataLiveData.observe(this, Observer {
            if (it.isNullOrEmpty()){
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
            } else {
                val adaptor = ApiDataAdapter(this, it)
                recycler.adapter = adaptor
                adaptor.notifyDataSetChanged()
            }
        })
    }
}
