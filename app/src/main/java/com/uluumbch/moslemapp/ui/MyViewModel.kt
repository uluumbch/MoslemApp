package com.uluumbch.moslemapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uluumbch.moslemapp.network.AsmaulHusna
import com.uluumbch.moslemapp.network.Data
import com.uluumbch.moslemapp.network.DoaHarian
import com.uluumbch.moslemapp.network.DoaHarianApi
import kotlinx.coroutines.launch
import java.lang.Exception

class MyViewModel : ViewModel() {
    private val _doaharian = MutableLiveData<DoaHarian?>()
    val doaharian: LiveData<DoaHarian?> = _doaharian

    private val _asmaulhusna = MutableLiveData<AsmaulHusna?>()
    val asmaulhusna: LiveData<AsmaulHusna?> = _asmaulhusna



    private val _doahariantunggal = MutableLiveData<Data>()
    val doahariantunggal: LiveData<Data> = _doahariantunggal


    fun getDoaList() {
        viewModelScope.launch {
            try {
                _doaharian.value = DoaHarianApi.retrofitServiceApi.getDoa()
                _asmaulhusna.value = DoaHarianApi.retrofitServiceApi.getAsmaulHusna()
            } catch (e: Exception) {
                _doaharian.value = null
            }
        }
    }
}