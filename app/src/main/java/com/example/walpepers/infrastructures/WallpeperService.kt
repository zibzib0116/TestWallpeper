package com.example.walpepers.infrastructures

import com.example.walpepers.data.WallpaperResponce
import retrofit2.http.GET
import retrofit2.http.Path

interface WallpeperService {

    @GET("&category={category}&page={page}&orientation=vertical")
    suspend fun getWallpeper(
        @Path(value="category" )category:String ,
        @Path(value = "page")page:Int=1):WallpaperResponce
}