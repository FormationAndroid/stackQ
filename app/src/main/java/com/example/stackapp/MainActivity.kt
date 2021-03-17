package com.example.stackapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.stackapp.models.LastQuestions
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val adapter = QuestionsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = adapter
        updateData()

        btnRefresh.setOnClickListener {
            updateData()
        }

    }


    private fun updateData(){

        retrofitClient.getLastQuestions().enqueue(object: retrofit2.Callback<LastQuestions>{

            override fun onResponse(call: Call<LastQuestions>, response: Response<LastQuestions>) {
                if (response.isSuccessful){
                    response.body()?.items?.let {
                        adapter.refreshData(it)
                    }
                }
            }

            override fun onFailure(call: Call<LastQuestions>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}