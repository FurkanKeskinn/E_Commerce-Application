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
import com.example.e_commerceapplication.databinding.FragmentHomePageBinding
import dagger.hilt.android.AndroidEntryPoint


class HomePage : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!
   /* private val viewModel by lazy {
        ViewModelProvider(this,defaultViewModelProviderFactory).get(HomeViewModel::class.java)
    }*/
    private lateinit var productAdapter: ProductRecyclerAdapter
    private val allProductAdapter by lazy { ProductRecyclerAdapter() }


    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
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

        productAdapter = ProductRecyclerAdapter()
        val layoutManager = LinearLayoutManager(context)
        binding.productListRecycler.layoutManager = layoutManager
        binding.productListRecycler.adapter = allProductAdapter

        //initObservers()

        setUpRecyclerView()
        getProducts()
        observeProducts()
    }

   /* private fun initObservers(){
       /* with(binding){
            with(viewModel){

                productList.observe(viewLifecycleOwner){ list ->
                    productListRecycler.apply {
                        setHasFixedSize(true)
                        adapter = allProductAdapter.also { adapter ->
                            adapter.updateList(listOf(list))
                        }
                    }
                }
               /* isLoading.observe(viewLifecycleOwner){
                    if (it){

                    }*/
                 }
            }*/


       viewModel.getLiveDataObserver().observe(viewLifecycleOwner, object: Observer<List<Product>>{
            override fun onChanged(t: List<Product>?) {
                if (t != null) {
                    productAdapter.setList(t)
                }
                   // productAdapter.notifyDataSetChanged()

            }

        })
        viewModel.loadData()

        productAdapter = ProductRecyclerAdapter()
        //setUpRecyclerView()
       // observeShows()

        }*/
    /*private fun setUpRecyclerView() {

        binding.productListRecycler.apply {
            adapter = productAdapter
        }
    }*/
    /*private fun observeShows() {

        viewModel.getLiveDataObserver().observe(viewLifecycleOwner, object:Observer<Product> {
            override fun onChanged(t: Product?) {
                if (t != null) {
                    productAdapter.setList(t)
                }

            }

        })
        viewModel.loadData()

    }*/

    private fun setUpRecyclerView() {

        binding.productListRecycler.apply {
            adapter = productAdapter
        }

    }

    private fun getProducts() {

        viewModel.getProducts()

    }
    private fun observeProducts() {

        viewModel.observeProducts().observe(viewLifecycleOwner) {
            productAdapter.setProducts(it)
            //enableViews()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}