package com.example.hulpjanrevive.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hulpjanrevive.R

class AvatarAdapter(
    private val context: Context,
    private val listener: View.OnClickListener
) : RecyclerView.Adapter<AvatarViewHolder>() {

    private var data: List<IconResource>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvatarViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.avatar_list_item, parent, false)
        return AvatarViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: AvatarViewHolder, position: Int) {
        data?.let {
            holder.bind(listener, it[position])
        }
    }

    fun setData(data: List<IconResource>) {
        this.data = data
        notifyDataSetChanged()
    }

}