package com.example.hayatapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hayatapp.databinding.FragmentLogOutDeniedBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class LogOutDeniedFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentLogOutDeniedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentLogOutDeniedBinding.inflate(inflater, container, false)
        return binding.root
    }


}