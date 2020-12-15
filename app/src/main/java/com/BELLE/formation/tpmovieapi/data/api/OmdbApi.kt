package com.BELLE.formation.tpmovieapi.data.api

import com.BELLE.formation.tpmovieapi.data.model.OmdbSearchResponse
import com.BELLE.formation.tpmovieapi.data.model.OmdbShowMovieDetailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbApi {

    companion object {
        //constantes
        const val BASE_URL = "https://www.omdbapi.com"
        const val API_KEY = "c8f8a70e"
    }

    //s (search) et apikey sont les valeurs a filer a l'api (définis par la doc)
    @GET("/")
    suspend fun searchMovie(
        @Query("s") title: String,
        @Query("apikey") apiKey: String
    ): OmdbSearchResponse

    @GET("/")
    suspend fun showMovie(
        @Query("i") id: String,
        @Query("apikey") apiKey: String
    ): OmdbShowMovieDetailResponse
}