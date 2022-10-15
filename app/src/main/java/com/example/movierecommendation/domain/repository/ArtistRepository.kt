package com.example.movierecommendation.domain.repository

import com.example.movierecommendation.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist():List<Artist>
    suspend fun updateArtist():List<Artist>
}