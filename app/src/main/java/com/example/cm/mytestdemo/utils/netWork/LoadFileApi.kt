package com.example.cm.mytestdemo.utils.netWork

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Date: 2018/3/2 14:51
 * Email: luojie@cmcm.com
 * Author: luojie
 * Description: TODO 下载文件的对象
 */

interface LoadFileApi {

    @GET
    fun loadPdfFile(@Url fileUrl: String): Call<ResponseBody>
}
