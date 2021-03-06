package com.example.cm.mytestdemo.utils.netWork

import com.example.cm.mytestdemo.BuildConfig
import me.jessyan.progressmanager.ProgressManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory



/**
 * Created by CM on 2018/1/25.
 *
 */
class ApiClient  private constructor(){
    lateinit var service: GitHubService

    private object Holder {
        val INSTANCE = ApiClient()
    }

    companion object {
        val instance by lazy { Holder.INSTANCE }
    }

    fun init() {  //构建OkHttpClient 时,将 OkHttpClient.Builder() 传入 with() 方法,进行初始化配置
        val okHttpClient = ProgressManager.getInstance().with(OkHttpClient.Builder())
                //输入http连接时的log，也可添加更多的Interceptor
                .addInterceptor(HttpLoggingInterceptor().setLevel(
                        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                        else HttpLoggingInterceptor.Level.NONE
                ))
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://10.12.198.21:9200/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()

        service = retrofit.create(GitHubService::class.java)
    }

}