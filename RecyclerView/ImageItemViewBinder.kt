package com.example.RecyclerView

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import me.drakeet.multitype.ItemViewBinder

class ImageItemViewBinder : ItemViewBinder<ImageItem, ImageItemViewBinder.ImageHolder>() {

    inner class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ImageHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)
        val holder = ImageHolder(view)
        holder.image.setOnClickListener{image->
            Toast.makeText(image.context,"转向个人页", Toast.LENGTH_SHORT).show()
            val intent = Intent(image.context,PageActivity::class.java)
            image.context.startActivity(intent)
        }
        return holder

    }

    override fun onBindViewHolder(holder: ImageHolder, item: ImageItem) {
        holder.image.setImageResource(item.resId)
    }
}