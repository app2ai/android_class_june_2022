package com.rtech.studyapplication.apimodule.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rtech.studyapplication.R
import com.rtech.studyapplication.apimodule.model.data.DummyData

class ApiDataAdapter(con: Context, list: DummyData) :
    RecyclerView.Adapter<ApiDataAdapter.ApiDataViewHolder>() {

    private var listOfData: DummyData = list
    private var context: Context = con

    inner class ApiDataViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var txtName: TextView? = null
        init {
            txtName = v.findViewById(R.id.txtApiName)
        }
    }

    override fun getItemCount(): Int {
        return listOfData.size
    }

    override fun onBindViewHolder(holder: ApiDataViewHolder, position: Int) {
        holder.txtName?.text = listOfData.get(position).name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiDataViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_api, parent, false)
        return ApiDataViewHolder(view)
    }
}