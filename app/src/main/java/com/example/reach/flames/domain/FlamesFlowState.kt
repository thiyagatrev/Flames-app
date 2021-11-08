package com.example.reach.flames.domain

sealed class FlamesFlowState {
    object Empty : FlamesFlowState()
    object Loading : FlamesFlowState()
    class Error(val errorMessage: String) : FlamesFlowState()
    class Success(val result: String?) : FlamesFlowState()
}
