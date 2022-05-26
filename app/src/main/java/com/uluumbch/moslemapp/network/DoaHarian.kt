package com.uluumbch.moslemapp.network


data class DoaHarian(
    val data: List<Data>
) {
    data class Data(
        val arabic: String,
        val latin: String,
        val title: String,
        val translation: String
    )
}
