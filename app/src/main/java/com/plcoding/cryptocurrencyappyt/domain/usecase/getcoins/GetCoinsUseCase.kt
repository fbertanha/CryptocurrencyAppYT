package com.plcoding.cryptocurrencyappyt.domain.usecase.getcoins

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by felipebertanha on 08/August/2022
 */
class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = repository.getCoins()
}