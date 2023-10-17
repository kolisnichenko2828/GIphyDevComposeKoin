package com.staskokoc.giphydevcomposekoin.presentation.activities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.staskokoc.giphydevcomposekoin.domain.models.Gifs
import com.staskokoc.giphydevcomposekoin.domain.usecases.SearchGifsUsecase
import com.staskokoc.giphydevcomposekoin.domain.usecases.GetTrendingGifsUsecase
import kotlinx.coroutines.launch

class MainViewModel(
    private val searchGifsUsecase: SearchGifsUsecase,
    private val getTrendingGifsUsecase: GetTrendingGifsUsecase
) : ViewModel() {
    val gifsLiveData = MutableLiveData<Gifs>()

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