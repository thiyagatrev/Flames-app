package com.example.reach.flames.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.reach.flames.usecase.FindFlamesUseCase
import com.example.reach.flames.usecase.FindFlamesUseCaseImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class FlamesViewModel(application: Application) : AndroidViewModel(application) {

    private val findFlamesUseCase: FindFlamesUseCase = FindFlamesUseCaseImpl()

    private val _postFlamesStateFlow = MutableStateFlow<FlamesFlowState>(FlamesFlowState.Empty)

    val flamesFlowState get() = _postFlamesStateFlow

    private var _mutableErrordata = MutableLiveData<String>()
    val errorData get() = _mutableErrordata

    private var _successData = MutableLiveData<String>()
    val successData get() = _successData

    private suspend fun postFlamesState(state: FlamesFlowState) {
        _postFlamesStateFlow.emit(state)
    }

    fun initFlames(userName1: String?, username2: String?) {

        viewModelScope.launch {
            postFlamesState(FlamesFlowState.Empty)
            if (userName1.isNullOrEmpty()) {
                _mutableErrordata.postValue("Your Name is empty")
                return@launch postFlamesState(FlamesFlowState.Error("Your Name is empty"))
            } else if (username2.isNullOrEmpty()) {
                _mutableErrordata.postValue("Partner Name is empty")
                return@launch postFlamesState(FlamesFlowState.Error("Partner Name is empty"))
            }
            val result = findFlamesUseCase.execute(userName1, username2)

            _successData.postValue(result)

            return@launch postFlamesState(FlamesFlowState.Success(result))
        }

    }

    companion object {
        private const val TAG = "FlamesViewModel"
    }
}