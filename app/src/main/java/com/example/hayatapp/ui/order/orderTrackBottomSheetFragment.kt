package com.example.hayatapp.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hayatapp.R
import com.example.hayatapp.databinding.FragmentOrderTrackBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class orderTrackBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentOrderTrackBottomSheetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentOrderTrackBottomSheetBinding.inflate(inflater, container, false)
        binding.callRequest.setOnClickListener {
            findNavController().navigate(orderTrackBottomSheetFragmentDirections.actionOrderTrackBottomSheetFragmentToCallBottomFragment())
        }
        binding.cancelRequest.setOnClickListener {
            findNavController().navigate(orderTrackBottomSheetFragmentDirections.actionOrderTrackBottomSheetFragmentToCallBottomFragment())
        }
        return binding.root
    }
}