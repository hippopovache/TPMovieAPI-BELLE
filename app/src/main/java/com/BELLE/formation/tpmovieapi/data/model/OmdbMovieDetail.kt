package com.BELLE.formation.tpmovieapi.data.model

import com.google.gson.annotations.SerializedName

data class OmdbMovieDetail(
    @SerializedName("Title")
    val title: String,
    @SerializedName("Actors")
    val actors: String,
    @SerializedName("imdbID")
    val imdbId: String,
    @SerializedName("Plot")
    val description: String,
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Metascore")
    val metascore: String,
    @SerializedName("Director")
    val director: String,
)
