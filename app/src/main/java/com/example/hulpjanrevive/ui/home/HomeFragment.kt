package com.example.hulpjanrevive.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hulpjanrevive.R
import com.example.hulpjanrevive.maincomponents.ComponentInjector
import com.example.hulpjanrevive.maincomponents.MainActivity
import com.example.hulpjanrevive.ui.DatePickerFragment
import com.example.hulpjanrevive.ui.TaskAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels {
        ComponentInjector.provideMainViewModelFactory(requireContext())
    }
    private lateinit var adapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).activateSupportActionBar()

        bordered_view.text = "12 uur"
        bordered_view.setTimeRemaining()

        context?.let {
            adapter =
                TaskAdapter(it, listOf<Int>(2, 3))
            recycler_view.adapter = adapter
            recycler_view.layoutManager = LinearLayoutManager(it)
        }

        viewModel.liveTasks.observe(viewLifecycleOwner) { list ->
            setListOnAdapter(list)
        }
        add_new.setOnClickListener { openDateDialogFragment() }

    }

    private fun openDateDialogFragment() {
        activity?.supportFragmentManager?.let { DatePickerFragment()
            .show(it, "datePicker") }
    }

    private fun setListOnAdapter(list: List<Int>) {
        adapter.setData(list)
    }

}