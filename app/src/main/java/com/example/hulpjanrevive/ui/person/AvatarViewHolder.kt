package com.example.hulpjanrevive.ui.person

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hulpjanrevive.R
import com.example.hulpjanrevive.ui.IconResource

class AvatarViewHolder(
    itemView: View
): RecyclerView.ViewHolder(itemView){

    private lateinit var data: IconResource

    fun bind(listener: (IconResource) -> Unit, data: IconResource) {
        this.data = data
        itemView.setOnClickListener {
            listener(data)
        }
        itemView.findViewById<ImageView>(R.id.iv_icon)?.apply {
            setImageDrawable(resources.getDrawable(data.icon))
        }
        itemView.findViewById<TextView>(R.id.tv_icon)?.apply {
            text = resources.getText(data.description)
        }
    }

}