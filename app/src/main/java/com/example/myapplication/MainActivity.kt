package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(NetworkApi::class.java)
        api.getData().enqueue(object : Callback<List<JsonData>>{
            override fun onFailure(call: Call<List<JsonData>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Fail", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<List<JsonData>>,
                response: Response<List<JsonData>>
            ) {
                recycleView.adapter = response.body()?.let { CustomAdapter(it) }
                recycleView.layoutManager = GridLayoutManager(this@MainActivity, 1)

            }

        })
    }
}
