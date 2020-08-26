package com.example.hulpjanrevive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment() {

    private lateinit var adapter: RecyclerView.Adapter<MainViewHolder>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bordered_view.text = "12 uur"
        bordered_view.setTimeRemaining()

        context?.let {
            adapter = MainAdapter(it, listOf<Int>(2, 3))
            recycler_view.adapter = adapter
            recycler_view.layoutManager = LinearLayoutManager(it)
        }
    }

}