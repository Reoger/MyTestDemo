package com.example.cm.mytestdemo.user.view

import com.example.cm.mytestdemo.user.model.RegisterInfo
import com.example.cm.mytestdemo.utils.netWork.ApiErrorModel

/**
 * Created by CM on 2018/1/26.
 */
interface IRegisterView{
    fun registerSuccessful(registerInfo: RegisterInfo)
    fun registerDenial(registerInfo: RegisterInfo)
    fun registerFail(statusCode: Int, apiErrorModel: ApiErrorModel)
}