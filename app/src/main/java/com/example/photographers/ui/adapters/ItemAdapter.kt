package com.example.photographers.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.photographers.R
import com.example.photographers.databinding.ItemBinding
import com.example.photographers.domain.model.Item
import com.squareup.picasso.Picasso

class ItemAdapter(private var items: List<Item>, private val listener: OnClickListener) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){

    private lateinit var context: Context

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemBinding.bind(view)

        fun setListener(item: Item){
            binding.root.setOnClickListener {
                listener.onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        with(holder){
            setListener(item)
            binding.tvName.text = item.name
            Picasso.get()
                .load("todo") //TODO charge from local db
                .error(R.drawable.baseline_broken_image_24)
                .fit()
                .centerCrop()
                .into(binding.ivPhoto)
        }
    }


    fun setItems(newItemList: List<Item>) {
        items = newItemList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}