package com.examples.a725862.todolist

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    var dataset : MutableList<MyTask> = mutableListOf()

    companion object {
        private const val REQUEST_NOVA_TASK = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carregaLista()

        btn_add_task.setOnClickListener {
            btn_add_task_handle()
        }
    }

    private fun carregaLista() {
        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(this, dataset)

        (viewAdapter as MyAdapter).setOnItemClickListenerOnBtn { myTask: MyTask, index: Int ->
            dataset.remove(myTask)
            viewAdapter.notifyDataSetChanged()
        }

        recyclerView = rvTaks.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_NOVA_TASK && resultCode == Activity.RESULT_OK) {
            val new_task : MyTask = data?.getSerializableExtra(AddTaskActivity.MY_TASK) as MyTask

            dataset.add(new_task)
            viewAdapter.notifyDataSetChanged()
        }
    }

    private fun btn_add_task_handle() {
        val intent = Intent(this, AddTaskActivity::class.java)
        startActivityForResult(intent, REQUEST_NOVA_TASK)
    }


}
