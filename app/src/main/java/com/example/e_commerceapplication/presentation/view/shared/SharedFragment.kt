package com.example.e_commerceapplication.presentation.view.shared

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.databinding.FragmentSharedBinding

class SharedFragment : Fragment() {
    private var _binding: FragmentSharedBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSharedBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarBackBtn.setOnClickListener {
            findNavController().navigate(R.id.action_shared_to_menu)
        }

        binding.addFilterBtn.setOnClickListener {
            findNavController().navigate(R.id.action_shared_to_filter)
        }

        binding.sharedBtn.setOnClickListener {
            findNavController().navigate(R.id.action_shared_to_menu)
        }
    }

}