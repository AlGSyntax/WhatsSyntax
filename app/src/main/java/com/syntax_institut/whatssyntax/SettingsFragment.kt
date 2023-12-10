package com.syntax_institut.whatssyntax

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.syntax_institut.whatssyntax.data.model.Profile

class SettingsFragment : Fragment() {

    private lateinit var editTextName: EditText
    private lateinit var editTextNumber: EditText
    private lateinit var imageViewProfile: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        imageViewProfile = view.findViewById(R.id.imageViewProfile)
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
        val mainActivity = activity as MainActivity
        val profile = mainActivity.datasource.getProfile()
        editTextName.setText(profile.name)
        editTextNumber.setText(profile.number)
        // Hier wird das Profilbild fest aus der Ressource geladen ohne die Möglichkeit zur Änderung
        imageViewProfile.setImageResource(profile.image)
    }

    private fun saveProfile() {
        val mainActivity = activity as MainActivity
        val name = editTextName.text.toString()
        val number = editTextNumber.text.toString()
        // Hier bleibt die Ressourcen-ID des Profilbildes unverändert
        val newProfile = Profile(name, number, mainActivity.datasource.getProfile().image)
        mainActivity.datasource.setProfile(newProfile)
    }
}

