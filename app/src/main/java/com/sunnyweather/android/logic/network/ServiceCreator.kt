package com.sunnyweather.android.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 单例Retrofit构建器
object ServiceCreator {
    private const val BASE_URL = "https://api.caiyunapp.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // 显式创建实例
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    // 隐式创建实例
    inline fun <reified T> create(): T = create(T::class.java)
}