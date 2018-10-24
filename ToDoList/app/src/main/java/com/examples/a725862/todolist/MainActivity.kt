package com.examples.a725862.todolist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.util.Log.DEBUG
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    var dataset : MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(dataset)

        recyclerView = rvTaks.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        btn_add_task.setOnClickListener {
            btn_add_task_handle()
        }
    }

    private fun btn_add_task_handle() {

        dataset.add("Oie")
        viewAdapter.notifyDataSetChanged()
        Log.e("Oie", "Nothing")
    }
}
