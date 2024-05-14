package com.example.hayatapp.ui.requestOrder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.hayatapp.R
import com.example.hayatapp.databinding.FragmentRequestOrderListBinding

class RequestOrderListFragment : Fragment() {
    private lateinit var binding:FragmentRequestOrderListBinding
    private lateinit var viewModel:RequestViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentRequestOrderListBinding.inflate(inflater, container, false)


        viewModel = ViewModelProvider(this).get(RequestViewModel::class.java)

        binding.viewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root

    }



}