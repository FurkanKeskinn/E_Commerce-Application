package com.example.e_commerceapplication.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var productAdapter: ProductRecyclerAdapter

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI()
        initObservers()
    }

    private fun bindUI() {
        binding.run {
            toolbarMenu.setOnClickListener {
                findNavController().navigate(R.id.action_home_to_menu)
            }
            toolbarShoppingBasket.setOnClickListener {
                findNavController().navigate(R.id.action_home_to_item)
            }
            toolbarFilter.setOnClickListener {
                findNavController().navigate(R.id.action_home_to_filter)
            }

            productAdapter = ProductRecyclerAdapter().also {
                productListRecycler.adapter = it
            }
        }
    }

    private fun initObservers() {
        viewModel.getLiveDataObserver().observe(viewLifecycleOwner) {
            it?.let {
                productAdapter.setList(it)
                productAdapter.notifyDataSetChanged()
            }
        }
        viewModel.loadData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}