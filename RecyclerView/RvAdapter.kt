package com.example.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.item_layout.view.*
import android.widget.RelativeLayout
import android.widget.Toast


class RvAdapter(var date : List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var contxt: Context? = null;
    //获得事件回调接口
    var item: OnItemClickListener? =null
    //初始化数据


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType==1){
            val  inflate = from(parent.context).inflate(R.layout.item_layout, null)
            return MyHolder(inflate)
        }else{
            val inflate = from(parent.context).inflate(R.layout.item_layout, null)
            return MyHolder2(inflate)
        }

    }



    lateinit var mOnItemClickListener:OnItemClickListener


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is MyHolder){
            holder.bind(date[position])
        }else if(holder is MyHolder2){
            holder.bind(date[position])
        }
        holder.itemView.setOnClickListener {
            item!!.OnItemClickListener(holder.itemView ,position)
        }


        }



    override fun getItemCount(): Int {
        return date.size
    }

    override fun getItemViewType(position: Int): Int {
        when(position){
            //多布局
            in 1..2 ->
                return 1
            else -> return super.getItemViewType(position)
        }
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(date: String){
            itemView.tv_name.text=date
            itemView.tv_class.text=date
            itemView.tv_time.text=date
        }
    }

    class MyHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(date: String){
            itemView.tv_content.text=date
            itemView.tv_name.text=date
        }
    }



}

