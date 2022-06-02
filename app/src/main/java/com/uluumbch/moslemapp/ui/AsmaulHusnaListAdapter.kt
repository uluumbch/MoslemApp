package com.uluumbch.moslemapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.uluumbch.moslemapp.databinding.ListViewTemAsmaulHusnaBinding
import com.uluumbch.moslemapp.network.AsmaulHusna

class AsmaulHusnaListAdapter(private val clickListener: AsmaulHusnaListener):
ListAdapter<AsmaulHusna.Data, AsmaulHusnaListAdapter.AsmaulHusnaViewHolder>(DiffCallback){
    class AsmaulHusnaViewHolder(var binding: ListViewTemAsmaulHusnaBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(clickListener: AsmaulHusnaListener, asmaulhusna: AsmaulHusna.Data){
                    binding.asmaulhusma = asmaulhusna
                    binding.clicklistener = clickListener
                    binding.executePendingBindings()
                }
            }

    companion object DiffCallback: DiffUtil.ItemCallback<AsmaulHusna.Data>() {
        override fun areItemsTheSame(
            oldItem: AsmaulHusna.Data,
            newItem: AsmaulHusna.Data
        ): Boolean {
            return oldItem.arabic == newItem.arabic
        }

        override fun areContentsTheSame(
            oldItem: AsmaulHusna.Data,
            newItem: AsmaulHusna.Data
        ): Boolean {
            return oldItem.arabic == newItem.arabic
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsmaulHusnaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AsmaulHusnaViewHolder(
            ListViewTemAsmaulHusnaBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AsmaulHusnaViewHolder, position: Int) {
        val asmaulhusna = getItem(position)
        holder.bind(clickListener, asmaulhusna)
    }
}


class AsmaulHusnaListener(val clicklistener: (asmaulhusna: AsmaulHusna.Data)-> Unit){
    fun onCLick(asmaulhusna: AsmaulHusna.Data) = clicklistener(asmaulhusna)
}