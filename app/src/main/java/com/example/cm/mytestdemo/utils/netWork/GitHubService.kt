package com.example.cm.mytestdemo.utils.netWork

import com.example.cm.mytestdemo.bean.Repo
import com.example.cm.mytestdemo.user.model.LoginInfo
import com.example.cm.mytestdemo.user.model.RegisterInfo
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*

/**
 * Created by CM on 2018/1/25.
 */
interface GitHubService{
    //请添加相应的`API`调用方法
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Observable<List<Repo>> //每个方法的返回值即一个Observable

    @FormUrlEncoded
    @POST("userMaster/api/login.php")
    fun login(@Field("user") user:String,@Field("passwd") passwd: String ): Observable<LoginInfo>

    @FormUrlEncoded
    @POST("userMaster/api/register.php")
    fun register(@Field("user_name")user:String,@Field("user_passwd")passwd: String,@Field("nickname")nickname:String,@Field("user_birthday")user_birthday:String
    ,@Field("user_email")user_email:String,@Field("user_introduction")user_introduction:String): Observable<RegisterInfo>

}
