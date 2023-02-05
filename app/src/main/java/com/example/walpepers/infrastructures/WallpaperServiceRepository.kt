package com.example.walpepers.infrastructures

import com.example.walpepers.data.WallpaperResponce

class WallpaperServiceRepository(private val wallpaperService: WallpeperService) {
    suspend fun getWallpaper():WallpaperResponce{
        return wallpaperService.getWallpeper(category = "")
    }
}