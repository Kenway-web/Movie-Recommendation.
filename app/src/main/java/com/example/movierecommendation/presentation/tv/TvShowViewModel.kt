package com.example.movierecommendation.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movierecommendation.domain.usecase.GetMoviesUseCase
import com.example.movierecommendation.domain.usecase.GetTvShowUseCase
import com.example.movierecommendation.domain.usecase.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase:UpdateTvShowUseCase
):ViewModel() {

    fun getTvShows()= liveData{
        val tvShowlist=getTvShowUseCase.execute()
        emit(tvShowlist)
    }
    fun updateTvShows()= liveData {
        val tvShowlist=updateTvShowUseCase.execute()
        emit(tvShowlist)
    }

}