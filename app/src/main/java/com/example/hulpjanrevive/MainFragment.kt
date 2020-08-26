package com.example.hulpjanrevive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels {
        ComponentInjector.provideMainViewModelFactory(requireContext())
    }
    private lateinit var adapter: MainAdapter

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

        viewModel.liveTasks.observe(viewLifecycleOwner) { list ->
            setListOnAdapter(list)
        }
        add_new.setOnClickListener { addNumber331() }
//        add_new.setOnClickListener { openDateDialogFragment() }

    }

    private fun openDateDialogFragment() {
        activity?.supportFragmentManager?.let { DatePickerFragment().show(it, "datePicker") }
    }

    private fun setListOnAdapter(list: List<Int>) {
        adapter.setData(list)
    }

    private fun addNumber331() {
        viewModel.addNumber()
    }

}