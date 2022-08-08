package com.plcoding.cryptocurrencyappyt.presentation.coinlist

import com.plcoding.cryptocurrencyappyt.domain.model.Coin

/**
 * Created by felipebertanha on 08/August/2022
 */
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)