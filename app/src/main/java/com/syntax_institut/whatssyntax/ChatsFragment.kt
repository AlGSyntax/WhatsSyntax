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


class ChatsFragment : Fragment() {


    private lateinit var binding: FragmentChatsBinding
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chats, container, false)

        // RecyclerView-Instanz
        recyclerView = view.findViewById(R.id.recycler_view_chats)

        // Setze den LayoutManager
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Setze den Adapter für die RecyclerView
        val dataSource = Datasource()
        val chatList = dataSource.getChats()
        recyclerView.adapter = ItemAdapter(chatList)

        return view
    }
}

