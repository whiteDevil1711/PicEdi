package com.example.photoeditor.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {

    protected abstract val layoutId: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (layoutId == 0) {
            throw IllegalArgumentException("Invalid layout id")
        }
        return inflater.inflate(layoutId, container, false)
    }
}
