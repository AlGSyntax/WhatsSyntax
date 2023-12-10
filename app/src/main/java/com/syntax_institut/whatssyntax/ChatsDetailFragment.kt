package com.syntax_institut.whatssyntax

import android.os.Bundle
import com.syntax_institut.whatssyntax.data.model.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.adapter.MessageAdapter
import com.syntax_institut.whatssyntax.data.Datasource

class ChatsDetailFragment : Fragment() {

    private lateinit var messageAdapter: MessageAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var sendMessageButton: Button
    private lateinit var messageEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chats_detail, container, false)

        // Initialisiere deine RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view_messages)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Hole die chatId aus den SafeArgs
        val mainActivity = activity as MainActivity
        val dataSource = mainActivity.datasource
        val args: ChatsDetailFragmentArgs by navArgs()
        val chatIndex = args.chatIndex

        // Hole die Nachrichten für diesen Chat
        val messages = dataSource.getMessagesForChat(chatIndex.toInt())

        // Initialisiere den Adapter mit den Nachrichten
        messageAdapter = MessageAdapter(messages)
        recyclerView.adapter = messageAdapter

        // Initialisiere den Senden-Button und EditText
        sendMessageButton = view.findViewById(R.id.button_chatbox_send)
        messageEditText = view.findViewById(R.id.edittext_chatbox)

        sendMessageButton.setOnClickListener {
            val messageText = messageEditText.text.toString()
            if (messageText.isNotEmpty()) {
                // Füge die neue Nachricht hinzu
                val newMessage = Message(messageText, incoming = false) // 'incoming' basierend auf deiner Logik setzen
                dataSource.addMessageToChat(chatIndex.toInt(), newMessage)



                val messageList = dataSource.getMessagesForChat(chatIndex.toInt())
                messageAdapter.notifyItemInserted(messageList.size - 1)

                // Clear the input box after sending
                messageEditText.text.clear()
                // Scroll to the bottom to show the latest message
                recyclerView.scrollToPosition(messageList.size - 1)// Scroll to the bottom to show the latest message
            }
        }

        return view
    }


}
