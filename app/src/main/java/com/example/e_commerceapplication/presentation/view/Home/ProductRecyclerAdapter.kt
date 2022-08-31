package com.example.e_commerceapplication.presentation.view.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.room.util.appendPlaceholders
import com.example.e_commerceapplication.data.model.Product
import com.example.e_commerceapplication.data.model.Products
import com.example.e_commerceapplication.databinding.CardCellBinding
import com.squareup.picasso.Picasso

class ProductRecyclerAdapter: RecyclerView.Adapter<ProductRecyclerAdapter.ProductViewHolder>() {


    /*private var productList : List<Product> = ArrayList()
    //private var productList: List<Product>? = null

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
        //holder.bind(productList!!.get(position))
        holder.bind(productList[position])

    }

    override fun getItemCount(): Int {
            return productList.size
    }

    /*fun updateList(list: Product) {
        notifyDataSetChanged()
    }*/*/

    private var products : List<Product> = ArrayList()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val productBinding = CardCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(productBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = products[position]

        holder.binding.apply {
            productName.text = product.name
            productPrice.text = product.price.toString()
            Picasso.get().load(product.image).into(productImageView)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
    class ProductViewHolder(val binding: CardCellBinding): RecyclerView.ViewHolder(binding.root)

    fun setProducts(products: List<Product>) {
        this.products = products
    }

   /* fun bind(product: Product){
        binding.productName.text = product.name
        binding.productPrice.text = product.price.toString()

        binding.productCard.setOnClickListener {
            val action = HomePageDirections.actionHomePageToItemDetails()
            Navigation.findNavController(it).navigate(action)

        }

        Picasso.get().load(product.image).into(binding.productImageView)
    }*/
}