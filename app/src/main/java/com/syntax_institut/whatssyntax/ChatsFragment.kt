package com.syntax_institut.whatssyntax

// Import statements, um verschiedene Klassen und Bibliotheken für die Funkitonalität des Fragments
// zu nutzen.
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

// Defintion des ChatFragment, das von der Klasse Fragment erbt.
class ChatsFragment : Fragment() {

    // Deklaration einer privaten Variable recyclerView vom Typ RecyclerView.
    private lateinit var recyclerView: RecyclerView

    // onCreateView wird aufgerufen, um das Layout für das Fragment zu erstellen.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Das Layout für dieses Fragment wird aus einer XML-Datei aufgebläht.
        val view = inflater.inflate(R.layout.fragment_chats, container, false)

        // Initialisierung des recyclerView durch Verbindung mit einer ID(@) im XML-Layout
        recyclerView = view.findViewById(R.id.recycler_view_chats)

        // Festlegen des LayoutManagers, der bestimmt, wie Elemente in RecyclerView angezeigt
        // werden.
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Rückgabe der View, die das Layout des Fragments darstellt.
        return view
    }


    // onViewCreated wird aufgerufen ,nachdem die View für das Fragment erstellt wurde.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Datenquelle wird instanziiert, um eine List von Chats zu erhalten.
        val dataSource = Datasource()
        val chatList = dataSource.getChats()


        // Setzen des Adapters für den recyclerView mit der Chatliste und einem Lambda-Ausdruck
        // für Klickereignisse.
        recyclerView.adapter = ItemAdapter(chatList, false) { contact ->

            // Finden des Indes des ausgewählten Kontakts in der Chatliste.
            val chatIndex = chatList.indexOfFirst { it.contact == contact }

            // Überprüft, ob der Kontakt gefunden wurde und löst die Navigation zum
            // ChatsDetailFragment(DetailFragment) aus.
            if (chatIndex != -1) {

                val action =
                    ChatsFragmentDirections.actionNavigationChatsToChatsDetailFragment(chatIndex.toLong())
                findNavController().navigate(action)
            }
        }
    }

}


/**
 *
 *
 * Zusammenfassung des ChatsFragment-Codes
 * Das `ChatsFragment` ist ein wesentlicher Bestandteil der Benutzeroberfläche in meiner
 * Messaging-App, ähnlich einem WhatsApp-Klon. Es dient dazu, eine Liste von Chat-Nachrichten
 * anzuzeigen. Der Code besteht aus drei Hauptmethoden:
 *
 * 1. "onCreateView": Hier wird das Layout des Fragments initialisiert. Es lädt das Layout aus
 *                    einer XML-Datei und initialisiert die RecyclerView-Komponente, die die
 *                    Chat-Nachrichten anzeigt.
 *
 * 2. "onViewCreated": Diese Methode wird aufgerufen, nachdem das Layout erstellt wurde. Hier werden
 *                     die Daten für die Chat-Nachrichten geladen (hier simuliert durch
 *                     "Datasource().getChats()") und der Adapter für den RecyclerView gesetzt.
 *                     Der Adapter bestimmt, wie die Chat-Nachrichten in der Liste angezeigt werden.
 *                     Zudem wird hier eine Click-Listener-Funktionalität implementiert, um auf
 *                     Nutzereingaben zu reagieren und zu einem Detailbildschirm zu navigieren.
 *
 * 3. "onDestroyView": Diese Methode wird aufgerufen, wenn das Fragment seine Ansicht zerstört.
 *                     Hier können Ressourcen freigegeben oder Aufräumarbeiten durchgeführt werden,
 *                     was aber in deinem Fall nicht benötigt wird.
 *
 * Analogie zu jeder Methode
 * 1. "onCreateView": Denke an das `onCreateView` wie an das Öffnen eines Buches auf einer
 *                    bestimmten Seite. Das Buch (die App) hat viele Seiten (Fragments), aber du
 *                    öffnest es auf der Seite der Chat-Nachrichten. Die Seite wird bereitgemacht,
 *                    um gelesen zu werden, ähnlich wie das Layout des Fragments aufgebaut wird.
 *
 * 2. "onViewCreated": Sobald die Seite offen ist, beginnst du, die Inhalte zu lesen
 *                     (die Chat-Nachrichten). Diese Inhalte werden aus einem Inhaltsverzeichnis
 *                     (der `Datasource`) geholt. Jede Nachricht wird in einer bestimmten Weise
 *                     dargestellt (Adapter), ähnlich wie ein Buch Text und Bilder anzeigt.
 *                     Wenn du auf einen Absatz klickst (eine Chat-Nachricht),
 *                     wirst du zu einer Detailseite (Detailbildschirm) geführt, die mehr
 *                     Informationen zu diesem Absatz bietet.
 *
 *
 *
 *
 */

