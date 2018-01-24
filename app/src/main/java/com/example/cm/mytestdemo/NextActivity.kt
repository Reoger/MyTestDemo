package com.example.cm.mytestdemo

import android.os.Bundle
import com.example.cm.mytestdemo.base.BaseActivity

/**
 * Created by CM on 2018/1/23.
 *
 */
class NextActivity: BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
    }


    override fun initView() {
        setMenuId(R.menu.menu_main)
    }



    override fun setActionBar() {
        title = "hello"
    }

}