package com.cs4520.assignment4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment4.databinding.ProductListViewBinding

class ProductListFragment:Fragment(R.layout.product_list_view) {
    private var _product_list_binding: ProductListViewBinding? = null
    private val product_list_binding get() = _product_list_binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState);
        _product_list_binding = ProductListViewBinding.inflate(inflater, container, false)

        val products = null
        val viewModel = ViewModel()

        val recyclerView:RecyclerView = _product_list_binding!!.recyclerView
        val productAdapter = ProductAdapter(products,container)
        recyclerView.adapter = productAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.productList.observe(viewLifecycleOwner, Observer { res ->
            productAdapter.setProducts(res)
            productAdapter.notifyDataSetChanged()
        })

        viewModel.fetchProducts()
        return product_list_binding.root
    }
}