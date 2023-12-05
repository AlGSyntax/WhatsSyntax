package com.syntax_institut.whatssyntax

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import c.s.w.adapter.ItemAdapter
import com.syntax_institut.whatssyntax.data.Datasource
import com.syntax_institut.whatssyntax.data.model.Chat


class StatusFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_status, container, false)

        recyclerView = view.findViewById(R.id.recycler_view_status)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Hole die Kontaktliste aus der Datasource
        val dataSource = Datasource()
        val sortedContacts = dataSource.getContacts().sortedWith(compareByDescending { it.status != null })


        // Konvertiere die sortierten Kontakte in Chat-Objekte und übergebe sie an den Adapter
        val chatList = sortedContacts.map { contact -> Chat(contact, mutableListOf()) }
        recyclerView.adapter = ItemAdapter(chatList, true)


        return view
    }
}


