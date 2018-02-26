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
class DocumentFragment : BaseFragment(){

    companion object {
        fun getInstance():DocumentFragment{
            return Inner.documentFragment
        }
    }

    private object Inner{
        val documentFragment = DocumentFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view : View = inflater!!.inflate(R.layout.fragment_document,container,false)
        return view
    }
}