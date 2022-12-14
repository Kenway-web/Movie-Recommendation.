package com.example.movierecommendation.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.movierecommendation.R
import com.example.movierecommendation.databinding.ActivityHomeBinding
import com.example.movierecommendation.presentation.artist.ArtistActivity
import com.example.movierecommendation.presentation.movie.MovieActivity
import com.example.movierecommendation.presentation.tv.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_home)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_home)
        binding.movieButton.setOnClickListener{
            val intent= Intent(this,MovieActivity::class.java)
            startActivity(intent)
        }
        binding.tvButton.setOnClickListener{
            val intent= Intent(this,TvShowActivity::class.java)
            startActivity(intent)
        }
        binding.artistsButton.setOnClickListener{
            val intent= Intent(this,ArtistActivity::class.java)
            startActivity(intent)
        }
    }
}