package com.example.walpepers.infrastructures

import com.example.walpepers.data.WallpaperResponce
import retrofit2.http.GET
import retrofit2.http.Query

interface WallpeperService {

    @GET("api")
    suspend fun getWallpeper(
        @Query(value="key" )key:String ,
        @Query(value="category" )category:String ,
        @Query(value = "page")page:Int=1,
        @Query(value = "orientation")orientation:String = "vertical"):WallpaperResponce
}