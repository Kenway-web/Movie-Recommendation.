package com.example.movierecommendation.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movierecommendation.domain.usecase.GetMoviesUseCase
import com.example.movierecommendation.domain.usecase.UpdateMoviesUsecase

class MovieViewModel(
    private val getMoviesUseCase:GetMoviesUseCase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
):ViewModel() {


    fun getMovies()=liveData{
        val movieList=getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies()= liveData {
        // here clear all data in movie data
        // download new data and save in db

        val movieList=updateMoviesUsecase.execute()
        emit(movieList)
    }

}