package com.example.cm.mytestdemo.user.view

import android.os.Bundle
import com.example.cm.mytestdemo.R
import com.example.cm.mytestdemo.base.BaseActivity
import com.example.cm.mytestdemo.user.model.RegisterData
import com.example.cm.mytestdemo.user.model.RegisterInfo
import com.example.cm.mytestdemo.user.presener.IRegisterPresenter
import com.example.cm.mytestdemo.user.presener.RegisterPresenter
import com.example.cm.mytestdemo.utils.netWork.ApiErrorModel
import kotlinx.android.synthetic.main.activity_register.*


/**
 * Created by CM on 2018/1/26.
 *
 */
class RegisterActivity: BaseActivity(),IRegisterView{


    override fun registerSuccessful(registerInfo: RegisterInfo) {
        log("注册成功")
        toast("注册成功")

    }

    override fun registerDenial(registerInfo: RegisterInfo) {
        log("注册拒绝")
        toast("注册拒绝")
    }

    override fun registerFail(statusCode: Int, apiErrorModel: ApiErrorModel) {
        log("注册失败")
        toast("注册失败")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    override fun setActionBar() {
        setActivityTitle("注册")
    }

    override fun initView() {
        val presenter:IRegisterPresenter = RegisterPresenter(RegisterActivity@this,this)

        register_do.setOnClickListener({
            val a = RegisterData(register_name.text.toString(),register_password.text.toString(),register_nickname.text.toString(),register_birthday.text.toString(),
                    register_email.text.toString(),register_introduction.text.toString())
            presenter.doRegister(a)
        })
    }

}