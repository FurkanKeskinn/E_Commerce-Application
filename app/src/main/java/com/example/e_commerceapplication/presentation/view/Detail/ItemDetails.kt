package com.example.e_commerceapplication.presentation.view.Detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.databinding.FragmentItemDetailsBinding

class ItemDetails : Fragment() {
    private var _binding: FragmentItemDetailsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backToDetailsBtn.setOnClickListener {
            findNavController().navigate(R.id.action_itemDetails_to_homePage)
        }

        binding.buyNowBtn.setOnClickListener {
            findNavController().navigate(R.id.action_itemDetails_to_cartPage)
        }
    }
}