package com.BELLE.formation.tpmovieapi.data.repository

import com.BELLE.formation.tpmovieapi.data.api.OmdbApi
import com.BELLE.formation.tpmovieapi.data.model.OmdbMovieDetail
import com.BELLE.formation.tpmovieapi.data.model.OmdbMovieShort
import com.BELLE.formation.tpmovieapi.domain.model.MovieDetail
import com.BELLE.formation.tpmovieapi.domain.model.MovieShort
import com.BELLE.formation.tpmovieapi.domain.repository.SearchRepository
import com.BELLE.formation.tpmovieapi.domain.repository.ShowRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OmdbRepository : SearchRepository, ShowRepository {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(OmdbApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(OmdbApi::class.java)

    override suspend fun searchMovie(search: String): List<MovieShort> {
        return api.searchMovie(search, OmdbApi.API_KEY).movies.map {
            //conversion de la liste des movies dans le model qu'attend le viewmodel
            it.toMovieShort()
        }
    }

    override suspend fun getMovieDetail(id: String): List<MovieDetail> {
        return api.showMovie(id, OmdbApi.API_KEY).movies.map {
            it.toMovieDetail()
        }
    }
}

//conversion de la liste des movies dans le model qu'attend le viewmodel
private fun OmdbMovieShort.toMovieShort() = MovieShort(this.imdbId, this.title, this.poster)

private fun OmdbMovieDetail.toMovieDetail() = MovieDetail(
    this.imdbId,
    this.title,
    this.poster,
    this.description,
    this.metascore,
    this.director,
    this.actors
)