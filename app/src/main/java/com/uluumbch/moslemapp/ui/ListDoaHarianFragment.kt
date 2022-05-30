package com.uluumbch.moslemapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.uluumbch.moslemapp.R
import com.uluumbch.moslemapp.databinding.FragmentListDoaHarianBinding

class ListDoaHarianFragment : Fragment() {
    private val viewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListDoaHarianBinding.inflate(inflater)
        viewModel.getDoaList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = DoaHarianListAdapter(DoaHarianListener { doa ->
            viewModel.onDoaHarianCLicked(doa)
            findNavController()
                .navigate(R.id.action_listDoaHarianFragment_to_detailDoaHarianFragment)
        })



        return binding.root
    }
}