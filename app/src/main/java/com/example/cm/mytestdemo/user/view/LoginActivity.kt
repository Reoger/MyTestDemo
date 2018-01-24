package com.example.cm.mytestdemo.user.view

import android.os.Bundle

import com.example.cm.mytestdemo.R
import com.example.cm.mytestdemo.base.BaseActivity
import com.example.cm.mytestdemo.user.presener.ILoginPresenter
import com.example.cm.mytestdemo.user.presener.LoginPresenter
import com.example.cm.mytestdemo.utils.loadingUtils.LoadingDialog
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by CM on 2018/1/24.
 *
 */
class LoginActivity : BaseActivity(),ILoginView{


    override fun loginResult(code: Int, des: String) {

        if(code==1){
            log("登录成功")
//            toast(des)
        }else{
            log("登录失败")
//            toast(des)
        }

stopLoad()
        log("取消 进度条"+dialog?.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


    }
    override fun setActionBar() {
        setActivityTitle("用户登录")
    }

    override fun initView() {

        val presenter: ILoginPresenter = LoginPresenter(this)

        button_login.setOnClickListener({
           startLoad()
//            show()
//            presenter.doLogin(edit_username.text?.toString()!!,edit_password.text?.toString()!!)

           Thread(Runnable { Thread.sleep(1000)
               loginResult(1,"test") })
        })
    }

    var dialog2: LoadingDialog?= null

    fun show(){
        dialog2 = LoadingDialog(this, "加载")
        dialog2?.show()
    }

    fun close(){
        dialog2?.close()
    }


}