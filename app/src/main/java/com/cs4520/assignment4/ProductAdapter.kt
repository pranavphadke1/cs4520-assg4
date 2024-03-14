package com.cs4520.assignment1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val products: List<Product>):RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.name.text = product.name
        val text = product.expiryDate ?: ""
        holder.expiryDate.text = text
        if (text == ""){
            holder.expiryDate.visibility = TextView.GONE
        }
        holder.price.text = "$ " + product.price.toString()
        if (product.type == "Equipment") {
            holder.type.setImageResource(R.drawable.equipment)
            holder.itemView.setBackgroundColor(0xFFE06666.toInt())
        } else if (product.type == "Food") {
            holder.type.setImageResource(R.drawable.food)
            holder.itemView.setBackgroundColor(0xFFFFD965.toInt())
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
}

class ProductViewHolder(productView: View): RecyclerView.ViewHolder(productView) {
    val name: TextView = itemView.findViewById(R.id.name)
    val type: ImageView = itemView.findViewById(R.id.type)
    val expiryDate: TextView = itemView.findViewById(R.id.expiryDate)
    val price: TextView = itemView.findViewById(R.id.price)
}
