package com.example.movierecommendation.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movierecommendation.domain.usecase.GetArtistsUseCase
import com.example.movierecommendation.domain.usecase.UpdateArtistsUseCase
import com.example.movierecommendation.presentation.movie.MovieViewModel


class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val getUpdateArtistsUseCase: UpdateArtistsUseCase
):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase,getUpdateArtistsUseCase) as T
    }

}