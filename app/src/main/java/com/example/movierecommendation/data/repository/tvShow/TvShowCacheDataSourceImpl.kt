package com.example.movierecommendation.data.repository.tvShow

import com.example.movierecommendation.data.model.movie.Movie
import com.example.movierecommendation.data.model.tvshow.TvShow
import com.example.movierecommendation.data.repository.movie.datasource.MovieCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {

    private var tvShowList=ArrayList<TvShow>()


    override suspend fun getTvShowsFomCache(): List<TvShow> {
        return tvShowList
    }


    override suspend fun saveTvShowsToCache(tvShowS: List<TvShow>) {
        tvShowList.clear()
        tvShowList=ArrayList(tvShowS)
    }
}