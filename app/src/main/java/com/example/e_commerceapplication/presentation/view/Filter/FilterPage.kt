package com.example.e_commerceapplication.presentation.view.Filter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.databinding.FragmentFilterPageBinding


class FilterPage : Fragment() {

    private var _binding: FragmentFilterPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFilterPageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarBackFilterBtn.setOnClickListener {
            findNavController().navigate(R.id.action_filterPage_to_homePage)
        }


    }
}