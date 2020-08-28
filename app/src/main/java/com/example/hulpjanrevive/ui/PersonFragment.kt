package com.example.hulpjanrevive.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.example.hulpjanrevive.R
import com.example.hulpjanrevive.maincomponents.ComponentInjector
import kotlinx.android.synthetic.main.fragment_person.*

/**
 * A simple [Fragment] subclass.
 * Use the [PersonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PersonFragment : Fragment() {

    private val args: PersonFragmentArgs by navArgs()
    private val viewModel: PersonViewModel by viewModels {
        ComponentInjector.providePersonViewModelFactory(
            requireContext()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_edit_self.visibility = if (args.personId == -1) View.GONE else View.VISIBLE

        viewModel.editMode.observe(viewLifecycleOwner) { switchEditMode(it) }
        viewModel.name.observe(viewLifecycleOwner) { setName(it) }
        viewModel.avatar.observe(viewLifecycleOwner) { setAvatar(it) }
        viewModel.postAvatar()

        iv_avatar.setOnLongClickListener { openAvatarPicker(viewModel.avatar.value?.icon); true }

        btn_edit_self.setOnClickListener {
            viewModel.switchEditMode()
        }

    }

    private fun switchEditMode(mode: Boolean) {
        when (mode) {
            true -> setEditOn()
            false -> setEditOff()
        }
    }

    private fun setEditOn() {
        iv_avatar.isEnabled = true
        tv_name.visibility = View.GONE
        edit_name.visibility = View.VISIBLE

        btn_edit_self.apply {
            text = getString(R.string.edit_profile_off)
            setBackgroundColor(resources.getColor(R.color.colorActivated))
        }
    }

    private fun setEditOff() {
        saveNewProfileData()

        iv_avatar.isEnabled = false
        tv_name.visibility = View.VISIBLE
        edit_name.visibility = View.GONE

        btn_edit_self.apply {
            text = getString(R.string.edit_profile_on)
            setBackgroundColor(resources.getColor(R.color.colorAccent))
        }

    }

    private fun openAvatarPicker(icon: Int?) {
        val newFragment: AvatarPicker = AvatarPicker.newInstance(icon ?: 0)
        newFragment.show(requireFragmentManager(), "dialog")
        Toast.makeText(context, "clicked avatar", Toast.LENGTH_SHORT).show()
    }

    private fun saveNewProfileData() {
        viewModel.updateProfile(edit_name.text.toString())
    }

    private fun setName(name: String) {
        tv_name.text = name
        edit_name.setText(name)
    }

    private fun setAvatar(iconResource: IconResource) {
        iv_avatar.setImageResource(iconResource.icon)
        tv_nickname.text = getString(iconResource.description)
    }
}