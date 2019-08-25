package com.example.RecyclerView

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import me.drakeet.multitype.ItemViewBinder

class RichItemViewBinder : ItemViewBinder<RichItem, RichItemViewBinder.RichHolder>() {

    class RichHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.text)
        val image: ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): RichHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_rich,
                parent,
                false
            )
        val holder =RichHolder(view)
        holder.image.setOnClickListener{image->
            Toast.makeText(image.context,"转向内容", Toast.LENGTH_SHORT).show()
            val intent = Intent(image.context,PostActivity::class.java)
            image.context.startActivity(intent)
        }
        holder.text.setOnClickListener {text->
            Toast.makeText(text.context, "转向内容" , Toast.LENGTH_SHORT).show()
            val intent = Intent(text.context,PostActivity::class.java)
            text.context.startActivity(intent)
        }
        return holder

    }

    override fun onBindViewHolder(holder: RichHolder, item: RichItem) {
        holder.text.text = item.text
        holder.image.setImageResource(item.imageResId)



    }
}