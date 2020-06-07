package com.t.bloghub0.data

sealed class SResult<out T : Any> {

        data class Success<out T : Any>(val data: T) : SResult<T>()
        data class Error(val exception: Exception) : SResult<Nothing>()

        override fun toString(): String {
            return when (this) {
                is Success<*>-> "Success[data=$data]"
                is Error -> "Error[exception=$exception]"
            }
        }
    }

