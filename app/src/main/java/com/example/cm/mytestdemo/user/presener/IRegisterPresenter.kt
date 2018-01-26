package com.example.cm.mytestdemo.user.presener

import com.example.cm.mytestdemo.user.model.RegisterData

/**
 * Created by CM on 2018/1/26.
 */

interface IRegisterPresenter{
    fun doRegister(registerData: RegisterData)
}