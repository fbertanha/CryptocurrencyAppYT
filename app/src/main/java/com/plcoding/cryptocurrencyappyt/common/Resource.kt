package com.plcoding.cryptocurrencyappyt.common

/**
 * Created by felipebertanha on 06/August/2022
 */

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error(message: String) : Resource<Unit>(null, message)
    class Loading : Resource<Unit>(null, null)
}