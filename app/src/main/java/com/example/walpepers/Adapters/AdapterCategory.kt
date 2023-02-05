package com.example.walpepers.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.walpepers.databinding.ItemCategoryLayoutBinding
import com.example.walpepers.models.Category_item

class AdapterCategory(private val list: LiveData<List<Category_item>>, val selectedPosition: MutableLiveData<Int>):RecyclerView.Adapter<AdapterCategory.ViewHolder>() {
   inner class ViewHolder(val categoryLayoutBinding: ItemCategoryLayoutBinding):RecyclerView.ViewHolder(categoryLayoutBinding.root) {


       var id:Int=1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding:ItemCategoryLayoutBinding=ItemCategoryLayoutBinding.inflate(LayoutInflater.from(parent.context))
    return ViewHolder(binding)}

    override fun getItemCount(): Int {
return list.value!!.count()   }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val picture=AppCompatResources.getDrawable(
           holder.categoryLayoutBinding.root.context,list.value!![position].resourseId
       )
        holder.categoryLayoutBinding.imageCategory.setImageDrawable(picture)
        holder.categoryLayoutBinding.nameCategory.text=
            list.value!![position].name
        holder.id=position

    }
}