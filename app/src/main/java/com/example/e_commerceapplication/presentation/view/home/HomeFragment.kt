package com.example.e_commerceapplication.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var productAdapter: ProductRecyclerAdapter
   //private val viewModel: HomeViewModel by viewModels()
    private val viewModel: HomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarMenu.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_menu)
        }
        binding.toolbarShoppingBasket.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_item)
        }
        binding.toolbarFilter.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_filter)
        }
        /*binding.recyclerView.apply {
                   layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
               }*/


        initObservers()
    }
    private fun initObservers(){
        productAdapter = ProductRecyclerAdapter()
        val layoutManager = LinearLayoutManager(context)
        binding.productListRecycler.layoutManager = layoutManager
        binding.productListRecycler.adapter = productAdapter

       /* viewModel.getLiveDataObserver().observe(viewLifecycleOwner, object: Observer<Product>{
            override fun onChanged(t: Product?) {
                if (t != null){
                    productAdapter.setList(t.result)
                    productAdapter.notifyDataSetChanged()
                }
            }

        })
        viewModel.loadData()*/

        viewModel.getLiveDataObserver().observe(viewLifecycleOwner) {

            if (it != null) {
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