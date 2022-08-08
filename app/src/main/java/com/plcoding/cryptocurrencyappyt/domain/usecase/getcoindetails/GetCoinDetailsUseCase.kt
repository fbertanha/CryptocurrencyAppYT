package com.plcoding.cryptocurrencyappyt.domain.usecase.getcoindetails

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetails
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by felipebertanha on 08/August/2022
 */
class GetCoinDetailsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> =
        repository.getCoinDetails(coinId)
}