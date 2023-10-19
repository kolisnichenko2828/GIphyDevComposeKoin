package com.staskokoc.giphydevcomposekoin.presentation.activities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.staskokoc.giphydevcomposekoin.domain.models.Gifs
import com.staskokoc.giphydevcomposekoin.domain.usecases.GetLastSearchSharedPrefsUsecase
import com.staskokoc.giphydevcomposekoin.domain.usecases.SearchGifsUsecase
import com.staskokoc.giphydevcomposekoin.domain.usecases.GetTrendingGifsUsecase
import com.staskokoc.giphydevcomposekoin.domain.usecases.SaveLastSearchSharedPrefsUsecase
import kotlinx.coroutines.launch

class MainViewModel(
    private val searchGifsUsecase: SearchGifsUsecase,
    private val getTrendingGifsUsecase: GetTrendingGifsUsecase,
    private val getLastSearchSharedPrefsUsecase: GetLastSearchSharedPrefsUsecase,
    private val saveLastSearchSharedPrefsUsecase: SaveLastSearchSharedPrefsUsecase
) : ViewModel() {
    val gifsLiveData = MutableLiveData<Gifs>()
    val lastSearchLiveData = MutableLiveData<String>()

    fun getLastSearch() {
        viewModelScope.launch {
            lastSearchLiveData.value = getLastSearchSharedPrefsUsecase.execute()
        }
    }

    fun saveLastSearch(lastSearch: String) {
        viewModelScope.launch {
            saveLastSearchSharedPrefsUsecase.execute(lastSearch = lastSearch)
        }
    }

    fun getGifs(q: String) {
        viewModelScope.launch {
            gifsLiveData.value = searchGifsUsecase.execute(q)
        }
    }

    fun getTrendingGifs() {
        viewModelScope.launch {
            gifsLiveData.value = getTrendingGifsUsecase.execute()
        }
    }
}