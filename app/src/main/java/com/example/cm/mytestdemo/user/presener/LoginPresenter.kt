package com.example.cm.mytestdemo.user.presener

import android.content.Context
import android.util.Log
import com.example.cm.mytestdemo.user.view.ILoginView
import com.example.cm.mytestdemo.user.view.LoginActivity

/**
 * Created by CM on 2018/1/24
 * 采用mvp架构
 * .
 */

class LoginPresenter(mContext: Context) : ILoginPresenter {
    var longview :ILoginView?=null

    override fun doLogin(str:String,password:String) {
        Log.d("TAG","进入了doLogin方法")
//        Thread(Runnable { Thread.sleep(1000)
            if(str.equals("reoger")&&password.equals("123456")){
                longview?.loginResult(1,"登录成功")
            }else
                longview?.loginResult(-1,"登录失败")
//        })

    }

    override fun loginResult(res: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    init {
        this.longview = LoginActivity()
        Log.d("debug","进入了构造方法")

    }

}