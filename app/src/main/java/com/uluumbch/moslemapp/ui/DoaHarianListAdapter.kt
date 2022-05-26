package com.uluumbch.moslemapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.uluumbch.moslemapp.databinding.ListViewItemDoaBinding
import com.uluumbch.moslemapp.network.DoaHarian

class DoaHarianListAdapter(private val clickListener: DoaHarianListener) :
    ListAdapter<DoaHarian.Data, DoaHarianListAdapter.DoaHarianViewHolder>(DiffCallback) {
    class DoaHarianViewHolder(var binding: ListViewItemDoaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: DoaHarianListener, doaHarian: DoaHarian.Data) {
            binding.viewmodel
            binding.clicklistener = clickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoaHarianViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DoaHarianViewHolder(
            ListViewItemDoaBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DoaHarianViewHolder, position: Int) {
        val doa = getItem(position)
        holder.bind(clickListener, doa)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<DoaHarian.Data>() {
        override fun areItemsTheSame(oldItem: DoaHarian.Data, newItem: DoaHarian.Data): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: DoaHarian.Data, newItem: DoaHarian.Data): Boolean {
            return oldItem.title == newItem.title
        }

    }
}

class DoaHarianListener(val clickListener: (doa: DoaHarian.Data) -> Unit) {
    fun onClick(doa: DoaHarian.Data) = clickListener(doa)
}