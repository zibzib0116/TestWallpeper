package com.example.walpepers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Size
import android.view.WindowManager
import androidx.lifecycle.ViewModel
import coil.load
import com.example.walpepers.R
import com.example.walpepers.databinding.ActivityWalpeperFullBinding
import com.example.walpepers.viewmoduls.ViewFullSreenModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WalpeperFullActivity : AppCompatActivity() {
    lateinit var binding: ActivityWalpeperFullBinding
    private val viewFullSreenModel:ViewFullSreenModel by viewModel()
    private fun getMetrics():Size{

        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            val display = this.getSystemService(WindowManager::class.java).currentWindowMetrics
            Size(display.bounds.width(), display.bounds.height())
        } else {
            val outMetrics = DisplayMetrics()

            @Suppress("DEPRECATION")
            val display = windowManager.defaultDisplay
            @Suppress("DEPRECATION")
            display.getMetrics(outMetrics)
            Size(outMetrics.widthPixels, outMetrics.heightPixels)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWalpeperFullBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val url=intent.extras!!.getString("url")
        binding.fullImg.load(url)
        binding.btInstall.setOnClickListener {
            viewFullSreenModel.setWalpeper(url.toString(), getMetrics())

        }
    }
}