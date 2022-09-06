package com.example.e_commerceapplication.presentation.view.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.data.model.Product
import com.example.e_commerceapplication.data.model.ResultItem
import com.example.e_commerceapplication.databinding.FragmentHomePageBinding
import dagger.hilt.android.AndroidEntryPoint

class HomePage : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!
    private lateinit var productAdapter: ProductRecyclerAdapter
   //private val viewModel: HomeViewModel by viewModels()
   private val viewModel: HomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePageBinding.inflate(layoutInflater, container, false)
        return binding.root

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

        /*val layoutManager = LinearLayoutManager(context)
        binding.productListRecycler.layoutManager = layoutManager
        binding.productListRecycler.adapter = productAdapter*/

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