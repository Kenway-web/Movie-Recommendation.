package com.example.movierecommendation.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movierecommendation.domain.usecase.GetTvShowUseCase
import com.example.movierecommendation.domain.usecase.UpdateTvShowUseCase
import com.example.movierecommendation.presentation.movie.MovieViewModel

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase,updateTvShowUseCase) as T
    }

}