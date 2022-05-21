package com.uluumbch.moslemapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.uluumbch.moslemapp.databinding.ListViewItemBinding

class ListDoaHarianFragment : Fragment() {
    private val viewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val binding = FragmentListDoaHarianBinding.inflate(inflater)
        val binding = ListViewItemBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        viewModel.getDoaList()



        return binding.root
    }
}