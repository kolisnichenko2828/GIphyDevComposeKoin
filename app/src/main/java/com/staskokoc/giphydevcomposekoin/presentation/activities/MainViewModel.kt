package com.staskokoc.giphydevcomposekoin.presentation.activities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.staskokoc.giphydevcomposekoin.domain.models.Gifs
import com.staskokoc.giphydevcomposekoin.domain.usecases.GetGifsUsecase
import kotlinx.coroutines.launch

class MainViewModel(private val getGifsUsecase: GetGifsUsecase) : ViewModel() {
    val gifsLiveData = MutableLiveData<Gifs>()

    fun getGifs(q: String) {
        viewModelScope.launch {
            gifsLiveData.value = getGifsUsecase.execute(q)
        }
    }
}