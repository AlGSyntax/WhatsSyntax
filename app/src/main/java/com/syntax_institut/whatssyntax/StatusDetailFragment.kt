package com.syntax_institut.whatssyntax

// Import-Anweisungen für benötigte Klassen und Bibliotheken.
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * StatusDetailFragment zur Anzeige eines spezifischen Status-Updates.
 * Dieses Fragment wird aufgerufen, um einen ausgewählten Status detailliert anzuzeigen.
 */
class StatusDetailFragment : Fragment() {


    /**
     * onCreateView wird aufgerufen, um das Layout des Fragments zu erstellen.
     * Diese Methode ist Teil des Lebenszyklus des Fragments und wird verwendet,
     * um das User Interface des Fragments zu initialisieren.
     *
     * @param inflater: LayoutInflater-Objekt, das zum Aufblasen des Layouts verwendet wird.
     * @param container: Der übergeordnete Container, in dem das Fragment dargestellt wird.
     * @param savedInstanceState: Ein Bundle, das den gespeicherten Zustand des Fragments enthält.
     * @return Die erstellte View, die das UI des Fragments darstellt.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflating (Erstellen) des Layouts für dieses Fragment.
        // Das Layout wird aus der XML-Datei fragment_status_detail aufgeblasen.
        // Der 'container' und 'false' bestimmen, wie das Layout in der übergeordneten View
        // eingebettet wird.
        val view = inflater.inflate(
            R.layout.fragment_status_detail, container,
            false
        )

        // Argumente, die vom vorherigen Fragment übergeben wurden, werden abgerufen.
        // Hier wird geprüft, ob ein Status-Text übergeben wurde.
        val statusMessage = arguments?.getString("status_message")

        // Finden des TextView-Elements im Layout und Setzen des Textes auf die Statusmeldung.
        // R.id.textView_status_message ist die ID des TextView-Elements im Layout.
        view.findViewById<TextView>(R.id.textView_status_message).text = statusMessage

        // Rückgabe der View, die das UI des Fragments darstellt.
        return view
    }
}


/**
 * Erklärung des Codes:
 *
 * Das `StatusDetailFragment` in deiner App funktioniert wie ein spezialisierter Anzeigebereich,
 * der dafür konzipiert ist, eine detaillierte Ansicht eines bestimmten Status anzuzeigen.
 * Es nutzt Android-spezifische Methoden und Widgets, um diese Ansicht effektiv zu realisieren.
 *
 * Analogie:
 *
 * In dieser Analogie ist jedes Element deines Codes wie ein Schritt im Prozess des Aufbaus und der
 * Präsentation eines speziellen Displays in einem Museum, das darauf abzielt, eine bestimmte
 * Nachricht oder ein Objekt auf ansprechende und informative Weise zu zeigen.
 * Stelle dir vor, das `StatusDetailFragment` ist wie ein kleines Ausstellungsdisplay in einem
 * Museum.
 *
 * 1.Fragment-Klasse und onCreateView-Methode: Das ist wie der Aufbau deines Displays im Museum.
 *                                             Das Fragment repräsentiert das Display selbst,
 *                                             und die `onCreateView`-Methode ist der Prozess des
 *                                             Aufbaus und der Gestaltung des Displays.
 *
 * 2.Layout-Inflation: Hier "bläst" du das Design deines Displays auf, ähnlich wie ein Künstler,
 *                     der eine Leinwand aufspannt. Das Layout
 *                     (definiert in `fragment_status_detail`) ist dein Kunstwerk,
 *                     das auf die Leinwand gebracht wird.
 *
 * 3.Übernahme und Anzeige des Status: Stell dir vor, du hast eine Schatulle mit besonderen
 *                                     Nachrichten oder Objekten. Jemand wählt eine Nachricht
 *                                     (den Status) aus und legt sie auf dein Display.
 *                                     Das Holen der `status_message` aus den `arguments` ist wie
 *                                     das Öffnen dieser Schatulle und das Herausnehmen
 *                                     der ausgewählten Nachricht.
 *
 * 4.TextView-Update: Das ist, als würdest du die Nachricht auf eine Tafel im Display schreiben.
 *                    Das `TextView`-Element ist die Tafel, und das Setzen des Textes
 *                    (`statusMessage`) ist wie das Schreiben der Nachricht auf diese Tafel
 *                    mit einem Marker.
 *
 * 5.Rückgabe der Ansicht: Nachdem du die Nachricht auf dein Display geschrieben hast, ist es
 *                         bereit, von den Museumsbesuchern betrachtet zu werden. Die Rückgabe der
 *                         Ansicht (`return view`) ist wie das Öffnen der Vorhänge,
 *                         um das Display den Besuchern zu präsentieren.
 *
 *
 */