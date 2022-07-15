package com.rtech.studyapplication.apimodule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rtech.studyapplication.R
import com.rtech.studyapplication.apimodule.model.repo.WeatherRepository
import com.rtech.studyapplication.apimodule.viewmodel.AirPollutionViewModelFactory
import com.rtech.studyapplication.apimodule.viewmodel.AirPolutionViewModel
import com.rtech.studyapplication.apimodule.viewmodel.ApiViewModel
import com.rtech.studyapplication.apimodule.viewmodel.ApiViewModelFactory
import com.rtech.studyapplication.retrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_air_pollution.pollutionText

class AirPollutionActivity : AppCompatActivity() {
    private lateinit var vm : AirPolutionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_air_pollution)
        val service = RetrofitClient.weatherService
        val repo = WeatherRepository(service)
        vm = ViewModelProvider(this, AirPollutionViewModelFactory(repo)).get(AirPolutionViewModel::class.java)
        vm.callPollutionApi(50.0, 50.0)
        vm.weatherResponseLiveData.observe(this, Observer { response->
            if (response == null){
                Toast.makeText(this, "API failed", Toast.LENGTH_LONG).show()
            } else {
                pollutionText.text = response.list.get(0).main.aqi.toString()
            }
        })
    }
}