package com.uluumbch.moslemapp.network


import com.squareup.moshi.Json

data class AsmaulHusna(
    val `data`: List<Data>
) {
    data class Data(
        val arabic: String,
        val index: String,
        val latin: String,
        @Json(name = "translation_en")
        val translationEn: String,
        @Json(name = "translation_id")
        val translationId: String
    )
}