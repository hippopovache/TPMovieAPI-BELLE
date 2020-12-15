package com.BELLE.formation.tpmovieapi.domain.model

data class MovieDetail(
    val id: String,
    val title: String,
    val poster: String,
    val description: String,
    val metascore: String,
    val director: String,
    val actors: String
)
