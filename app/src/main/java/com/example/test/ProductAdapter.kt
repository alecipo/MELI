package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.test.models.Results
import kotlinx.android.synthetic.main.product_item.view.*


class ProductAdapter(var itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var items: List<Results> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.product_item,
                parent,
                false
            ), itemClickListener
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun submitList(productList: List<Results>) {
        items = productList
    }

    class ProductViewHolder(itemView: View, var _itemClickListener: ItemClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val productName = itemView.product_name
        private val productImg = itemView.product_thumbnail
        private val productPrice = itemView.product_price

        fun bind(productItem: Results) {

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

            productName.text = productItem.title
            productPrice.text = "$" + productItem.price
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            _itemClickListener.onProdClick(adapterPosition)
        }
    }

    interface ItemClickListener {

        fun onProdClick(pos: Int)
    }
}