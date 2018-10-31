package com.examples.a725862.todolist

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : AppCompatActivity() {

    companion object {
        public const val MY_TASK : String = "My task"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        btn_save.setOnClickListener {
            save()
        }
    }

    private fun save() {
        if (et_nome.text.isEmpty()) {
            Toast.makeText(this, "Campo vazio", Toast.LENGTH_SHORT).show()
            return
        }
        val new_task = MyTask(et_nome.text.toString())
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(MY_TASK, new_task)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
