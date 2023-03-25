package com.aafaq.salatapp.presentation.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aafaq.core.data.models.UIState
import com.aafaq.network.data.models.GeneralResponse
import com.aafaq.network.data.models.salah.Location
import com.aafaq.network.data.models.salah.Methods
import com.aafaq.network.domain.repository.SalahTimeNetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import okhttp3.internal.http.hasBody
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val networkRepository: SalahTimeNetworkRepository
): ViewModel() {

    /**
     * TODO take everything to shared view model
     *      from there call the APIs and handle data flow e.g will the data
     *      flow {network -> db -> App] or {db -> App]
     * */


    /**
     * Handle everything through state management
     * */
    private val _state = MutableStateFlow<UIState>(UIState.Empty)
    val homeStateFlow: SharedFlow<UIState> = _state

    fun getCalender(
        year: Int,
        month: Int?,
        location: Location,
        method: Methods,
    ) {
        viewModelScope.launch {
            /**
             * Set initial State to Loading
             * */
            _state.value = UIState.Loading
            networkRepository.getCalendar(year, month, location, method).apply {
                this.collectLatest {
                    if (it.code == 200) {
                        _state.value = UIState.Success(
                            GeneralResponse(
                                it.code, it.status, it.data
                            )
                        )
                    } else {
                        _state.value = UIState.Error(it.status)
                    }
                }
            }
        }
    }
}