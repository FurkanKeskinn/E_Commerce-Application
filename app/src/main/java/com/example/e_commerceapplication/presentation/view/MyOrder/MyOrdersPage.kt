package com.example.e_commerceapplication.presentation.view.MyOrder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_commerceapplication.databinding.FragmentLoginPageBinding
import com.example.e_commerceapplication.databinding.FragmentMenuPageBinding
import com.example.e_commerceapplication.databinding.FragmentMyOrdersPageBinding

class MyOrdersPage : Fragment() {
    private var _binding: FragmentMyOrdersPageBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyOrdersPageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}