package com.example.cm.mytestdemo



import android.os.Bundle
import com.example.cm.mytestdemo.base.BaseActivity
import com.example.cm.mytestdemo.bean.Repo
import com.example.cm.mytestdemo.utils.netWork.ApiClient
import com.example.cm.mytestdemo.utils.netWork.ApiErrorModel
import com.example.cm.mytestdemo.utils.netWork.ApiResponse
import com.example.cm.mytestdemo.utils.netWork.NetworkScheduler
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.kotlin.bindToLifecycle
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import kotlinx.android.synthetic.main.activity_test.*

/**
 * Created by CM on 2018/1/25.
 */
class TestActivity: BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    }
    override fun setActionBar() {
        setActivityTitle("网络请求测试")
    }

    override fun initView() {
        test_button.setOnClickListener({
            doNetwork()
        })
    }

    private fun doNetwork() {
        ApiClient.instance.service.listRepos(input_text.text.toString())   //GitHubService中的方法
                .compose(NetworkScheduler.compose())                      //线程切换处理
                .bindUntilEvent(this,ActivityEvent.DESTROY)         //绑定生命周期
                .subscribe(object : ApiResponse<List<Repo>>(this) {       //对象表达式约等于Java中的匿名内部类
                    override fun success(data: List<Repo>) {              //请求成功，此处显示一些返回的数据
                        user_name.text = data[0].owner.login
                        user_package.text = data[0].name
                        user_des.text = data[0].description
                        user_url.text = data[0].html_url
                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) { //请求失败，此处直接显示Toast
//                        Toast.makeText(this@MainActivity, apiErrorModel.message, Toast.LENGTH_SHORT).show()
                        log(apiErrorModel.message)
                    }
                })

    }


}