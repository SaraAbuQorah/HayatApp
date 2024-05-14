package com.example.hayatapp.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hayatapp.R
import com.example.hayatapp.databinding.FragmentDeleteAccountBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class DeleteAccountBottomFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentDeleteAccountBottomBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentDeleteAccountBottomBinding.inflate(inflater, container, false)
        return binding.root
    }


}