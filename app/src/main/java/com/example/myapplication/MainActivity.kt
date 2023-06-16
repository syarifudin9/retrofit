package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rick = findViewById<RecyclerView>(R.id.rv_character)

        Apiconfig.getService().getRick().enqueue(object : Callback<ResponseRick>{
            override fun onResponse(Call :Call<ResponseRick>,response: Response<ResponseRick>){
                if(response.isSuccessful){
                    val ResponseRick=response.body()
                    val dataRick =ResponseRick?.results
                    val rickAdapter=RickAdapter(dataRick as List<ResultsItem>)
                    rick.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        rickAdapter.notifyDataSetChanged()
                        adapter=rickAdapter
                    }
                }
            }
            override fun onFailure(call: Call<ResponseRick>, t: Throwable){
                Toast.makeText(applicationContext, t.localizedMessage,Toast.LENGTH_SHORT).show()
            }
        })
    }
}