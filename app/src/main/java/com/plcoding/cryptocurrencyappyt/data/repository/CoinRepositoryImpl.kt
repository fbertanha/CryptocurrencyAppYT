package com.plcoding.cryptocurrencyappyt.data.repository

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.CoinPapikraApi
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoinDetail
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetails
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Created by felipebertanha on 08/August/2022
 */
class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPapikraApi
) : CoinRepository {

    override fun getCoins(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading)
            val coins = api.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.localizedMessage
                        ?: "Couldn't reach the server. Check your internet connection."
                )
            )
        }
    }

    override fun getCoinDetails(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading)
            val coinDetail = api.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coinDetail))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.localizedMessage
                        ?: "Couldn't reach the server. Check your internet connection."
                )
            )
        }
    }
}