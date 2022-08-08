package com.plcoding.cryptocurrencyappyt.domain.model

/**
 * Created by felipebertanha on 08/August/2022
 */
data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)
