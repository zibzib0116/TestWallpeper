package com.example.walpepers.viewmoduls

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walpepers.R
import com.example.walpepers.data.Wallpaper
import com.example.walpepers.infrastructures.WallpaperServiceRepository
import com.example.walpepers.models.CategoryItem
import kotlinx.coroutines.launch

class MainScreenViewModel(private val repository: WallpaperServiceRepository) :ViewModel() {
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
        val walpeperLiveData=MutableLiveData<ArrayList<Wallpaper>>(arrayListOf())
        private val messageLiveData = MutableLiveData<String>(null)

        fun UpdateCategory(category:String){
                viewModelScope.launch{
                        try {
                                val wallpapers = repository.getWallpaper(category)
                                walpeperLiveData.value = wallpapers.hits
                        }catch (ex:Exception){
                                messageLiveData.value = "Error network connection!"
                                Log.d("TestConnect", ex.message.toString())
                        }
                }
        }
}