package com.BELLE.formation.tpmovieapi.presentation.search

import com.BELLE.formation.tpmovieapi.domain.model.MovieShort

// entre enum et class abstraite (sealed), classe qui doit etre étendue avec d'autres classes, dans le fragment on va regarder l'etat de la searchstate
sealed class SearchState {
    class SuccessState(val movies: List<MovieShort>) : SearchState()

    //object = classe sans paramètres (contrairement à celle au dessu)
    object ErrorState : SearchState()

    object LoginState : SearchState()

    object LoadingState : SearchState()
}