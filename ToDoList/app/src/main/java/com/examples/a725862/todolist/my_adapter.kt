package com.examples.a725862.todolist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by 725862 on 24/10/18.
 */

class MyAdapter(private val dataset: MutableList<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val textView: LinearLayout) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val textView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.text_view, parent, false) as LinearLayout

        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        val view1 = holder?.textView?.getChildAt(1) as LinearLayout
        val view2 = view1.getChildAt(0) as TextView
        view2.text = dataset[position]
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}