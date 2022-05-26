package com.uluumbch.moslemapp.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.uluumbch.moslemapp.databinding.ListViewItemBinding
import com.uluumbch.moslemapp.network.DoaHarian

class DoaHarianListAdapter: ListAdapter<DoaHarian, DoaHarianListAdapter.DoaHarianViewHolder> {
    class DoaHarianViewHolder(var binding: ListViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(clickListener: DoaListener, doaHarian: com.uluumbch.moslemapp.network.Data){
        binding.viewmodel
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoaHarianViewHolder {

    }

    override fun onBindViewHolder(holder: DoaHarianViewHolder, position: Int) {

    }
}