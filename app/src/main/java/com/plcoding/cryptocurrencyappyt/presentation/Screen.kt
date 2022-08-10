package com.plcoding.cryptocurrencyappyt.presentation

/**
 * Created by felipebertanha on 08/August/2022
 */
sealed class Screen(val route: String) {
    object CoinListScreen : Screen("coinListScreen")
    class CoinDetailScreen(coinId: String = "{$PARAM_COIN_ID}") : Screen("coinDetailScreen/$coinId") {
        companion object {
            const val PARAM_COIN_ID = "coinId"
        }
    }
}
