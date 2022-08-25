package com.example.e_commerceapplication.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.databinding.FragmentHomePageBinding
import com.example.e_commerceapplication.databinding.FragmentMenuPageBinding

class MenuPage : Fragment() {
    private var _binding: FragmentMenuPageBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuPageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.menuHome.setOnClickListener {
            findNavController().navigate(R.id.action_menuPage_to_homePage)

        }

        binding.menuAddClothes.setOnClickListener {
            findNavController().navigate(R.id.action_menuPage_to_sharedClothes)

        }

        binding.toolbarCloseBtn.setOnClickListener {
            findNavController().navigate(R.id.action_menuPage_to_homePage)

        }
    }


}