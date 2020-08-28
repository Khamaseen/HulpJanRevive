package com.example.hulpjanrevive.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hulpjanrevive.R

class AvatarViewHolder(
    itemView: View
): RecyclerView.ViewHolder(itemView){


    fun bind(listener: View.OnClickListener, data: IconResource) {
        itemView.setOnClickListener { listener }
        itemView.findViewById<ImageView>(R.id.iv_icon)?.apply {
            setImageDrawable(resources.getDrawable(data.icon))
        }
        itemView.findViewById<TextView>(R.id.tv_icon)?.apply {
            text = resources.getText(data.description)
        }
    }

}