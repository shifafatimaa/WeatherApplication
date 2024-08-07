package com.example.weatherapp


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private val weatherApi = RetrofitHelper.retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val cityName=findViewById<EditText>(R.id.cityNameEditText)

        button.setOnClickListener{
            lifecycleScope.launch(Dispatchers.IO) {
                try {
                    val response = weatherApi.getWeather("Karachi", "907d232eaa93fcce054f3599021123df")

                    withContext(Dispatchers.Main) {
                        if(response.isSuccessful) {
                            val weatherResponse = response.body()!!
                            val intent = Intent(this@MainActivity, WeatherItemActivity::class.java)
                            intent.putExtra("weatherData", weatherResponse)
                            startActivity(intent)

                        }
                    }
                } catch (e: IOException) {
                    Toast.makeText(applicationContext, "Network error: ${e.message}", Toast.LENGTH_SHORT).show()
                } catch (e: HttpException) {
                    Toast.makeText(applicationContext, "HTTP error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }



//        val conditionTextView = findViewById<TextView>(R.id.weatherCondition)
//        val cityNameTextView = findViewById<TextView>(R.id.cityName)
//        val feelsLikeTextView = findViewById<TextView>(R.id.feelsLike)
//        val grndLevelTextView = findViewById<TextView>(R.id.grndLevel)
//        val humidityTextView = findViewById<TextView>(R.id.humidity)
//        val seaLevelTextView = findViewById<TextView>(R.id.seaLevel)
//        val tempTextView = findViewById<TextView>(R.id.temp)
//        val tempMaxTextView = findViewById<TextView>(R.id.tempMax)
//        val tempMinTextView = findViewById<TextView>(R.id.tempMin)
//        val imageView=findViewById<ImageView>(R.id.imageView)
//        val sunset=findViewById<TextView>(R.id.sunset)
//        val sunrise=findViewById<TextView>(R.id.sunrise)
//
//        button.setOnClickListener {
//            lifecycleScope.launch(Dispatchers.IO) {
//                try {
//                    val response = weatherApi.getWeather("Karachi", "907d232eaa93fcce054f3599021123df")
//
//                    withContext(Dispatchers.Main) {
//                        if(response.isSuccessful) {
//                            val weatherResponse = response.body()!!
//                            conditionTextView.text =
//                                "Weather Description: ${weatherResponse.list[0].weather[0].description}"
//                            cityNameTextView.text = "City: ${weatherResponse.city.name}"
//                            feelsLikeTextView.text =
//                                "Feels Like: ${weatherResponse.list[0].main.feels_like.toInt()}"
//                            grndLevelTextView.text =
//                                "Ground Level: ${weatherResponse.list[0].main.grnd_level}"
//                            seaLevelTextView.text = "Sea Level: ${weatherResponse.list[0].main.sea_level}"
//                            humidityTextView.text = "Humidity: ${weatherResponse.list[0].main.humidity}%"
//                            tempTextView.text = "Temperature: ${weatherResponse.list[0].main.temp.toInt()}°C"
//                            tempMaxTextView.text =
//                                "Max Temperature: ${weatherResponse.list[0].main.temp_max.toInt()}°C"
//                            tempMinTextView.text =
//                                "Min Temperature: ${weatherResponse.list[0].main.temp_min.toInt()}°C"
//                            val iconId = weatherResponse.list[0].weather[0].icon
//
//                            val imgUrl = "https://openweathermap.org/img/wn/$iconId@4x.png"
//                            Picasso.get().load(imgUrl).into(imageView)
//
//                            sunset.text="Sunset: ${SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(weatherResponse.city.sunset * 1000) }"
//                            sunrise.text="Sunrise: ${SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(weatherResponse.city.sunrise * 1000)}"
//                        }
//                    }
//                } catch (e: IOException) {
//                    Toast.makeText(applicationContext, "Network error: ${e.message}", Toast.LENGTH_SHORT).show()
//                } catch (e: HttpException) {
//                    Toast.makeText(applicationContext, "HTTP error: ${e.message}", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
   }
}
