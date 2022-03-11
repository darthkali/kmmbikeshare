package de.darthkali.kmm_bike_share.domain.util

data class DataState<T>(
    val error: String = "",
    val data: T? = null,
    val isLoading: Boolean = false,
) {

    companion object {

        fun <T> error(
            message: String,
        ): DataState<T> {
            return DataState(
                error = message,
            )
        }

        fun <T> data(
            data: T? = null,
        ): DataState<T> {
            return DataState(
                data = data,
            )
        }

        fun <T> loading() = DataState<T>(isLoading = true)
    }
}
