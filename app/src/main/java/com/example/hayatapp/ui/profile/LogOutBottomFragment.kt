package com.example.hayatapp.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hayatapp.R
import com.example.hayatapp.databinding.FragmentLogOutBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class LogOutBottomFragment : BottomSheetDialogFragment() {
    private lateinit var binding:FragmentLogOutBottomBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentLogOutBottomBinding.inflate(inflater, container, false)

        return binding.root
    }


}