package com.rtech.studyapplication.apimodule.model.data

data class WeatherAirQualityIndex(
    val coord: Coord,
    val list: List<_List>
)

data class Main(
    val aqi: Int
)

data class Coord(
    val lat: Int,
    val lon: Int
)

data class Components(
    val co: Double,
    val nh3: Double,
    val no: Int,
    val no2: Double,
    val o3: Double,
    val pm10: Double,
    val pm2_5: Double,
    val so2: Double
)

data class _List(
    val components: Components,
    val dt: Int,
    val main: Main
)