package com.example.movierecommendation.data.repository.movie.datasourceImpl

import android.util.Log
import com.example.movierecommendation.data.model.movie.Movie
import com.example.movierecommendation.data.repository.movie.datasource.MovieCacheDataSource
import com.example.movierecommendation.data.repository.movie.datasource.MovieLocalDatasource
import com.example.movierecommendation.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.movierecommendation.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDatasource: MovieLocalDatasource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
       return getMoviesFromCache()
    }

    override suspend fun updateMovie(): List<Movie>? {
        // get data from api
        // clear from db and local cache
        val newListOfMovies=getMoviesFromAPI()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return  newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        // getting api inside try block
        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())

        }

        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        // getting api inside try block
        try {
            movieList = movieLocalDatasource.getMoviesFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.size > 0) {
            return movieList
        } else {
            // if db empty fetch from api
            movieList = getMoviesFromAPI()
            movieLocalDatasource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {

        lateinit var movieList: List<Movie>

        // getting api inside try block
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.size > 0) {
            return movieList
        } else {
            // if db empty fetch from api
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

}