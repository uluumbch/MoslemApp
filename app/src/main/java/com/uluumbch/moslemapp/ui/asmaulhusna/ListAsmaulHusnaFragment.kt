package com.uluumbch.moslemapp.ui.asmaulhusna

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.uluumbch.moslemapp.R
import com.uluumbch.moslemapp.databinding.FragmentListAsmaulHusnaBinding
import com.uluumbch.moslemapp.ui.MyViewModel

class ListAsmaulHusnaFragment: Fragment() {
    private val myViewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListAsmaulHusnaBinding.inflate(inflater)
        myViewModel.getAsmaulHusnaList()
        binding.lifecycleOwner = this
        binding.viewModel = myViewModel
        binding.recyclerView.adapter = AsmaulHusnaListAdapter(AsmaulHusnaListener { asmaulhusna ->
            myViewModel.onAsmaulHusnaCLicked(asmaulhusna)
            findNavController()
                .navigate(R.id.action_listAsmaulHusnaFragment_to_detailAsmaulHusnaFragment)
        })
        return binding.root
    }


}