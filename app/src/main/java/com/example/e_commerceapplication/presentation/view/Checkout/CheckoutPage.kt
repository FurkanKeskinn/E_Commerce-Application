package com.example.e_commerceapplication.presentation.view.Checkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.databinding.FragmentCheckoutPageBinding
import com.example.e_commerceapplication.databinding.FragmentMenuPageBinding

class CheckoutPage : Fragment() {
    private var _binding: FragmentCheckoutPageBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCheckoutPageBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarBackCheckoutBtn.setOnClickListener {
            findNavController().navigate(R.id.action_checkoutPage_to_homePage)
        }

        binding.buyBtn.setOnClickListener {
            findNavController().navigate(R.id.action_checkoutPage_to_confirmationPage)
        }
    }

}