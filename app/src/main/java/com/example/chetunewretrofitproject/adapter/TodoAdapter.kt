package com.example.chetunewretrofitproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.databinding.CustomLayoutTodoViewBinding
import com.example.chetunewretrofitproject.model.TodosListItem

class TodoAdapter(private val todoList: List<TodosListItem>):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
    class TodoViewHolder(val binding: CustomLayoutTodoViewBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding:CustomLayoutTodoViewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.custom_layout_todo_view,parent,false)
        return TodoViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val listTodo = todoList[position]
        holder.binding.apply {
            todoId.text = listTodo.id.toString()
            todoTitle.text = listTodo.title
        }
    }
}