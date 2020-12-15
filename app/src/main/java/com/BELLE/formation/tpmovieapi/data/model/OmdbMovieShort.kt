package com.BELLE.formation.tpmovieapi.data.model

import com.google.gson.annotations.SerializedName

data class OmdbMovieShort(
    @SerializedName("Title")
    val title: String,
    @SerializedName("Year")
    val year: String,
    @SerializedName("imdbID")
    val imdbId: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Poster")
    val poster: String,
)
