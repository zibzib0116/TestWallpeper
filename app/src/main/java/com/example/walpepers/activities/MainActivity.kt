package com.example.walpepers.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.walpepers.Adapters.AdapterCategory
import com.example.walpepers.Adapters.AdapterWalpeper
import com.example.walpepers.data.Wallpaper
import com.example.walpepers.databinding.ActivityMainBinding
import com.example.walpepers.viewmoduls.MainScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainScreenViewModel:MainScreenViewModel by viewModel()

    fun imageClick(image:Wallpaper){
        val intent= Intent(this,WalpeperFullActivity::class.java)
        intent.putExtra("url",image.largeImageURL)
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listCategory.adapter=
            AdapterCategory(
                mainScreenViewModel.categoryLiveData,
                mainScreenViewModel.selectedId)
        binding.listCategory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapterWalpeper=AdapterWalpeper { image -> imageClick(image) }
        binding.listImage.adapter=adapterWalpeper
        val staggered =  StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        binding.listImage.layoutManager = staggered

        mainScreenViewModel.selectedId.observe(this){
            val category:String = mainScreenViewModel.categoryLiveData.value?.get(it)!!.name
            mainScreenViewModel.UpdateCategory(category)
        }

        mainScreenViewModel.walpeperLiveData.observe(this){
            adapterWalpeper.updateData(it)
        }
    }

}