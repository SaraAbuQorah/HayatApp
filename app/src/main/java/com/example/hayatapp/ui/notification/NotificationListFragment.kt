package com.example.hayatapp.ui.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hayatapp.R
import com.example.hayatapp.databinding.FragmentNotificationListBinding

class NotificationListFragment : Fragment() {
    private lateinit var binding: FragmentNotificationListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentNotificationListBinding.inflate(inflater, container, false)
        return binding.root
    }


}