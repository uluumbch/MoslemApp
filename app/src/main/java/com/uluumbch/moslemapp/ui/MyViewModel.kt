package com.uluumbch.moslemapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uluumbch.moslemapp.network.AsmaulHusna
import com.uluumbch.moslemapp.network.DoaHarian
import com.uluumbch.moslemapp.network.MoslemAppApi
import kotlinx.coroutines.launch
import java.lang.Exception

class MyViewModel : ViewModel() {
    // penampung data untuk API doa
    private val _listdoaharian = MutableLiveData<DoaHarian>()
    val listdoaharian: LiveData<DoaHarian> = _listdoaharian

    private val _doahariantunggal = MutableLiveData<DoaHarian.Data>()
    val doahariantunggal: LiveData<DoaHarian.Data> = _doahariantunggal

    // penampung data untuk API asmaul husna
    private val _listasmaulhusna = MutableLiveData<AsmaulHusna>()
    val listasmaulhusna: LiveData<AsmaulHusna> = _listasmaulhusna

    private val _asmaulHusnaTunggal = MutableLiveData<AsmaulHusna.Data>()
    val asmaulHusnaTunggal: LiveData<AsmaulHusna.Data> = _asmaulHusnaTunggal




    fun getDoaList() {
        viewModelScope.launch {
            try {
                _listdoaharian.value = MoslemAppApi.retrofitServiceApi.getDoa()
            } catch (e: Exception) {
                Log.d("error", e.printStackTrace().toString())
                _listdoaharian.value = DoaHarian(listOf())
            }
        }
    }

    fun getAsmaulHusnaList(){
        viewModelScope.launch {
            try {
                _listasmaulhusna.value = MoslemAppApi.retrofitServiceApi.getAsmaulHusna()
            } catch (e: Exception) {
                Log.d("error", e.printStackTrace().toString())
                _listasmaulhusna.value = AsmaulHusna(listOf())
            }
        }
    }

    fun onDoaHarianCLicked(doa: DoaHarian.Data){
        _doahariantunggal.value = doa
    }
}