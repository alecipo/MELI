package com.example.test.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.test.R
import com.example.test.models.Product
import com.example.test.services.MeliServices
import com.example.test.services.RetrofitClientInstance
import kotlinx.android.synthetic.main.fragment_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var prod: Product

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getProduct()
    }

    private fun getProduct() {
        val service = RetrofitClientInstance.retrofitInstance.create(MeliServices::class.java)
        val call = service.getProduct(args.product.id)
        call.enqueue(object : Callback<Product> {
            override fun onResponse(
                call: Call<Product>,
                response: Response<Product>
            ) {
                prod = response.body()!!
                displayProduct()
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    private fun displayProduct() {

        Glide.with(this)
            .load(prod.pictures[0].url)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(product_img)

        product_soldQ.text = getString(R.string.sold, prod.sold_quantity)
        product_name.text = prod.title
        product_cond.text = prod.condition
    }
}


