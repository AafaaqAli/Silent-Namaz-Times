package com.aafaq.core.data

import com.aafaq.network.data.models.GeneralResponse

sealed class UIState{
    data class NoInternet(var networkError: String) : UIState()
    data class LoadingError(var errorMessage: String) : UIState()
    data class Success(var response: GeneralResponse?): UIState()

    object Loading : UIState()
    object LoadSuccess: UIState()
    object Empty : UIState()
}