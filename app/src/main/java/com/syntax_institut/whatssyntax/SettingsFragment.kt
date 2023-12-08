package com.syntax_institut.whatssyntax

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.syntax_institut.whatssyntax.R

class SettingsFragment : Fragment() {

    private lateinit var editTextName: EditText
    private lateinit var editTextNumber: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        editTextName = view.findViewById(R.id.editTextName)
        editTextNumber = view.findViewById(R.id.editTextNumber)
        val buttonSave = view.findViewById<Button>(R.id.buttonSave)

        loadProfile()

        buttonSave.setOnClickListener {
            saveProfile()
        }

        return view
    }

    private fun loadProfile() {
        val sharedPrefs = requireActivity().getSharedPreferences("WhatsAppClonePrefs", Context.MODE_PRIVATE)
        editTextName.setText(sharedPrefs.getString("name", ""))
        editTextNumber.setText(sharedPrefs.getString("number", ""))
    }

    private fun saveProfile() {
        val name = editTextName.text.toString()
        val number = editTextNumber.text.toString()

        val sharedPrefs = requireActivity().getSharedPreferences("WhatsAppClonePrefs", Context.MODE_PRIVATE)
        with(sharedPrefs.edit()) {
            putString("name", name)
            putString("number", number)
            apply()
        }
    }
}

