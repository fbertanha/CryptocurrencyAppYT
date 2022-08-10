package com.plcoding.cryptocurrencyappyt.domain.model

/**
 * Created by felipebertanha on 08/August/2022
 */
data class CoinDetails(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)

data class TeamMember(
    val name: String,
    val position: String
)

