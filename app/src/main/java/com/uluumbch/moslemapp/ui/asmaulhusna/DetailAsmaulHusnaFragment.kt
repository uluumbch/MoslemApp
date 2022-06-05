package com.uluumbch.moslemapp.ui.asmaulhusna

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.uluumbch.moslemapp.databinding.FragmentDetailAsmaulHusnaBinding
import com.uluumbch.moslemapp.ui.MyViewModel

class DetailAsmaulHusnaFragment: Fragment() {
    private val myViewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailAsmaulHusnaBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = myViewModel
        return binding.root
    }
}