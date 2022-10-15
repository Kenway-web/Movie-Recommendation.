package com.example.movierecommendation.domain.usecase

import com.example.movierecommendation.data.model.tvshow.TvShow
import com.example.movierecommendation.domain.repository.TvShowRepository

class UpdateTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}