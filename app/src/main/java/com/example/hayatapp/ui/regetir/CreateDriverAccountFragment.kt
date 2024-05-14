package com.example.hayatapp.ui.regetir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hayatapp.R
import com.example.hayatapp.databinding.FragmentCreateDriverAccountBinding

class CreateDriverAccountFragment : Fragment() {
    private lateinit var binding:FragmentCreateDriverAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentCreateDriverAccountBinding.inflate(inflater, container, false)
        binding.letsGoButton.setOnClickListener {
            findNavController().navigate(CreateDriverAccountFragmentDirections.actionCreateDriverAccountFragmentToHomeMApFragment())
        }
        return binding.root
    }

}