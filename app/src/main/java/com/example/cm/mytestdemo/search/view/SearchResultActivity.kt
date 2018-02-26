package com.example.cm.mytestdemo.search.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.cm.mytestdemo.R
import com.example.cm.mytestdemo.base.BaseActivity
import com.example.cm.mytestdemo.home.model.Match
import com.example.cm.mytestdemo.home.model.Query
import com.example.cm.mytestdemo.home.model.ResultBySearchContent
import com.example.cm.mytestdemo.home.model.SearchByContentBean
import com.example.cm.mytestdemo.search.adapter.SearchResultAdapter
import com.example.cm.mytestdemo.utils.netWork.ApiClient
import com.example.cm.mytestdemo.utils.netWork.ApiErrorModel
import com.example.cm.mytestdemo.utils.netWork.ApiResponse
import com.example.cm.mytestdemo.utils.netWork.NetworkScheduler
import kotlinx.android.synthetic.main.activity_search_result.*

/**
 * Created by CM on 2018/2/1.
 */

class SearchResultActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

    }

    override fun setActionBar() {
        setActivityTitle("搜索结果")
    }

    override fun initView() {
        val adapter = SearchResultAdapter(this)
        recycler_search_result.adapter = adapter
        recycler_search_result.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
//        val data = intent.getSerializableExtra("test") as ResultBySearchContent
        val data  = intent.getStringExtra("test")
        tv_search.text = data
//        if (data != null) {
//            adapter.setData(data.hits?.hits)
//        }else{
//            Log.d("debug","老的的是")
//        }


                ApiClient.instance.service.searchByContent(SearchByContentBean(0,10, Query(Match(data))))
                .compose(NetworkScheduler.compose())
                .subscribe(object : ApiResponse<ResultBySearchContent>(context = this){
                    override fun success(data: ResultBySearchContent) {
                        Log.d("TAG","${data.took} == ${data.hits.total} =="+data.timedOut)
                        adapter.setData(data.hits.hits)
                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        Log.d("TAG","$apiErrorModel 加载失败")
                    }
                })

    }

}