package com.example.walpepers.viewmoduls

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.walpepers.R
import com.example.walpepers.infrastructures.WallpaperServiceRepository
import com.example.walpepers.models.CategoryItem

class MainScreenViewModel(private val repository: WallpaperServiceRepository)
    :ViewModel() {
        private val category: List<CategoryItem> = listOf(
                CategoryItem(R.drawable.animals,"animals"),
                CategoryItem(R.drawable.buildings,"buildings"),
                CategoryItem(R.drawable.fashion,"fashion"),
                CategoryItem(R.drawable.food,"food"),
                CategoryItem(R.drawable.music,"music"),
                CategoryItem(R.drawable.travel,"travel"),
                CategoryItem(R.drawable.people,"people"),
                CategoryItem(R.drawable.sports,"sports")
        )

        val categoryLiveData = MutableLiveData(category)
        val selectedId: MutableLiveData<Int> = MutableLiveData(0)
}