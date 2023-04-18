package com.aafaq.core.data.models

import com.aafaq.network.data.models.GeneralResponse

sealed class UIState{
    object Empty : UIState()
    object Loading : UIState()
    data class Error(var errorMessage: String?) : UIState()
    data class Success(var response: GeneralResponse?): UIState()
}