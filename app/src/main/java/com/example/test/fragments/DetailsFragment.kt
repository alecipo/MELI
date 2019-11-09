package com.example.test.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.test.R
import com.example.test.models.Results
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayProudct(args.product)
    }

    fun displayProudct(product: Results) {

        Glide.with(this)
            .load(product.thumbnail)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(product_img)

        product_soldQ.text = product.sold_quantity.toString()
        product_name.text = product.title
        product_cond.text = product.condition

    }
}


