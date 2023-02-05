package com.example.walpepers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.walpepers.Adapters.AdapterWalpeper
import com.example.walpepers.R
import com.example.walpepers.databinding.ActivityMainBinding
import com.example.walpepers.viewmoduls.MainScreenViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
    }
}