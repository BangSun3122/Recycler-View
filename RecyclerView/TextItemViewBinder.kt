package com.example.RecyclerView

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import me.drakeet.multitype.ItemViewBinder

class TextItemViewBinder : ItemViewBinder<TextItem, TextItemViewBinder.TextHolder>() {

    private var lastShownAnimationPosition: Int = 0

    class TextHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): TextHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_text, parent, false)
        val holder = TextHolder(view)
        holder.text.setOnClickListener {  text->
            Toast.makeText(text.context, "进入内容" , Toast.LENGTH_SHORT).show()
            val intent = Intent(text.context,PostActivity::class.java)
            text.context.startActivity(intent)
        }
        return holder
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: TextHolder, item: TextItem) {
        holder.text.text = "用户名: " + item.text
        setAnimation(holder.itemView, holder.adapterPosition)



    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > lastShownAnimationPosition) {
            viewToAnimate.startAnimation(AnimationUtils.loadAnimation(viewToAnimate.context, android.R.anim.slide_in_left))
            lastShownAnimationPosition = position
        }
    }

    override fun onViewDetachedFromWindow(holder: TextHolder) {
        holder.itemView.clearAnimation()
    }

}