package com.example.walpepers.infrastructures

import com.example.walpepers.data.WallpaperResponce

private const val apiKey="33106230-b104905cd7ff74ed17e2229af"
class WallpaperServiceRepository(private val wallpaperService: WallpeperService) {
    suspend fun getWallpaper():WallpaperResponce{
        return wallpaperService.getWallpeper(apiKey, "")
    }
}