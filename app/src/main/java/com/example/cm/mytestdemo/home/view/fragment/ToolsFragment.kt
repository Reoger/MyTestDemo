package com.example.cm.mytestdemo.home.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cm.mytestdemo.R
import com.example.cm.mytestdemo.base.BaseFragment

/**
 * Created by CM on 2018/2/1.
 */
class ToolsFragment : BaseFragment(){

    companion object {
        fun getInstance():ToolsFragment{
            return Inner.fragment
        }
    }

    private object Inner{
        val fragment = ToolsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v: View = inflater!!.inflate(R.layout.fragment_tools,container,false)
        return v
    }
}