package com.example.hayatapp.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hayatapp.R
import com.example.hayatapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding:FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding=FragmentProfileBinding.inflate(inflater, container, false)
        binding.editButton.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToUpdateProfileFragment())
        }
        binding.notifications.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToNotificationListFragment())
        }
        binding.DeleteAccountButton.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToDeleteAccountBottomFragment())
        }
        binding.aboutUsC.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToAboutUsFragment())
        }
        binding.logoutButton.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToLogOutBottomFragment())
        }
        binding.wallet.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToWalletFragment())
        }
        return binding.root
    }

}