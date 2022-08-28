package com.example.e_commerceapplication.presentation.view.Login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.e_commerceapplication.MainActivity
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.databinding.FragmentFilterPageBinding
import com.example.e_commerceapplication.databinding.FragmentLoginPageBinding

class LoginPage : Fragment() {
    private var _binding: FragmentLoginPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginPageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginBtn.setOnClickListener {
           findNavController().navigate(R.id.action_loginPage_to_homePage)
        }

        binding.signUpBtnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginPage_to_signUp)
        }
    }

}