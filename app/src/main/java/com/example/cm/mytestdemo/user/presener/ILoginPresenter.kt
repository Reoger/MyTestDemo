package com.example.cm.mytestdemo.user.presener

/**
 * Created by CM on 2018/1/24.
 */
interface ILoginPresenter {
    fun doLogin(str:String,password:String)
    fun loginResult(res: String)
}