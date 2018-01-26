package com.example.cm.mytestdemo.user.model

import com.google.gson.annotations.SerializedName

/**
 * Created by CM on 2018/1/26.
 */
data class RegisterInfo(
        @SerializedName("code") var code: Int, //2000
        @SerializedName("message") var message: String, //登陆成功
        @SerializedName("data") var data: RegisterData
)