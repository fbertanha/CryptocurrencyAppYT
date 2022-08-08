package com.plcoding.cryptocurrencyappyt.presentation.coindetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.usecase.getcoindetails.GetCoinDetailsUseCase
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by felipebertanha on 08/August/2022
 */
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetails: GetCoinDetailsUseCase,
    savedStateHandle: SavedStateHandle
) {

    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getDetails(coinId)
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
        }
    }

    companion object {
        const val PARAM_COIN_ID = "coinId"
    }

}