package com.example.hulpjanrevive.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hulpjanrevive.R

class TaskAdapter(context: Context, private var data: List<Int>): RecyclerView.Adapter<TaskViewHolder>() {

    private var inflater: LayoutInflater = LayoutInflater.from(context)
    private var dataList: List<Int> = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {

        val itemView = inflater.inflate(R.layout.main_list_item, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.setData(dataList[position])
    }

    fun setData(list: List<Int>) {
        dataList = list
        notifyDataSetChanged()
    }

}


