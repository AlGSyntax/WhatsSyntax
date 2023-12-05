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
import com.syntax_institut.whatssyntax.databinding.FragmentChatsBinding

/**
 * Ein Fragment , das eine Liste von Chats anzeigt.
 *
 * Dieses Fragment verwendet RecyclerView, um eine Liste von Chat-Elementen darzustellen.
 * Jedes Chat-Element wird durch ein Objekt der Klasse Chat repräsentiert-
 */

class ChatsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chats, container, false)

        recyclerView = view.findViewById(R.id.recycler_view_chats)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val dataSource = Datasource()
        val chatList = dataSource.getChats() // Holen der Chat-Daten
        recyclerView.adapter = ItemAdapter(chatList, false){

        } // Verwendung der Chat-Daten

        return view
    }
}

