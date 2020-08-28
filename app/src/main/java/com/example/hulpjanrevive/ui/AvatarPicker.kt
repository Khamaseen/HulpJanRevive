package com.example.hulpjanrevive.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hulpjanrevive.R
import com.example.hulpjanrevive.data.util.ResourceMapper
import com.example.hulpjanrevive.maincomponents.ComponentInjector
import kotlinx.android.synthetic.main.avatar_list_item.*
import kotlinx.android.synthetic.main.fragment_avatar_dialog.*


class AvatarPicker(

) : DialogFragment() {

    private lateinit var adapter: AvatarAdapter
    private val viewModel: PersonViewModel by viewModels {
        ComponentInjector.providePersonViewModelFactory(requireContext())
    }

    companion object {
        const val ICON_RESOURCE = "icon"

        fun newInstance(iconResource: Int): AvatarPicker {
            val args = Bundle()
            args.putInt(ICON_RESOURCE, iconResource)
            return AvatarPicker().apply {
                arguments = args
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        adapter = AvatarAdapter(context, {onClicked(it)} )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_avatar_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapper = ResourceMapper()
        arguments?.also {
            val number = it.getInt(ICON_RESOURCE)
            val current = mapper.mapToIconResources(listOf(RawIconResource(number)))[0]
            iv_current.setImageResource(current.icon)
            tv_current.text = getString(current.description)
        }

        recycler_view.layoutManager = LinearLayoutManager(requireContext())

        viewModel.avatars.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
        viewModel.getMockAvatars()

        recycler_view.adapter = adapter
    }

    private fun onClicked(data: IconResource) {
        Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
//        setFragmentResult("requestKey", bundleOf("resultKey" to result))
//        dismiss()
    }

}