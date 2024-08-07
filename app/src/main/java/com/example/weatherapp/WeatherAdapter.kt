package com.example.weatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.model.DT

class WeatherAdapter(private val weatherList: List<DT>) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_weather_item, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weather = weatherList[position]
        holder.bind(weather)
    }

    override fun getItemCount(): Int = weatherList.size

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val weatherConditionTextView: TextView = itemView.findViewById(R.id.weatherCondition)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val sunriseTextView: TextView = itemView.findViewById(R.id.sunrise)
        private val sunsetTextView: TextView = itemView.findViewById(R.id.sunset)
        private val cityNameTextView: TextView = itemView.findViewById(R.id.cityName)
        private val feelsLikeTextView: TextView = itemView.findViewById(R.id.feelsLike)
        private val grndLevelTextView: TextView = itemView.findViewById(R.id.grndLevel)
        private val humidityTextView: TextView = itemView.findViewById(R.id.humidity)
        private val seaLevelTextView: TextView = itemView.findViewById(R.id.seaLevel)
        private val tempTextView: TextView = itemView.findViewById(R.id.temp)
        private val tempMaxTextView: TextView = itemView.findViewById(R.id.tempMax)
        private val tempMinTextView: TextView = itemView.findViewById(R.id.tempMin)

        fun bind(weather: DT) {
            val firstWeather = weather.weather.firstOrNull()
            weatherConditionTextView.text = firstWeather?.main
//            sunriseTextView.text = "Sunrise: ${weather.city.sunrise}"
//            sunsetTextView.text = "Sunset: ${weather.city.sunset}"
            cityNameTextView.text = "City: ${weather.dt_txt}"  // Assuming city name might be in dt_txt
            feelsLikeTextView.text = "Feels Like: ${weather.main.feels_like}"
            grndLevelTextView.text = "Ground Level: ${weather.main.grnd_level}"
            humidityTextView.text = "Humidity: ${weather.main.humidity}"
            seaLevelTextView.text = "Sea Level: ${weather.main.sea_level}"
            tempTextView.text = "Temperature: ${weather.main.temp}"
            tempMaxTextView.text = "Max Temperature: ${weather.main.temp_max}"
            tempMinTextView.text = "Min Temperature: ${weather.main.temp_min}"

            // Set image resource for the ImageView if you have icons for weather conditions
            // imageView.setImageResource(R.drawable.your_image)
        }
    }
}
