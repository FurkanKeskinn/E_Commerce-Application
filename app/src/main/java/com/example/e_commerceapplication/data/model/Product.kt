package com.example.e_commerceapplication.data.model

data class Product(
	val result: List<ResultItem?>? = null,
	val date: String? = null,
	val success: Boolean? = null,
	val message: String? = null
)

data class ResultItem(
	val image: String? = null,
	val gender: String? = null,
	val color: String? = null,
	val price: Int? = null,
	val name: String? = null,
	val description: String? = null,
	val id: Int? = null,
	val category: String? = null
)

