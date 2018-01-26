package com.example.cm.mytestdemo

import android.app.Application
import com.example.cm.mytestdemo.utils.netWork.ApiClient

/**
 * Created by CM on 2018/1/25.
 */
class App : Application()  {

    companion object {
        val instance: App by lazy { App() }
    }
    //App.instance 获得单例模式
    override fun onCreate() {
        super.onCreate()
        ApiClient.instance.init()
    }
}