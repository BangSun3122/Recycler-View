package com.example.RecyclerView

import android.graphics.Bitmap
import android.util.SparseArray
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    /** 用于存储当前item当中的View  */
    private val mViews: SparseArray<View>

    init {
        mViews = SparseArray<View>()
    }

    fun <T : View> findView(ViewId: Int): T {
        var view = mViews.get(ViewId)
        //集合中没有，则从item当中获取，并存入集合当中
        if (view == null) {
            view = itemView.findViewById(ViewId)
            mViews.put(ViewId, view)
        }
        return view as T
    }

    fun setText(viewId: Int, text: String): RecycleHolder {
        val tv = findView<TextView>(viewId)
        tv.setText(text)
        return this
    }

    fun setText(viewId: Int, text: Int): RecycleHolder {
        val tv = findView<TextView>(viewId)
        tv.setText(text)
        return this
    }

    fun setImageResource(viewId: Int, ImageId: Int): RecycleHolder {
        val image = findView<ImageView>(viewId)
        image.setImageResource(ImageId)
        return this
    }

    fun setImageBitmap(viewId: Int, bitmap: Bitmap): RecycleHolder {
        val image = findView<ImageView>(viewId)
        image.setImageBitmap(bitmap)
        return this
    }

    fun setImageNet(viewId: Int, url: String): RecycleHolder {
        val image = findView<ImageView>(viewId)
        //使用你所用的网络框架等
        return this
    }
}
