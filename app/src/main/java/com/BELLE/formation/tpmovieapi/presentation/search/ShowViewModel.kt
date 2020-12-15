package com.BELLE.formation.tpmovieapi.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BELLE.formation.tpmovieapi.data.repository.OmdbRepository
import com.BELLE.formation.tpmovieapi.domain.repository.SearchRepository
import com.BELLE.formation.tpmovieapi.domain.repository.ShowRepository
import kotlinx.coroutines.launch

class ShowViewModel : ViewModel() {
    private val repository: ShowRepository = OmdbRepository()

    //mutable = modifiable
    private val _state = MutableLiveData<SearchState>()

    //celui ci ne peux pas être modifié, uniquement la lecture, en kotlin pas besoin de getteurs et setteurs, il suffit de faire comme ça (en non mutable)
    val state: LiveData<ShowState> get() = _state

    fun showMovie(text: String) {
        _state.value = ShowState.LoadingState

        viewModelScope.launch {
            try {
                _state.value = ShowState.SuccessState(repository.getMovieDetail(text))

            } catch (e: Exception) {
                _state.value = ShowState.ErrorState
            }
        }
    }
}