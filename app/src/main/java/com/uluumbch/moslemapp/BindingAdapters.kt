package com.uluumbch.moslemapp

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import com.uluumbch.moslemapp.network.AsmaulHusna
import com.uluumbch.moslemapp.network.DoaHarian
import com.uluumbch.moslemapp.ui.ApiStatus
import com.uluumbch.moslemapp.ui.AsmaulHusnaListAdapter
import com.uluumbch.moslemapp.ui.DoaHarianListAdapter


@BindingAdapter("listData")
fun bindRecyclerViewDoaHarian(recyclerView: RecyclerView, data: List<DoaHarian.Data>?) {
    val adapter = recyclerView.adapter as DoaHarianListAdapter
    adapter.submitList(data)

}@BindingAdapter("listDataAsmaulHusna")
fun bindRecyclerViewAsmaulHusna(recyclerView: RecyclerView, data: List<AsmaulHusna.Data>?) {
    val adapter = recyclerView.adapter as AsmaulHusnaListAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun apiStatus(shimmerFrameLayout: ShimmerFrameLayout, status: ApiStatus?){
    when(status){
        ApiStatus.DONE->{
            shimmerFrameLayout.stopShimmer()
            shimmerFrameLayout.visibility = View.GONE
        }
    }
}