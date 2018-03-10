//package com.example.cm.mytestdemo.home.view;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.util.Log;
//
//import me.jessyan.progressmanager.ProgressListener;
//import me.jessyan.progressmanager.ProgressManager;
//import me.jessyan.progressmanager.body.ProgressInfo;
//
///**
// * Date: 2018/3/10 13:04
// * Email: luojie@cmcm.com
// * Author: luojie
// * Description: TODO
// */
//public class test extends Activity {
//
//
//    private ProgressInfo mLastDownloadingInfo;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        String url = "";
//        ProgressManager.getInstance().addResponseListener(
//                url,
//                new ProgressListener(){
//
//                    @Override
//                    public void onProgress(ProgressInfo progressInfo) {
//                        // 如果你不屏蔽用户重复点击上传或下载按钮,就可能存在同一个 Url 地址,上一次的上传或下载操作都还没结束,
//                        // 又开始了新的上传或下载操作,那现在就需要用到 id(请求开始时的时间) 来区分正在执行的进度信息
//                        // 这里我就取最新的下载进度用来展示,顺便展示下 id 的用法
//
//                        if (mLastDownloadingInfo == null) {
//                            mLastDownloadingInfo = progressInfo;
//                        }
//
//                        //因为是以请求开始时的时间作为 Id ,所以值越大,说明该请求越新
//                        if (progressInfo.getId() < mLastDownloadingInfo.getId()) {
//                            return;
//                        } else if (progressInfo.getId() > mLastDownloadingInfo.getId()) {
//                            mLastDownloadingInfo = progressInfo;
//                        }
//
//                        int progress = mLastDownloadingInfo.getPercent();
//                        mDownloadProgress.setProgress(progress);
//                        mDownloadProgressText.setText(progress + "%");
//                        Log.d(TAG, "--Download-- " + progress + " %  " + mLastDownloadingInfo.getSpeed() + " byte/s  " + mLastDownloadingInfo.toString());
//                        if (mLastDownloadingInfo.isFinish()) {
//                            //说明已经下载完成
//                            Log.d(TAG, "--Download-- finish");
//                        }
//                    }
//
//                    @Override
//                    public void onError(long id, Exception e) {
//
//                    }
//                }
//        );
//    }
//}
