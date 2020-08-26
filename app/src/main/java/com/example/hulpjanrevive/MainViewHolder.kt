package com.example.hulpjanrevive

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {

    /**
     * If this viewholder would hold the data, then onClick could open a fragment
     * showing the appropriate appointment. / action.
     *
     * Opening the fragment would be done with the NavController. The NavController, however lives
     * in main.
     *
     * The onClick should send a message, using a callback, to the MainFragment. The MainFragment
     * could then forward this in the correct way forward.
     */

    init {
        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)
    }

    override fun onClick(view: View?) {
        view?.findViewById<TextView>(R.id.title)?.text = "clicked"
    }

    override fun onLongClick(view: View?): Boolean {
        TODO("Not yet implemented")
    }

    fun setData(data: Int) {
        itemView.findViewById<TextView>(R.id.title)?.text = "New Title"
        itemView.findViewById<TextView>(R.id.description)?.text = "Description"
    }

}