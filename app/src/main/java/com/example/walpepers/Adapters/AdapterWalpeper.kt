package com.example.walpepers.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.walpepers.data.Wallpaper
import com.example.walpepers.databinding.ItemWalpeperLayoutBinding

class AdapterWalpeper():RecyclerView.Adapter<AdapterWalpeper.ViewHolder>() {
    val list=ArrayList<Wallpaper>()
    inner class ViewHolder(val walpeperLayoutBinding: ItemWalpeperLayoutBinding):RecyclerView.ViewHolder(walpeperLayoutBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(ItemWalpeperLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    Glide.with(holder.itemView).load(list[position].largeImageURL)
        .into(holder.walpeperLayoutBinding.imageWalpeper)


    }
}