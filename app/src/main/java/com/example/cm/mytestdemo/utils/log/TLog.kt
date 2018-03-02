package com.example.cm.mytestdemo.utils.log

import android.text.TextUtils
import android.util.Log

/**
 * Date: 2018/3/2 14:48
 * Email: luojie@cmcm.com
 * Author: luojie
 * Description: TODO
 * 日志相关的类，这里后面还是需要修改
 */

object TLog {
    private val LOG_TAG = "superFileLog"
    private val DEBUG = true

    @JvmStatic
    fun e(log: String) {
        if (DEBUG && !TextUtils.isEmpty(log)) Log.e(LOG_TAG, "" + log)
    }

    fun i(log: String) {
        if (DEBUG && !TextUtils.isEmpty(log)) Log.i(LOG_TAG, log)
    }

    fun i(tag: String, log: String) {
        if (DEBUG && !TextUtils.isEmpty(tag) && !TextUtils.isEmpty(log)) Log.i(tag, log)
    }

    @JvmStatic
    fun d(tag: String, log: String) {
        if (DEBUG && !TextUtils.isEmpty(tag) && !TextUtils.isEmpty(log)) Log.d(tag, log)
    }

    @JvmStatic
    fun d(log: String) {
        if (DEBUG && !TextUtils.isEmpty(log)) Log.d(LOG_TAG, log)
    }

    fun e(tag: String, log: String) {
        if (DEBUG && !TextUtils.isEmpty(tag) && !TextUtils.isEmpty(log)) Log.e(tag, log)
    }


}
