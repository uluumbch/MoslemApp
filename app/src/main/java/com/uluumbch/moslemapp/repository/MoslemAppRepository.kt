package com.uluumbch.moslemapp.repository
import com.uluumbch.moslemapp.network.AsmaulHusna
import com.uluumbch.moslemapp.network.DoaHarian
import com.uluumbch.moslemapp.network.MoslemAppApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoslemAppRepository (){


    suspend fun getDoa(): DoaHarian{
            return MoslemAppApi.retrofitServiceApi.getDoa()
    }

    suspend fun getAsmaulHusna(): AsmaulHusna{
        return MoslemAppApi.retrofitServiceApi.getAsmaulHusna()
    }
}