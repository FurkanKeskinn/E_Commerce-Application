package com.example.e_commerceapplication.presentation.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.liveData
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.data.model.ResultItem
import com.example.e_commerceapplication.databinding.FragmentItemBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemFragment : Fragment() {
    private var _binding: FragmentItemBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ItemViewModel by viewModels()
    private val args: ItemFragmentArgs by navArgs()
    //private val viewModel = ViewModelProvider(this)[ItemViewModel::class.java]
    //val viewModel = ViewModelProvider(this)[ItemViewModel::class.java]


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI()
        bindItem()
    }

    private fun bindUI() {
        binding.backToDetailsBtn.setOnClickListener {
            findNavController().navigate(R.id.action_item_to_home)
        }

        binding.buyNowBtn.setOnClickListener {
            findNavController().navigate(R.id.action_item_to_cart)
        }
    }

    private fun bindItem() {

        viewModel.getLiveDataObserver()?.observe(viewLifecycleOwner) {
            it.let { result ->
                binding.run {
                    result?.image.let {
                        Picasso.get().load(result?.image).into(itemImage)
                    }
                    itemName.text = result?.name
                    itemPrice.text = result?.price.toString()
                    itemDescription.text = result?.description

                    buyNowBtn.setOnClickListener { view ->
                        view.findNavController().navigate(R.id.action_item_to_cart)
                    }
                }
            }
        }
        viewModel.getData(args.itemId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}