package com.example.hayatapp.ui.requestOrder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hayatapp.R
import com.example.hayatapp.databinding.FragmentAcceptBottomDialogBinding

class AcceptBottomDialogFragment : Fragment() {
   private lateinit var binding:FragmentAcceptBottomDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding=FragmentAcceptBottomDialogBinding.inflate(inflater, container, false)

        return binding.root
    }


}