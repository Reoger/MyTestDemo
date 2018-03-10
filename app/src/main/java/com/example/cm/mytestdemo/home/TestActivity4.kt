package com.example.cm.mytestdemo.home

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.widget.ProgressBar
import android.widget.TextView
import com.example.cm.mytestdemo.R
import com.example.cm.mytestdemo.base.BaseActivity
import com.example.cm.mytestdemo.utils.downloader.bean.FileInfo
import com.example.cm.mytestdemo.utils.downloader.service.DownloadService
import com.example.cm.mytestdemo.utils.downloader.until.DownTask
import com.example.cm.mytestdemo.utils.log.TLog
import kotlinx.android.synthetic.main.activity_test4.*
import me.jessyan.progressmanager.ProgressListener
import me.jessyan.progressmanager.ProgressManager
import me.jessyan.progressmanager.body.ProgressInfo




/**
 * Date: 2018/3/9 20:38
 * Email: luojie@cmcm.com
 * Author: luojie
 * Description: TODO
 */

class TestActivity4 : BaseActivity(){


    var mReceiver : BoradCastReceiverTest?= null
    private var mLastDownloadingInfo: ProgressInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test4)
    }


    override fun setActionBar() {
        setActivityTitle("娶个什么名字啊")

        val manager = LocalBroadcastManager.getInstance(this)
        manager.registerReceiver(mReceiver, IntentFilter(DownloadService.ACTION_UPDATE))
//        registerReceiver(mReceiver, IntentFilter(""))
    }

    override fun initView() {
        progress.max = 100

        mReceiver = BoradCastReceiverTest(this.text_progress, this.progress)
        val url = "http://dldir1.qq.com/weixin/android/weixin6316android780.apk"
        val fileInfo = FileInfo(0, url, "WeChat", 0, 0)

        but_start_test.setOnClickListener({
            TLog.d("点击了")
            val intent = Intent(this@TestActivity4, DownloadService::class.java)
            intent.action = DownloadService.ACTION_START
            intent.putExtra(DownloadService.EXTRE_INFO, fileInfo)
            startService(intent)
        })


        but_stop_test.setOnClickListener({
            val intent = Intent(this@TestActivity4, DownloadService::class.java)
            intent.action = DownloadService.ACTION_PAUSE
            intent.putExtra(DownloadService.EXTRE_INFO, fileInfo)
            startService(intent)
        })




        but_start_test2.setOnClickListener({
            ProgressManager.getInstance().addResponseListener(
                    url,
                    object : ProgressListener {
                        @SuppressLint("SetTextI18n")
                        override fun onProgress(progressInfo: ProgressInfo) {
                            if (mLastDownloadingInfo == null) {
                                mLastDownloadingInfo = progressInfo
                            }
                            if (progressInfo.id < mLastDownloadingInfo!!.id) {
                                return
                            } else if (progressInfo.id >  mLastDownloadingInfo!!.id) {
                                mLastDownloadingInfo = progressInfo
                            }

                            val progress = mLastDownloadingInfo!!.percent
                            text_progress2.text = "当前进度"+progress.toString()
                            progress2.progress = progress
                        }

                        override fun onError(id: Long, e: Exception) {

                        }
                    }
            )
        })
    }

    override fun onDestroy() {
        super.onDestroy()
//        unregisterReceiver(mReceiver)
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver)
    }

    class BoradCastReceiverTest(text_progress:TextView, progress:ProgressBar) : BroadcastReceiver(){
        private var text_progress:TextView ?= null
        private var progress:ProgressBar ?= null

        init {
            this.text_progress = text_progress
            this.progress = progress
        }
        @SuppressLint("SetTextI18n")
        override fun onReceive(context: Context?, intent: Intent?) {
            //更新Ui
            if (DownloadService.ACTION_UPDATE==intent?.action){
                val prp = intent.getLongExtra(DownTask.BROAD_FINISH,0)
                val id = intent.getIntExtra(DownTask.BROAD_ID,0)
                text_progress?.text = id.toString()+"进度："+prp.toString()
                progress?.progress = prp.toInt()
            }
        }

    }



}