package com.example.walpepers.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.walpepers.databinding.ItemCategoryLayoutBinding
import com.example.walpepers.models.CategoryItem

class AdapterCategory(private val list: LiveData<List<CategoryItem>>, val selectedPosition: MutableLiveData<Int>):RecyclerView.Adapter<AdapterCategory.ViewHolder>() {
    inner class ViewHolder(val categoryLayoutBinding: ItemCategoryLayoutBinding) :
        RecyclerView.ViewHolder(categoryLayoutBinding.root) {
        var id: Int = 1
        init {
            categoryLayoutBinding.imageCategory.setOnClickListener{
                if (selectedPosition.value!=id){
                    selectedPosition.value=id
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCategoryLayoutBinding =
            ItemCategoryLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.value!!.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val picture = AppCompatResources.getDrawable(
            holder.categoryLayoutBinding.root.context, list.value!![position].resourceId
        )
        holder.categoryLayoutBinding.imageCategory.setImageDrawable(picture)
        holder.categoryLayoutBinding.nameCategory.text =
            list.value!![position].name
        holder.id = position

    }
}