package com.example.cm.mytestdemo.user.presener

import com.example.cm.mytestdemo.user.model.RegisterData
import com.example.cm.mytestdemo.user.model.RegisterInfo
import com.example.cm.mytestdemo.user.view.IRegisterView
import com.example.cm.mytestdemo.utils.netWork.ApiClient
import com.example.cm.mytestdemo.utils.netWork.ApiErrorModel
import com.example.cm.mytestdemo.utils.netWork.ApiResponse
import com.example.cm.mytestdemo.utils.netWork.NetworkScheduler
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.kotlin.bindUntilEvent


/**
 * Created by CM on 2018/1/26.
 */
class RegisterPresenter(var mContext: RxAppCompatActivity, var mRegisterView: IRegisterView):IRegisterPresenter{

    override fun doRegister(registerData: RegisterData) {
        ApiClient.instance.service.register(registerData.user_name, registerData.user_passwd,registerData.nickname,registerData.user_birthday,registerData.user_email,registerData.user_introduction)
                .compose(NetworkScheduler.compose())
                .bindUntilEvent(mContext, event = ActivityEvent.DESTROY)
                .subscribe(object : ApiResponse<RegisterInfo>(mContext) {
                    override fun success(data: RegisterInfo) {
                        data?.apply {
                            if(this.code== 2000){
                                mRegisterView.registerSuccessful(registerInfo = data)
                            }else{
                                mRegisterView.registerDenial(registerInfo = data)
                            }
                        }
                    }
                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        mRegisterView.registerFail(statusCode,apiErrorModel)
                    }
                })
    }

}