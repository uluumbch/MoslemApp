package com.uluumbch.moslemapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerFrameLayout
import com.uluumbch.moslemapp.network.AsmaulHusna
import com.uluumbch.moslemapp.network.DoaHarian
import com.uluumbch.moslemapp.network.MoslemAppApi
import com.uluumbch.moslemapp.repository.MoslemAppRepository
import kotlinx.coroutines.launch
import java.lang.Exception

enum class ApiStatus { LOADING, ERROR, DONE }

class MyViewModel : ViewModel() {
    // Repository
    private val MoslemAppRepository = MoslemAppRepository()

    // status
    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> = _status

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
            _status.value = ApiStatus.LOADING
            try {
                _listdoaharian.value = MoslemAppRepository.getDoa()
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                Log.d("error", e.printStackTrace().toString())
                _listdoaharian.value = DoaHarian(listOf())
                _status.value = ApiStatus.ERROR
            }
        }
    }

    fun getAsmaulHusnaList(){
        viewModelScope.launch {
            try {
                _listasmaulhusna.value = MoslemAppRepository.getAsmaulHusna()
            } catch (e: Exception) {
                Log.d("error", e.printStackTrace().toString())
                _listasmaulhusna.value = AsmaulHusna(listOf())
            }
        }
    }

    fun onDoaHarianCLicked(doa: DoaHarian.Data){
        _doahariantunggal.value = doa
    }

    fun onAsmaulHusnaCLicked(asmaulHusna: AsmaulHusna.Data){
        _asmaulHusnaTunggal.value = asmaulHusna
    }
}