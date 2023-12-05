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
import com.syntax_institut.whatssyntax.databinding.FragmentChatsBinding

/**
 * Ein Fragment , das eine Liste von Chats anzeigt.
 *
 * Dieses Fragment verwendet RecyclerView, um eine Liste von Chat-Elementen darzustellen.
 * Jedes Chat-Element wird durch ein Objekt der Klasse Chat repräsentiert-
 */

class ChatsFragment : Fragment() {


    private lateinit var binding: FragmentChatsBinding
    private lateinit var recyclerView: RecyclerView


    /**
     * Erstellt die View für das Fragment.
     *
     * @param inflater : Das LayoutInflater-Objekt, das verwendet wird , um XML-Layouts in die
     * entsprechenden View-Objekte zu überführen.
     * @param container : Der Container , in dem das Fragment UI gerendert wird.
     * @param savedInstanceState : Ein Bundle , das den Zustand des Fragments speichert
     * @return : Die erstellte View
     */


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chats, container, false)

        // Initialisiert eine RecyclerView-Instanz aus dem Layout
        recyclerView = view.findViewById(R.id.recycler_view_chats)

        // Setzt den LinearLayoutManager für die RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Initialisiert die Datasource, um Daten für die Chat-Liste zu erhalten.
        val dataSource = Datasource()
        val chatList = dataSource.getChats()

        // Setzt den Adapter für die Recyclerview mit der Chat-Liste
        recyclerView.adapter = ItemAdapter(chatList)

        return view
    }
}

