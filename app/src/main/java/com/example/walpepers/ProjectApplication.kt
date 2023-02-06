package com.example.walpepers

import android.app.Application
import com.example.walpepers.infrastructures.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.dsl.module
import com.example.walpepers.viewmoduls.MainScreenViewModel
import com.example.walpepers.viewmoduls.ViewFullSreenModel

import org.koin.core.module.dsl.singleOf

class ProjectApplication:Application() {

    val appmodul=module{
        viewModelOf(::MainScreenViewModel)
        viewModelOf(::ViewFullSreenModel)
    }



    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ProjectApplication)
            modules(listOf(networkModule, appmodul))
        }
    }

}

