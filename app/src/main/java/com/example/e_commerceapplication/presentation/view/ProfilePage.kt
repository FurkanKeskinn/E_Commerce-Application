package com.example.e_commerceapplication.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_commerceapplication.databinding.FragmentLoginPageBinding
import com.example.e_commerceapplication.databinding.FragmentMenuPageBinding
import com.example.e_commerceapplication.databinding.FragmentProfilePageBinding

class ProfilePage : Fragment() {
    private var _binding: FragmentProfilePageBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfilePageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

}