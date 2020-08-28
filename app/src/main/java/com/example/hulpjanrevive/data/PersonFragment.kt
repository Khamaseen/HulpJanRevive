package com.example.hulpjanrevive.data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.hulpjanrevive.maincomponents.ComponentInjector
import com.example.hulpjanrevive.PersonViewModel
import com.example.hulpjanrevive.R
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

        btn_edit_self.visibility =  if (args.personId == -1) View.GONE else View.VISIBLE
        iv_avatar.setImageResource(R.drawable.ic_default_profile)
    }
}