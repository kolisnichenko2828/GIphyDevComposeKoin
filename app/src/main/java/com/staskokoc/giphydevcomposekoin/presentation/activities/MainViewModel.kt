package com.staskokoc.giphydevcomposekoin.presentation.activities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.staskokoc.giphydevcomposekoin.domain.models.Gifs
import com.staskokoc.giphydevcomposekoin.domain.usecases.GetGifsUsecase
import kotlinx.coroutines.launch

class MainViewModel(private val getGifsUsecase: GetGifsUsecase) : ViewModel() {
    val liveDataGifs = MutableLiveData<Gifs>()

    fun getGifs(q: String) {
        viewModelScope.launch {
            liveDataGifs.value = getGifsUsecase.execute(q)
        }
    }
}