package com.BELLE.formation.tpmovieapi.domain.repository

import com.BELLE.formation.tpmovieapi.domain.model.MovieShort

interface SearchRepository {
    //suspend sous entend que le coe utilise co routines (async)
    suspend fun searchMovie(search: String): List<MovieShort>
}