package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.model.Example

class WeatherItemActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_item)

        // Find RecyclerView
        recyclerView = findViewById(R.id.recyclerView)

        // Set up RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Retrieve data from intent
        val weatherData = intent.getParcelableExtra<Example>("weatherData")

        if (weatherData != null) {
            // Set up adapter with the list of DT items
            val adapter = WeatherAdapter(weatherData.list)
            recyclerView.adapter = adapter
        }
    }
}
