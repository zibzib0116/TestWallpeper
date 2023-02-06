package com.example.walpepers.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.walpepers.data.Wallpaper
import com.example.walpepers.databinding.ItemWalpeperLayoutBinding

class AdapterWalpeper(var imageClick: (image:Wallpaper) -> Unit):RecyclerView.Adapter<AdapterWalpeper.ViewHolder>() {
    private var list = ArrayList<Wallpaper>()

    fun updateData(list: ArrayList<Wallpaper>) {
        this.list.clear()
        this.list = list;
        notifyDataSetChanged()
    }

    inner class ViewHolder(val walpeperLayoutBinding: ItemWalpeperLayoutBinding) :
        RecyclerView.ViewHolder(walpeperLayoutBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemWalpeperLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.walpeperLayoutBinding.imageWalpeper.load(list[position].webformatURL)
        holder.walpeperLayoutBinding.nameWalpeper.text = list[position].tags
        /*Glide.with(holder.itemView).load(R.drawable.animals)
            .into(holder.walpeperLayoutBinding.imageWalpeper)*/
        holder.walpeperLayoutBinding.imageWalpeper.setOnClickListener {
            imageClick(list[position])
        }
    }
}