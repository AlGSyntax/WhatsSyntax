package com.syntax_institut.whatssyntax

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import c.s.w.adapter.ItemAdapter
import com.syntax_institut.whatssyntax.data.Datasource
import com.syntax_institut.whatssyntax.data.model.Chat


// Definition der Klasse StatusFragment, die von Fragment erbt.
class StatusFragment : Fragment() {


    // Deklaration einer privaten Variablen recyclerView, die später initiliasiert wird.
    private lateinit var recyclerView: RecyclerView


    // Überschreiben der onCreateView-Methode, um das Layout des Fragments zu erstellen.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflating (Erstellen) des Layouts für dieses Fragment.
        val view = inflater.inflate(R.layout.fragment_status, container, false)

        // Initialsierung von recylcerView, um das RecyclerView-Objekt aus dem Layout zu erhalten.
        recyclerView = view.findViewById(R.id.recycler_view_status)
        // Setzen eines LinearLayoutManager, um die Elemente linear anzuordnen.
        recyclerView.layoutManager = LinearLayoutManager(context)


        // Erstellung einer Instanz von Datasource, um Daten zu holen.
        val dataSource = Datasource()
        // Sortieren der Kontakte basierend darauf, ob sie einen Status haben oder nicht.
        val sortedContacts =
            dataSource.getContacts().sortedWith(compareByDescending { it.status != null })

        // Konvertierung der sortierten Kontakte in Chat-Objekte und Übergabe an den Adapter.
        val chatList = sortedContacts.map { contact -> Chat(contact, mutableListOf()) }
        recyclerView.adapter = ItemAdapter(chatList, true) { contact ->
            // Wenn ein Kontakt einen Status hat, navigiere zum StatusDetailFragment.
            if (contact.status != null) {
                val bundle = Bundle().apply {
                    putString("status_message", contact.status.text)
                }
                findNavController().navigate(
                    R.id.action_navigation_status_to_statusDetailFragment,
                    bundle
                )
            }
        }
        // Rückgabe der View, die das UI des Fragments darstellt.
        return view
    }
}

/**
 * Erklärung des Codes:
 *
 * Mein `StatusFragment` ist wie eine spezialisierte Ausstellungsfläche in einem digitalen Museum,
 * die für die Präsentation von Statusmeldungen eingerichtet ist.
 * Es verwendet verschiedene Werkzeuge und Methoden, um diese Statusmeldungen attraktiv
 * und interaktiv anzuzeigen.
 *
 * Analogie:
 * In dieser Analogie ist jeder Schritt im Code wie ein Teil des Prozesses des Aufbaus und der
 * Organisation eines Kiosks auf einem Jahrmarkt, um sicherzustellen, dass die
 * Produkte (Statusmeldungen) attraktiv präsentiert und leicht zugänglich sind.
 * Stelle dir vor, das `StatusFragment` ist wie ein Kiosk auf einem Jahrmarkt.
 *
 * 1.Initialisierung (Fragment und RecyclerView): Der Kiosk wird aufgebaut. Das `Fragment` ist der
 *                                                eigentliche Stand, und der `RecyclerView` ist wie
 *                                                ein Regal oder eine Anzeigetafel, auf der die
 *                                                Produkte (hier die Statusmeldungen)
 *                                                gezeigt werden.
 *
 * 2.Layout-Inflation: Das Aufblasen des Kiosks, ähnlich dem Aufblasen eines Sprungburgs.
 *                     Das definiert die Struktur und das Aussehen deines Kiosks.
 *
 * 3.Daten holen und sortieren: Du erhältst eine Kiste mit Produkten (Kontakten) und sortierst sie,
 *                              so dass die mit besonderen Angeboten (Statusmeldungen)
 *                              zuerst kommen.
 *
 * 4.Adapter-Einstellungen: Du legst jedes Produkt (jeden Status) in das Regal.
 *                          Der `Adapter` ist wie ein Arrangement, das bestimmt, wie jedes Produkt
 *                          präsentiert wird. Die Produkte werden so angeordnet, dass die
 *                          interessantesten oder relevantesten (Kontakte mit Statusmeldungen)
 *                          zuerst gesehen werden.
 *
 * 5.Interaktion mit den Produkten: Wenn ein Kunde (Benutzer) an einem Produkt (Status) interessiert
 *                                  ist und es auswählt, führt das zu einer Aktion - in diesem Fall
 *                                  wird der Kunde zu einer anderen Stelle
 *                                  (dem `StatusDetailFragment`) geführt, um mehr Informationen zu
 *                                  erhalten. Dies geschieht durch die
 *                                  `findNavController()`-Methode, die wie ein Wegweiser
 *                                  funktioniert, der den Kunden zum richtigen Ort leitet.
 *
 * 6.Rückgabe der Ansicht: Nachdem alles aufgebaut und arrangiert ist, ist der Kiosk bereit
 *                         für Besucher. Die Rückgabe der Ansicht ist wie das Öffnen des Kiosks
 *                         für das Publikum.
 */



