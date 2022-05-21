package com.uluumbch.moslemapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val BASE_URL = "https://islamic-api-zhirrr.vercel.app/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DoaHarianServiceApi {
    @GET("doaharian")
    suspend fun getDoa(): DoaHarian

    @GET("asmaulhusna")
    suspend fun getAsmaulHusna(): AsmaulHusna
}

object DoaHarianApi {
    val retrofitServiceApi: DoaHarianServiceApi by lazy {
        retrofit.create(DoaHarianServiceApi::class.java)
    }
}