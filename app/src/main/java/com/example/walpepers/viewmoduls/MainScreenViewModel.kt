package com.example.walpepers.viewmoduls

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.walpepers.R
import com.example.walpepers.infrastructures.WallpaperServiceRepository
import com.example.walpepers.models.Category_item

class MainScreenViewModel(private val repository: WallpaperServiceRepository)
    :ViewModel() {
        private val category: List<Category_item> = listOf(
                Category_item(R.drawable.animals,"animals"),
                Category_item(R.drawable.buildings,"buildings"),
                Category_item(R.drawable.fashion,"fashion"),
                Category_item(R.drawable.food,"food"),
                Category_item(R.drawable.music,"music"),
                Category_item(R.drawable.travel,"travel"),
                Category_item(R.drawable.people,"people"),
                Category_item(R.drawable.sports,"sports")
        )

        val categoryLiveData = MutableLiveData(category)
    val selectedId: MutableLiveData<Int> = MutableLiveData(0)



}