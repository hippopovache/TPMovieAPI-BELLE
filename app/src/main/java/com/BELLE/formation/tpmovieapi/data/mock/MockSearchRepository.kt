package com.BELLE.formation.tpmovieapi.data.mock

import com.BELLE.formation.tpmovieapi.domain.model.MovieShort
import com.BELLE.formation.tpmovieapi.domain.repository.SearchRepository

class MockSearchRepository : SearchRepository {
    //vu qu'on override, il faut utiliser le suspend comme dans la fonction de base
    override suspend fun searchMovie(search: String): List<MovieShort> {
        return listOf(
            MovieShort("1", "Le lama", "https://cdn.futura-sciences.com/buildsv6/images/largeoriginal/3/9/9/399584ebc7_50163211_lama-coronavirus.jpg"),
            MovieShort("2", "Titre 2", "https://cdn.futura-sciences.com/buildsv6/images/largeoriginal/3/9/9/399584ebc7_50163211_lama-coronavirus.jpg"),
            MovieShort("3", "Titre 3", "https://cdn.futura-sciences.com/buildsv6/images/largeoriginal/3/9/9/399584ebc7_50163211_lama-coronavirus.jpg"),
            MovieShort("4", "Titre 4", "https://cdn.futura-sciences.com/buildsv6/images/largeoriginal/3/9/9/399584ebc7_50163211_lama-coronavirus.jpg")
        )
    }
}