package com.BELLE.formation.tpmovieapi.presentation.search

import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BELLE.formation.tpmovieapi.data.mock.MockSearchRepository
import com.BELLE.formation.tpmovieapi.domain.repository.SearchRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class SearchViewModel : ViewModel() {
    private val repository: SearchRepository = MockSearchRepository()

    //mutable = modifiable
    private val _state = MutableLiveData<SearchState>()
    //celui ci ne peux pas être modifié, uniquement la lecture, en kotlin pas besoin de getteurs et setteurs, il suffit de faire comme ça (en non mutable)
    val state : LiveData<SearchState> get() = _state

    fun searchMovie(text: String) {
        _state.value = SearchState.LoadingState

        viewModelScope.launch {
            try {
                _state.value = SearchState.SuccessState(repository.searchMovie(text))

            } catch (e: Exception) {
                _state.value = SearchState.ErrorState
            }
        }
    }
}