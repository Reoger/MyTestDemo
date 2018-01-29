package com.example.cm.mytestdemo.home.presenter

import android.content.Context
import android.util.Log
import com.example.cm.mytestdemo.home.model.Match
import com.example.cm.mytestdemo.home.model.Query
import com.example.cm.mytestdemo.home.model.ResultBySearchContent
import com.example.cm.mytestdemo.home.model.SearchByContentBean
import com.example.cm.mytestdemo.home.view.fragment.IHomeFragmenView
import com.example.cm.mytestdemo.utils.netWork.ApiClient
import com.example.cm.mytestdemo.utils.netWork.ApiErrorModel
import com.example.cm.mytestdemo.utils.netWork.ApiResponse
import com.example.cm.mytestdemo.utils.netWork.NetworkScheduler

/**
 * Created by CM on 2018/1/28.
 */
class HomeFragmentPresenter(var mContext:Context,var mHomeView:IHomeFragmenView): IHomeFragmentPresenter {

    override fun doSearch(str: String): Boolean {
        ApiClient.instance.service.searchByContent(SearchByContentBean(0,10, Query(Match(str))))
                .compose(NetworkScheduler.compose())
                .subscribe(object : ApiResponse<ResultBySearchContent>(context = mContext!!){
                    override fun success(data: ResultBySearchContent) {
                        Log.d("TAG","${data.took} == ${data.hits.total} =="+data.timedOut)
                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        Log.d("TAG","$apiErrorModel 加载失败")
                    }
                })
        return true
    }

}