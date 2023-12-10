package com.syntax_institut.whatssyntax

// Import-Anweisungen für benötigte Klassen und Bibliotheken.
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import c.s.w.adapter.CallsAdapter
import com.syntax_institut.whatssyntax.data.Datasource

/**
 * Ein Fragment zur Darstellung einer Liste von Anrufen.
 *
 * Das Fragment setzt einen RecyclerView ein, um die Anrufliste anzuzeigen.
 * Es verwendet einen CallsAdapter, um die Daten zu binden und interaktive Elemente zu
 * ermöglichen.
 */
class CallFragment : Fragment() {

    // Späte Initialiserung von RecyclerView und CallsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var callsAdapter: CallsAdapter

    /**
     * Erstellt und gibt die Ansicht für das Fragment zurück.
     * Diese Methode ist Teil des Lebenszyklus des Fragments und wird verwendet,
     * um das User Interface des Fragments zu initialisieren.
     *
     * @param inflater: Der LayoutInflater, der verwendet wird, um das Layout des Fragments
     *                  aufzublasen.
     * @param container: Der Container, in den das Fragment eingefügt wird.
     * @param savedInstanceState: Ein Bundle, das den vorherigen Zustand des Fragments speichert.
     * @return Die erstellte Ansicht.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflating(Erstellen) des Layouts für dieses Fragment.
        val view = inflater.inflate(R.layout.fragment_call, container, false)

        // Initialisieren des RecyclerView.
        recyclerView = view.findViewById(R.id.recycler_view_calls)
        // Setzen eines LinearLayoutManager, der die Items linear anzeigt.
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Datenquelle initialisieren und Anrufliste abrufen.
        val dataSource = Datasource()
        val callList = dataSource.getCalls()

        // Erstellen des Adapters für die RecyclerView mit der Anrufliste.
        // Der Lambda-Ausdruck für den Klick-Listener ist leer , da er später definiert wird.
        callsAdapter = CallsAdapter(callList) { call ->
            // Hier kann Logik für Klick-Events hinzugefügt werden, z.B. um den Dialer zu öffnen.
            // Dies ermöglicht es den Benutzern, direkt aus der App Anrufe zu tätigen.
        }

        // Adapter an die RecyclerView anhängen.
        recyclerView.adapter = callsAdapter

        // Die erstellte Ansicht zurückgeben.
        return view
    }
}

/**
 *
 *
 * Erklärung des Codes:
 *
 * Das `CallFragment` in deiner App dient als spezialisierter Bereich, in dem die Anrufhistorie
 * angezeigt wird. Es organisiert und verwaltet die Darstellung von Anrufinformationen mithilfe
 * von Android-spezifischen Methoden und Benutzeroberflächen-Elementen,
 * die eine Liste von Anrufen in einer `RecyclerView` zeigen.
 *
 * Analogie:
 *
 * Stellen wir uns vor, das `CallFragment` ist wie eine Ausstellungshalle, die für die Präsentation
 * von zeitgeschichtlichen Dokumenten eingerichtet ist.Das `CallFragment` fungiert als Kurator einer
 * Ausstellung, der die historischen Anrufe (Dokumente) in einer linearen und interaktiven Weise
 * arrangiert. Es ermöglicht Besuchern (Benutzern), durch die Geschichte ihrer Kommunikation zu
 * wandern und bei Bedarf erneut Kontakt aufzunehmen, indem sie auf ein Element tippen, um den
 * Dialer zu öffnen und die Nummer vorzuwählen. Jedes Element des Fragments trägt dazu bei, dass die
 * Anrufliste nicht nur eine Ansammlung von Daten ist, sondern eine lebendige, interaktive Chronik
 * persönlicher Verbindungen.
 *
 * - Fragment-Klasse und onCreateView-Methode: Das ist der Aufbau deiner Ausstellungshalle.
 *                                             Das Fragment selbst ist die Halle, und die
 *                                             `onCreateView`-Methode ist der Prozess, in dem du den
 *                                             Raum vorbereitest und das Layout erstellst –
 *                                             vergleichbar damit, Wände zu errichten und die
 *                                             Beleuchtung zu installieren.
 *
 * - Layout-Inflation: Hier entfaltet sich das Design deines Ausstellungsraums, ähnlich dem
 *                     Aufstellen von Display-Tafeln in einer Ausstellungshalle.
 *                     Das Layout (`fragment_call.xml`) bildet die Struktur, auf der die Dokumente
 *                     (Anrufe) präsentiert werden.
 *
 * - RecyclerView initialisieren: Dies ist wie das Aufstellen von Dokumentenständern in der Halle,
 *                                auf denen deine Dokumente (Anrufliste) der Öffentlichkeit
 *                                zugänglich gemacht werden. Der `LinearLayoutManager` sorgt dafür,
 *                                dass diese Ständer in einer geraden Linie angeordnet sind,
 *                                was eine einfache und systematische Betrachtung ermöglicht.
 *
 * - CallsAdapter: Der `CallsAdapter` ist vergleichbar mit einem Archivar, der entscheidet, wie
 *                 jedes Dokument (jeder Anruf) präsentiert wird. Er platziert jedes Dokument
 *                 sorgfältig auf den Ständern und sorgt dafür, dass Informationen wie der Name der
 *                 Person und der Zeitpunkt des Dokuments (des Anrufs) sichtbar sind.
 *
 * - ViewHolder und bind-Methode: Jeder `ViewHolder` ist wie ein einzelnes Display in der Halle,
 *                                das ein Dokument hält. Die `bind`-Methode ist der Vorgang des
 *                                Anbringens der Dokumente auf den Displays. Jedes Dokument wird
 *                                passend zum Thema der Ausstellung – eingehende und
 *                                ausgehende Anrufe – angezeigt.
 *
 * - OnClickListener: Wenn ein Besucher ein Dokument näher betrachten möchte, wählt er es aus
 *                    (klickt auf ein Anrufelement), und der Archivar (die App) leitet eine Aktion
 *                    ein – in diesem Fall das Öffnen eines Wählgeräts mit der Nummer des Dokuments
 *                    (des Anrufs).
 *
 *
 *
 *
 */