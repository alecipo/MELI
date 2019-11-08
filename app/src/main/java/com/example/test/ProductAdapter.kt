package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.test.data.ProductItem
import kotlinx.android.synthetic.main.product_item.view.*

class ProductAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<ProductItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.product_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProductViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    fun submitList(productList: List<ProductItem>) {
        items = productList
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productName = itemView.product_name
        private val productImg = itemView.product_img

        fun bind(productItem: ProductItem) {
            productName.text = productItem.name

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .load(productItem.image)
                .into(productImg)
        }
    }

}