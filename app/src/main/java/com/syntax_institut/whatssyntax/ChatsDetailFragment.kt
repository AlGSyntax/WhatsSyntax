package com.syntax_institut.whatssyntax

// Import-Anweisungen für benötigte Klassen und Bibliotheken.
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import c.s.w.adapter.MessageAdapter
import com.syntax_institut.whatssyntax.data.model.Message


/**
 * ChatsDetailFragment dient zur Anzeige der Nachrichten eines spezifischen Chats.
 */
class ChatsDetailFragment : Fragment() {

    // Deklaration der benötigten UI-Komponenten und Adapter.
    private lateinit var messageAdapter: MessageAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var sendMessageButton: Button
    private lateinit var messageEditText: EditText

    /**
     * onCreateView wird aufgerufen, um das Layout für das Fragment zu erstellen.
     *
     * @param inflater LayoutInflater-Objekt, das zum Aufblasen des Layouts verwendet wird.
     * @param container Container für das Fragment.
     * @param savedInstanceState Bundle, das den Zustand des Fragments speichert.
     * @return Die erstellte View für das Fragment.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Layout für das Fragment aufblasen.
        val view = inflater.inflate(
            R.layout.fragment_chats_detail, container,
            false
        )

        // Initialisierung des RecyclerView für Nachrichten.
        recyclerView = view.findViewById(R.id.recycler_view_messages)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Zugriff auf die MainActivity und deren Datenquelle.
        val mainActivity = activity as MainActivity
        val dataSource = mainActivity.datasource

        // Empfangen der Argumente, die an das Fragment übergeben wurden.
        val args: ChatsDetailFragmentArgs by navArgs()
        val chatIndex = args.chatIndex

        // Nachrichten für den spezifischen Chat aus der Datenquelle abrufen.
        val messages = dataSource.getMessagesForChat(chatIndex.toInt())

        // Initialisierung des MessageAdapters und Setzen als Adapter des RecyclerView.
        messageAdapter = MessageAdapter(messages)
        recyclerView.adapter = messageAdapter

        // Initialisierung der UI-Komponenten für das Senden von Nachrichten.
        sendMessageButton = view.findViewById(R.id.button_chatbox_send)
        messageEditText = view.findViewById(R.id.edittext_chatbox)

        // Setzen eines ClickListeners auf den Senden-Button.
        sendMessageButton.setOnClickListener {
            val messageText = messageEditText.text.toString()
            if (messageText.isNotEmpty()) {

                // Erstellung und Hinzufügen einer neuen Nachricht zur Datenquelle.
                val newMessage = Message(messageText, incoming = false)
                dataSource.addMessageToChat(chatIndex.toInt(), newMessage)


                // Aktualisierung des MessageAdapters und der RecyclerView.
                val messageList = dataSource.getMessagesForChat(
                    chatIndex.toInt()
                )
                messageAdapter.notifyItemInserted(messageList.size - 1)

                // Leeren des Eingabefelds und Scrollen zum Ende der Nachrichtenliste.
                messageEditText.text.clear()
                recyclerView.scrollToPosition(messageList.size - 1)
            }
        }

        return view
    }


}

/**
 *Zusammenfassung des ChatsDetailFragment-Codes
 * Das ChatsDetailFragment ist für die Anzeige und Interaktion innerhalb eines spezifischen
 * Chat-Fensters in deiner Messaging-App zuständig. Es enthält Elemente zum Anzeigen von Nachrichten
 * und zur Eingabe neuer Nachrichten. Der Hauptteil des Codes umfasst:
 *
 * Layout-Initialisierung (onCreateView): Hier wird das Layout für das Detail-Chat-Fenster erstellt,
 *                                        einschließlich eines RecyclerView für die Nachrichten und
 *                                        eines EditText zum Eingeben neuer Nachrichten.
 *
 * Nachrichten-Laden und Adapter-Initialisierung: Der Code lädt die Nachrichten für einen
 *                                                spezifischen Chat und initialisiert den
 *                                                MessageAdapter für den RecyclerView, der für die
 *                                                Darstellung der Nachrichten zuständig ist.
 *
 * Nachrichten-Senden-Logik: Ein Button für das Senden von Nachrichten wird mit einem
 *                           OnClickListener versehen, der neue Nachrichten zur Nachrichtenliste
 *                           hinzufügt und die Ansicht aktualisiert.
 *
 * Analogie zu jeder Komponente
 * Layout-Initialisierung (onCreateView): Stelle dir vor, du betrittst ein Postamt, um einen Brief
 *                                        zu verschicken. Das Postamt (ChatsDetailFragment) hat
 *                                        Schalter (UI-Elemente) für das Schreiben (Eingabefeld) und
 *                                        das Anzeigen von bereits versendeten Briefen
 *                                        (Nachrichten-Liste).
 *
 * Nachrichten-Laden und Adapter-Initialisierung: Das ist vergleichbar mit dem Öffnen eines
 *                                                Postfachs, um zu sehen, welche Briefe
 *                                                (Nachrichten) du bereits erhalten hast.
 *                                                Der MessageAdapter ist wie der Postbeamte,
 *                                                der entscheidet, wie die Briefe in deinem
 *                                                Fach angeordnet werden.
 *
 * Nachrichten-Senden-Logik: Das Senden einer Nachricht ist wie das Schreiben eines Briefes und das
 *                           Einwerfen in den Briefkasten. Der sendMessageButton ist der
 *                           Briefkasten. Wenn du einen Brief (Nachricht) einwirfst, fügt der
 *                           Postbeamte (Adapter) diesen zu deinen anderen Briefen hinzu und zeigt
 *                           dir das aktualisierte Postfach an.
 */
