package com.plcoding.cryptocurrencyappyt.presentation.coindetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.usecase.getcoindetails.GetCoinDetailsUseCase
import com.plcoding.cryptocurrencyappyt.presentation.Screen.CoinDetailScreen.Companion.PARAM_COIN_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by felipebertanha on 08/August/2022
 */
@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetails: GetCoinDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getDetails(coinId)
        } ?: run {
            _state.value = CoinDetailsState(error = "Invalid coin id.")
        }
    }

    private fun getDetails(coinId: String) {
        getCoinDetails(coinId).onEach { result ->
            when (result) {
                Resource.Loading -> {
                    _state.value = CoinDetailsState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinDetailsState(coinDetails = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        CoinDetailsState(error = result.message ?: "An unknown error occurred.")
                }
            }
        }.launchIn(viewModelScope)
    }
}