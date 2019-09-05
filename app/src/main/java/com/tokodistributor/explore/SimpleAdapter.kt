package com.tokodistributor.explore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SimpleAdapter : RecyclerView.Adapter<SimpleAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.simple_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = 20

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

    }

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view)

}