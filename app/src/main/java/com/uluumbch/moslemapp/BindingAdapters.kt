package com.uluumbch.moslemapp

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.uluumbch.moslemapp.network.DoaHarian
import com.uluumbch.moslemapp.ui.DoaHarianListAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<DoaHarian.Data>?) {
    val adapter = recyclerView.adapter as DoaHarianListAdapter
    adapter.submitList(data)
}