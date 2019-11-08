package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.test.models.Results
import kotlinx.android.synthetic.main.product_item.view.*


class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var items: List<Results> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.product_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun submitList(productList: List<Results>) {
        items = productList
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productName = itemView.product_name
        private val productImg = itemView.product_img

        fun bind(productItem: Results) {
            productName.text = productItem.title

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            val url = productItem.thumbnail
            Glide.with(itemView.context)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(productImg)
        }
    }

}