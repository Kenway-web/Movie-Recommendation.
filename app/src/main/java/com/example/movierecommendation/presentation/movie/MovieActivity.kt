package com.example.movierecommendation.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.movierecommendation.R
import com.example.movierecommendation.databinding.ActivityHomeBinding
import com.example.movierecommendation.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_movie)

    }
}