package com.rtech.studyapplication.bindings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.rtech.studyapplication.R
import com.rtech.studyapplication.databinding.ActivityApiBinding
import com.rtech.studyapplication.databinding.ActivityBindingBinding

class BindingActivity : AppCompatActivity() {

    lateinit var binding: ActivityBindingBinding
    private var name : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBindingBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.btnShowName.setOnClickListener {
            name = binding.txtAppName.text.toString()
            Log.d("TAG", "Name ki value: $name")
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume: ")
        name = ""
        binding.txtAppName.setText(name)
    }
}
