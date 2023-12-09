package com.syntax_institut.whatssyntax

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment() {

    private lateinit var sharedPrefs: SharedPreferences
    private lateinit var editTextName: EditText
    private lateinit var editTextNumber: EditText
    private lateinit var imageViewProfile: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedPrefs = requireActivity().getSharedPreferences("WhatsAppClonePrefs", Context.MODE_PRIVATE)
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        imageViewProfile = view.findViewById(R.id.imageViewProfile)
        editTextName = view.findViewById(R.id.editTextName)
        editTextNumber = view.findViewById(R.id.editTextNumber)
        val buttonSave = view.findViewById<Button>(R.id.buttonSave)

        loadProfile()

        imageViewProfile.setOnClickListener {
            // Hier die Logik zum Ändern des Profilbildes hinzufügen
            // Dies könnte das Öffnen einer Kamera-Intent oder Galerie-Intent sein
        }

        buttonSave.setOnClickListener {
            saveProfile()
        }

        return view
    }

    private fun loadProfile() {
        editTextName.setText(sharedPrefs.getString("name", ""))
        editTextNumber.setText(sharedPrefs.getString("number", ""))
        // Hier könntest du den Pfad zum gespeicherten Bild laden und es in imageViewProfile setzen
        // Beispiel:
        val profileImagePath = sharedPrefs.getString("profileImage", null)
        profileImagePath?.let {
            // Hier Code zum Setzen des Profilbildes basierend auf dem gespeicherten Pfad
            // imageViewProfile.setImageURI(Uri.parse(it))
        }
    }

    private fun saveProfile() {
        val name = editTextName.text.toString()
        val number = editTextNumber.text.toString()
        // Wenn ein neues Profilbild ausgewählt wurde, solltest du auch seinen Pfad speichern.
        // Beispiel:
        val profileImagePath = "hier_der_neue_pfad"

        with(sharedPrefs.edit()) {
            putString("name", name)
            putString("number", number)
            putString("profileImage", profileImagePath) // Pfad des Profilbildes speichern
            apply()
        }
    }
}

