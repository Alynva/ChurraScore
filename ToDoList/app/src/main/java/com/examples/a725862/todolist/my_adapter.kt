package com.examples.a725862.todolist

import android.content.Context
import android.os.Build
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.text_view.view.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

/**
 * Created by 725862 on 24/10/18.
 */

class MyAdapter(val context: Context, val dataset: MutableList<MyTask>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val textView: LinearLayout) : RecyclerView.ViewHolder(textView) {
        fun bindView(context: Context, task: MyTask, clickListenerBtn: ((task:MyTask, index: Int) -> Unit)?) {
            textView.tvNome.text = task.title
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val current = LocalDateTime.now()

                val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                val formatted = current.format(formatter)
                textView.tvTelefone.text = formatted
            }

            if (clickListenerBtn != null) {
                itemView.btn_done.setOnClickListener {
                    clickListenerBtn.invoke(task, adapterPosition)
                }
            }
        }
    }

    //salva a função do clique no item
    var clickListener: ((task:MyTask, index: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val textView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.text_view, parent, false) as LinearLayout

        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.bindView(context, dataset[position], clickListener)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    //configuração a função de clique nos itens
    fun setOnItemClickListenerOnBtn(clique: ((task:MyTask, index: Int) -> Unit)){
        this.clickListener = clique
    }
}