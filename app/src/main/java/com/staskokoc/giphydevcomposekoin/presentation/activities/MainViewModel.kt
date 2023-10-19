package com.staskokoc.giphydevcomposekoin.presentation.activities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.staskokoc.giphydevcomposekoin.domain.models.Gifs
import com.staskokoc.giphydevcomposekoin.domain.usecases.GetGifsUrlsSharedPrefsUsecase
import com.staskokoc.giphydevcomposekoin.domain.usecases.SearchGifsUsecase
import com.staskokoc.giphydevcomposekoin.domain.usecases.GetTrendingGifsUsecase
import com.staskokoc.giphydevcomposekoin.domain.usecases.SaveGifsUrlsSharedPrefsUsecase
import kotlinx.coroutines.launch

class MainViewModel(
    private val searchGifsUsecase: SearchGifsUsecase,
    private val getTrendingGifsUsecase: GetTrendingGifsUsecase,
    private val getGifsUrlsSharedPrefsUsecase: GetGifsUrlsSharedPrefsUsecase,
    private val saveGifsUrlsSharedPrefsUsecase: SaveGifsUrlsSharedPrefsUsecase
) : ViewModel() {
    val gifsLiveData = MutableLiveData<Gifs>()

    fun getLastGifsModel() {
        viewModelScope.launch {
            gifsLiveData.value = getGifsUrlsSharedPrefsUsecase.execute()
        }
    }

    fun saveLastGifsModel() {
        viewModelScope.launch {
            saveGifsUrlsSharedPrefsUsecase.execute(gifs = gifsLiveData.value)
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