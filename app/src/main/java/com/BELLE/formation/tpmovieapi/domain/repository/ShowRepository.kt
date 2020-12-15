package com.BELLE.formation.tpmovieapi.domain.repository

import com.BELLE.formation.tpmovieapi.domain.model.MovieDetail

interface ShowRepository {
    //suspend sous entend que le coe utilise co routines (async)
    suspend fun getMovieDetail(id: String): List<MovieDetail>

}