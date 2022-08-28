package com.example.e_commerceapplication.presentation.view.Home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.data.model.Product
import com.example.e_commerceapplication.databinding.CardCellBinding
import com.example.e_commerceapplication.databinding.FragmentHomePageBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import kotlin.coroutines.coroutineContext

class ProductRecyclerAdapter: RecyclerView.Adapter<ProductRecyclerAdapter.ProductViewHolder>() {

    //private val productList = ArrayList<Product>()
    private var productList: List<Product>? = null

            fun setList(data: List<Product>){
                this.productList = data
            }


    class ProductViewHolder(val binding: CardCellBinding):
    RecyclerView.ViewHolder(binding.root){

        fun bind(product: Product){
            binding.productName.text = product.name
        binding.productPrice.text = product.price.toString()

        binding.productCard.setOnClickListener {
            val action = HomePageDirections.actionHomePageToItemDetails()
            Navigation.findNavController(it).navigate(action)

        }

        Picasso.get().load(product.image).into(binding.productImageView)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val productBinding = CardCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(productBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList!!.get(position))


    }

    override fun getItemCount(): Int {
        if (productList == null){
            return 0
        }else
            return productList!!.size
    }

    /*fun updateList(list: List<Product>) {
        productList.clear()
        productList.addAll(list)
    }*/
}