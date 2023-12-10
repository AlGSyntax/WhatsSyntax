package com.syntax_institut.whatssyntax

// Import-Anweisungen für benötigte Klassen und Bibliotheken.
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.syntax_institut.whatssyntax.data.model.Profile


/**
 * SettingsFragment zur Anzeige und Bearbeitung von Benutzerprofileinstellungen.
 *
 * In diesem Fragment kann der Benutzer seinen Namen und seine Telefonnummer bearbeiten.
 * Die Änderungen werden in der Datenquelle gespeichert.
 */
class SettingsFragment : Fragment() {

    // Späte Initialisierung der UI-Komponenten.
    private lateinit var editTextName: EditText
    private lateinit var editTextNumber: EditText
    private lateinit var imageViewProfile: ImageView

    /**
     * Erstellt und gibt die Ansicht für das Fragment zurück.
     * Diese Methode ist Teil des Lebenszyklus des Fragments und wird verwendet,
     * um das User Interface des Fragments zu initialisieren.
     *
     * @param inflater Der LayoutInflater, der verwendet wird, um das Layout des Fragments aufzublasen.
     * @param container Der Container, in den das Fragment eingefügt wird.
     * @param savedInstanceState Ein Bundle, das den vorherigen Zustand des Fragments speichert.
     * @return Die erstellte Ansicht.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflating (Erstellen) des Layouts für dieses Fragment.
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        // Initialisieren der UI-Komponenten.
        imageViewProfile = view.findViewById(R.id.imageViewProfile)
        editTextName = view.findViewById(R.id.editTextName)
        editTextNumber = view.findViewById(R.id.editTextNumber)
        val buttonSave = view.findViewById<Button>(R.id.buttonSave)


        // Laden der aktuellen Profildaten in die UI-Komponenten.
        loadProfile()

        // Setzen eines OnClickListener für den Speichern-Button.
        buttonSave.setOnClickListener {
            // Speichern der geänderten Profildaten.
            saveProfile()
        }

        // Rückgabe der erstellten Ansicht.
        return view
    }


    /**
     * Lädt das Benutzerprofil und zeigt die Daten in den UI-Komponenten an.
     * Holt das Profilobjekt aus der Datenquelle und setzt die Werte in den entsprechenden Feldern.
     */
    private fun loadProfile() {
        val mainActivity = activity as MainActivity
        val profile = mainActivity.datasource.getProfile()
        editTextName.setText(profile.name)
        editTextNumber.setText(profile.number)
        // Hier wird das Profilbild fest aus der Ressource geladen ohne die Möglichkeit zur Änderung
        imageViewProfile.setImageResource(profile.image)
    }


    /**
     * Speichert die geänderten Profildaten.
     * Erstellt ein neues Profilobjekt mit den geänderten Daten und speichert es in der Datenquelle.
     */
    private fun saveProfile() {
        val mainActivity = activity as MainActivity
        val name = editTextName.text.toString()
        val number = editTextNumber.text.toString()
        // Hier bleibt die Ressourcen-ID des Profilbildes unverändert
        val newProfile = Profile(name, number, mainActivity.datasource.getProfile().image)
        mainActivity.datasource.setProfile(newProfile)
    }
}

/**
 * Zusammenfassung des SettingsFragment-Codes
 * Das SettingsFragment ist für die Anzeige und Bearbeitung von Benutzerprofileinstellungen
 * zuständig. Es ermöglicht dem Benutzer, seinen Namen und seine Telefonnummer zu bearbeiten und
 * diese Änderungen zu speichern. Der Code beinhaltet:
 *
 * Layout-Initialisierung (onCreateView): Diese Methode wird aufgerufen, um das User Interface des
 *                                        Fragments zu initialisieren. Hier werden die
 *                                        UI-Komponenten wie EditText für den Namen und die
 *                                        Nummer sowie das ImageView für das Profilbild
 *                                        initialisiert.
 *
 * Laden des Profils (loadProfile): Diese Methode lädt die aktuellen Profildaten aus einer
 *                                  Datenquelle und zeigt sie in den UI-Komponenten an.
 *
 * Speichern des Profils (saveProfile): Diese Methode speichert die vom Benutzer vorgenommenen
 *                                      Änderungen, indem sie ein neues Profilobjekt erstellt und
 *                                      dieses in der Datenquelle aktualisiert.
 *
 * Analogie zu jeder Komponente:
 *
 * Stellen wir uns vor, das SettingsFragment ist wie ein persönlicher Assistent in einem Büro,
 * der sich um die Verwaltung deiner persönlichen Daten kümmert:
 *
 * Aufbau des Büros (onCreateView): Dies entspricht dem Einrichten eines Büros mit Schreibtisch
 *                                 , Stuhl und Computern. Der Schreibtisch repräsentiert das
 *                                 RecyclerView, und der Computer mit den Formularfeldern steht für
 *                                 die EditText-Felder für den Namen und die Nummer sowie das
 *                                 ImageView für das Profilbild.
 *
 * Anzeigen der Dokumente (loadProfile): Dies ist vergleichbar damit, dass dein Assistent deine
 *                                       aktuellen persönlichen Daten aus einem Aktenordner
 *                                       (der Datenquelle) holt und sie auf dem Computerbildschirm
 *                                       anzeigt, damit du sie überprüfen kannst.
 *
 * Aktualisieren der Dokumente (saveProfile): Hier bearbeitest du die auf dem Bildschirm
 *                                            angezeigten Informationen. Nachdem du die
 *                                            Änderungen vorgenommen hast, speichert dein
 *                                            Assistent die aktualisierten Daten in den
 *                                            Aktenordner zurück. Dies ist vergleichbar mit
 *                                            dem Speichern eines überarbeiteten Dokuments auf
 *                                            dem Computer.
 */

