package com.example.movierecommendation.domain.usecase

import com.example.movierecommendation.data.model.artist.Artist
import com.example.movierecommendation.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>?=artistRepository.updateArtist()
}