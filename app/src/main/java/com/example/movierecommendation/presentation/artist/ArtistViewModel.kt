package com.example.movierecommendation.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movierecommendation.domain.usecase.GetArtistsUseCase
import com.example.movierecommendation.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val  getArtistsUseCase: GetArtistsUseCase,
    private val getUpdateArtistsUseCase: UpdateArtistsUseCase
):ViewModel() {

    fun getArtist()= liveData{
        val artistList=getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateMovies()= liveData {
        val artistList=getUpdateArtistsUseCase.execute()
        emit(artistList)
    }

}