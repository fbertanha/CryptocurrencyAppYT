package com.plcoding.cryptocurrencyappyt.presentation.coindetails

import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coinDetails: CoinDetails? = null,
    val error: String = ""
)