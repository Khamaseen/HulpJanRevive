package com.example.hulpjanrevive

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(context: Context, private var data: List<Int>): RecyclerView.Adapter<MainViewHolder>() {

    private var inflater: LayoutInflater = LayoutInflater.from(context)
    private var dataList: List<Int> = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val itemView = inflater.inflate(R.layout.main_list_item, parent, false)
        return MainViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.setData(dataList[position])
    }

    fun setData(list: List<Int>) {
        dataList = list
        notifyDataSetChanged()
    }

}


