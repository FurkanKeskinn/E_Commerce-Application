package com.example.e_commerceapplication.presentation.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceapplication.R
import com.example.e_commerceapplication.data.model.ResultItem
import com.example.e_commerceapplication.databinding.CardCellBinding
import com.squareup.picasso.Picasso

class ProductRecyclerAdapter : RecyclerView.Adapter<ProductRecyclerAdapter.ProductViewHolder>() {

    var liveData: List<ResultItem?>? = null

    fun setList(data: List<ResultItem?>?) {
        this.liveData = data
    }

    class ProductViewHolder(val binding: CardCellBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindItems(result: ResultItem) {
            binding.run {
                productName.text = result.name
                productPrice.text = result.price.toString()
               /* productCard.setOnClickListener {
                    it.findNavController().navigate(R.id.action_home_to_item)
                }*/
                productCard.setOnClickListener {
                    val transition =
                        HomeFragmentDirections.actionHomeToItem(result.id!!)
                            Navigation.findNavController(it).navigate(transition)
                }
            }
            result.image.let {
                Picasso.get().load(it).into(binding.productImageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            CardCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        liveData!![position]?.let { holder.bindItems(it) }
    }

    override fun getItemCount(): Int {
        return liveData?.size ?: 0
    }


}

