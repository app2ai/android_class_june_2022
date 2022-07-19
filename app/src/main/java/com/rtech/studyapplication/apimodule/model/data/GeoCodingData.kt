package com.rtech.studyapplication.apimodule.model.data

class GeoCodingData : ArrayList<GeoCodingDataItem>()

data class GeoCodingDataItem(
    val country: String,
    val lat: Double,
    val local_names: LocalNames,
    val lon: Double,
    val name: String,
    val state: String
)

data class LocalNames(
    val ascii: String,
    val ca: String,
    val en: String,
    val feature_name: String
)