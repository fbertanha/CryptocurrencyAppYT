package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetails
import kotlinx.coroutines.flow.Flow

/**
 * Created by felipebertanha on 08/August/2022
 */
interface CoinRepository {

    fun getCoins(): Flow<Resource<List<Coin>>>

    fun getCoinDetails(coinId: String): Flow<Resource<CoinDetails>>
}