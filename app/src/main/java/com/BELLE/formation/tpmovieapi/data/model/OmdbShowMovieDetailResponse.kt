package com.BELLE.formation.tpmovieapi.data.model

import com.google.gson.annotations.SerializedName

data class OmdbShowMovieDetailResponse(
    @SerializedName("Search")
    val movies: List<OmdbMovieDetail>,
    @SerializedName("totalResults")
    val resultNumber: Int
)
