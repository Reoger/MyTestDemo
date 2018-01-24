package com.example.cm.mytestdemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import com.example.cm.mytestdemo.base.BaseActivity
import com.example.cm.mytestdemo.user.view.LoginActivity


class MainActivity : BaseActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun setActionBar() {
       setActivityTitle("demo1")
    }

    override fun initView() {


        setMenu(R.menu.menu_main,  Toolbar.OnMenuItemClickListener{
            when(it.itemId){
                R.id.action_setting -> Log.d(TAG,"点击了测试")
                R.id.action_copy -> Log.d(TAG,"点击了copy")
                else ->    Log.d(TAG,"点击了跳转")
            }
            true
        })

        setRight("helo", View.OnClickListener { toast("点击了")
        openActivity(LoginActivity::class.java)
        })
    }



}
