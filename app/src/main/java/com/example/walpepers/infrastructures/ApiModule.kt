package com.example.walpepers.infrastructures

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

var networkModule= module {
    single { providerRetrofit() }
    factory { providerWallpaperService(get())  }
    factoryOf(::WallpaperServiceRepository)
}

private  const val baseURL= "https://pixabay.com/"
fun providerRetrofit():Retrofit=Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(baseURL).build()

fun providerWallpaperService(retrofit: Retrofit):WallpeperService=
    retrofit.create(WallpeperService::class.java)

