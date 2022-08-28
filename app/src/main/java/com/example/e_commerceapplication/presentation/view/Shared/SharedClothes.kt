package com.example.e_commerceapplication.presentation.view.Shared

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.databinding.FragmentMenuPageBinding
import com.example.e_commerceapplication.databinding.FragmentSharedClothesBinding

class SharedClothes : Fragment() {
    private var _binding: FragmentSharedClothesBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSharedClothesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarBackBtn.setOnClickListener {
            findNavController().navigate(R.id.action_sharedClothes_to_menuPage)
        }

        binding.addFilterBtn.setOnClickListener {
            findNavController().navigate(R.id.action_sharedClothes_to_filterPage)
        }

        binding.sharedBtn.setOnClickListener {
            findNavController().navigate(R.id.action_sharedClothes_to_menuPage)
        }
    }

}