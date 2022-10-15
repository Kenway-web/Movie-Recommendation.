package com.example.movierecommendation.domain.usecase

import com.example.movierecommendation.data.model.artist.Artist
import com.example.movierecommendation.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>?=artistRepository.getArtist()

}