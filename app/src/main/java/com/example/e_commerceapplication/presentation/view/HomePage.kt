package com.example.e_commerceapplication.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.databinding.FragmentHomePageBinding
import com.example.e_commerceapplication.databinding.FragmentLoginPageBinding


class HomePage : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.toolbarMenu.setOnClickListener {
            findNavController().navigate(R.id.action_homePage_to_menuPage)

        }

        binding.toolbarShoppingBasket.setOnClickListener {
            findNavController().navigate(R.id.action_homePage_to_itemDetails)

        }

        binding.toolbarFilter.setOnClickListener {
            findNavController().navigate(R.id.action_homePage_to_filterPage)

        }

        /*binding.recyclerView.apply {
                   layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
               }*/
    }

}