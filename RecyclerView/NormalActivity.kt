package com.example.RecyclerView

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import me.drakeet.multitype.MultiTypeAdapter

class NormalActivity : MenuBaseActivity() {

    private lateinit var adapter: MultiTypeAdapter
    private lateinit var items: MutableList<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val recyclerView = findViewById<RecyclerView>(R.id.list)


        adapter = MultiTypeAdapter()
        adapter.register(TextItemViewBinder())
        adapter.register(ImageItemViewBinder())
        adapter.register(RichItemViewBinder())
        recyclerView.adapter = adapter


        items = ArrayList()
        val textItem = TextItem("标题")
        val imageItem = ImageItem(R.mipmap.img_1)
        val richItem = RichItem("内容", R.drawable.img_11)


        for (i in 0..19) {
            items.add(textItem)
            items.add(imageItem)
            items.add(richItem)
        }
        adapter.items = items
        adapter.notifyDataSetChanged()
    }


}

