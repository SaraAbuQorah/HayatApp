package com.example.hayatapp.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hayatapp.R
import com.example.hayatapp.databinding.FragmentCallBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CallBottomFragment : BottomSheetDialogFragment() {
   private lateinit var binding:FragmentCallBottomBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentCallBottomBinding.inflate(inflater, container, false)

        return binding.root
    }


}