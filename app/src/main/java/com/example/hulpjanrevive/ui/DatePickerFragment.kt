package com.example.hulpjanrevive.ui

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.example.hulpjanrevive.maincomponents.MainActivity
import java.util.*

class DatePickerFragment() : DialogFragment(), DatePickerDialog.OnDateSetListener {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the current date as the default date in the picker.
        // Use the current date as the default date in the picker.
        val c: Calendar = Calendar.getInstance()
        val year: Int = c.get(Calendar.YEAR)
        val month: Int = c.get(Calendar.MONTH)
        val day: Int = c.get(Calendar.DAY_OF_MONTH)

        // Create a new instance of DatePickerDialog and return it.

        // Create a new instance of DatePickerDialog and return it.
        return DatePickerDialog(requireActivity(), this, year, month, day)
    }

    override fun onDateSet(datePicker: DatePicker?, year: Int, month: Int, day: Int) {
        (activity as MainActivity).processDatePickerResult(year, month, day)
    }

}