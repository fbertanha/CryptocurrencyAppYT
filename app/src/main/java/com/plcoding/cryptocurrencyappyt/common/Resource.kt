package com.plcoding.cryptocurrencyappyt.common

/**
 * Created by felipebertanha on 06/August/2022
 */

sealed class Resource<out T : Any>(val data: T? = null, val message: String? = null) {
    class Success<T : Any>(data: T) : Resource<T>(data)
    class Error(message: String) : Resource<Nothing>(null, message)
    object Loading : Resource<Nothing>(null, null)
}