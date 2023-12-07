package com.syntax_institut.whatssyntax

// Imports, die du benötigen könntest
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

class ChatsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chats, container, false)
        recyclerView = view.findViewById(R.id.recycler_view_chats)
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataSource = Datasource()
        val chatList = dataSource.getChats()

        recyclerView.adapter = ItemAdapter(chatList, false) { contact ->
            // Finde den Index des Chat-Objekts basierend auf dem zugehörigen Kontakt
            val chatIndex = chatList.indexOfFirst { it.contact == contact }
            if (chatIndex != -1) {
                // Verwende die chatIndex als chatId für die Navigation
                val action = ChatsFragmentDirections.actionNavigationChatsToChatsDetailFragment(chatIndex.toLong())
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Bereinigungen, falls notwendig
    }
}


/**
 *
 * Erklärung des Codes:
 *
 * Dein `ChatsFragment` ist wie ein Schaufenster in einem Laden, das speziell für die Präsentation
 * von Chat-Nachrichten eingerichtet ist. Es nutzt verschiedene Werkzeuge und Methoden,
 * um die Nachrichten ansprechend und geordnet anzuzeigen.
 *
 * Analogie:
 *
 *
 * In dieser Analogie ist jeder Schritt im Code wie ein Teil des Prozesses des Aufbaus und der
 * Organisation eines Briefkastens, um sicherzustellen, dass die Nachrichten (Chats) ordentlich
 * präsentiert und leicht zugänglich sind.
 * Also stell dir vor, mein `ChatsFragment` ist wie ein Briefkasten in einem Apartmentgebäude.
 *
 * 1.Import-Anweisungen: Das sind wie die Werkzeuge und Materialien, die du brauchst,
 *                       um deinen Briefkasten zu bauen und zu betreiben - Schrauben,
 *                       Schraubenzieher, Briefschlitze usw. .
 *
 * 2.Klassendefinition(`class ChatsFragment : Fragment()`): Hier baust du den Briefkasten.
 *                                                          Ein Briefkasten in einem
 *                                                          Apartmentgebäude, der für alle Bewohner
 *                                                          zugänglich ist, ähnlich wie ein Fragment
 *                                                          in einer Android-App, das einen Teil
 *                                                          der Benutzeroberfläche darstellt.
 *
 * 3.RecyclerView-Deklaration: Das ist wie die Fächer in deinem Briefkasten.Jedes Fach repräsentiert
 *                             einen Platz, wo Briefe (hier: Chat-Nachrichten) aufbewahrt werden
 *                             können.
 *
 * 4.onCreateView-Methode: Das ist der Prozess des Einrichtens des Briefkastens.
 *                         Du öffnest den Briefkasten (inflating des Layouts), ordnest die Fächer an
 *                         (Initialisierung von recyclerView und Setzen des LayoutManagers) und
 *                         legst die Briefe (Chat-Nachrichten) in die Fächer (Adapter setzen, der
 *                         bestimmt, wie die Nachrichten angezeigt werden).
 *
 *    - Inflate des Layouts: Das ist, als würdest du den Briefkasten an die Wand montieren.
 *    - RecyclerView initialisieren: Das ist, als würdest du die Fächer in den Briefkasten einbauen.
 *    - LayoutManager setzen: Das entscheidet, wie die Fächer angeordnet sind - entweder vertikal
 *                            übereinander oder horizontal nebeneinander.
 *    - Daten holen und Adapter setzen: Das ist wie das Einlegen der Briefe in die Fächer.
 *                                      Der Adapter entscheidet, wie jeder Brief
 *                                      (jede Chat-Nachricht) in seinem Fach aussieht.
 *
 * 5.Rückgabe der View: Das ist, als würdest du nach dem Einrichten des Briefkastens die Tür
 *                      schließen und sicherstellen, dass alles ordentlich und bereit für die
 *                      Bewohner ist.
 *
 *
 */

