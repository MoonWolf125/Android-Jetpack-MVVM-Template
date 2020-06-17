package com.moonwolf125.android.templates.mvvm.data

/**
 * A sealed class that represents a hierarchical relation corresponding to a network result
 *
 * @param <D, E>
 * @author MoonWolf125
 */
sealed class Result<out D : Any, out E : Any?> {

    /**
     * A data class that represents a network result that resulted in a success
     *
     * @param data - The data returned by the network result
     * @author MoonWolf125
     */
    data class Success<out D : Any>(val data: D) : Result<D, Nothing>()

    /**
     * A data class that represents a network result that resulted in an error
     *
     * @param error - The error returned by the network result
     * @author MoonWolf125
     */
    data class Error<out E : Any>(val error: E?) : Result<Nothing, E>()

    /**
     * A data class that represents a network result that resulted in an exception
     *
     * @param exception - The exception returned by the network result
     * @author MoonWolf125
     */
    data class Exception(val exception: java.lang.Exception) : Result<Nothing, Nothing>()

    /**
     * Returns a string representation of the object
     *
     * @author MoonWolf125
     */
    override fun toString(): String {
        return when (this) {
            is Success -> "Success(data=$data)"
            is Error -> "Error(error=$error)"
            is Exception -> "Exception(exception=$exception)"
        }
    }
}
