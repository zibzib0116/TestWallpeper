package com.example.walpepers.viewmoduls

import android.app.Application
import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.RectF
import android.graphics.drawable.BitmapDrawable
import android.service.wallpaper.WallpaperService
import android.util.DisplayMetrics
import android.util.Size
import android.util.SizeF
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.Coil
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ViewFullSreenModel(var context:Application):ViewModel() {
    private  fun  getImage(url:String): Deferred<Bitmap> = viewModelScope.async {
        var loade = ImageLoader(context.applicationContext)
        var request = ImageRequest.Builder(context.applicationContext)
            .data(url).allowHardware(false).build()
        var result = (loade.execute(request) as SuccessResult).drawable
        var bitmap = (result as BitmapDrawable).bitmap
        return@async bitmap
    }



    fun setWalpeper(url:String, metrics: Size){
        var manager = WallpaperManager.getInstance(context.applicationContext)
        ImageLoader(context.applicationContext)
        viewModelScope.launch {
        manager.setBitmap(getImage(url).await())}
    }

}