package com.example.walpepers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walpepers.Adapters.AdapterCategory
import com.example.walpepers.Adapters.AdapterWalpeper
import com.example.walpepers.R
import com.example.walpepers.databinding.ActivityMainBinding
import com.example.walpepers.viewmoduls.MainScreenViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainScreenViewModel:MainScreenViewModel by viewModel()
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

        val adapterWalpeper=AdapterWalpeper()
        binding.listImage.adapter=adapterWalpeper
    }

}