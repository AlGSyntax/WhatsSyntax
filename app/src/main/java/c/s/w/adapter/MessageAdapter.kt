package c.s.w.adapter

// Import-Anweisungen für benötigte Klassen und Bibliotheken.
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.data.model.Message


/**
 * MessageAdapter für die Darstellung von Nachrichten in einem RecyclerView.
 *
 * @param messages Eine Liste von Nachrichtenobjekten, die im RecyclerView angezeigt werden sollen.
 */
class MessageAdapter(private val messages: MutableList<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    // Konstanten für die Unterscheidung von eingehenden und ausgehenden Nachrichten.
    companion object {
        const val VIEW_TYPE_INCOMING = 1
        const val VIEW_TYPE_OUTGOING = 2
    }

    /**
     * Bestimmt den Typ der Ansicht basierend auf der Position der Nachricht in der Liste.
     *
     * @param position Position der Nachricht in der Liste.
     * @return Den View-Typ (eingehend oder ausgehend) für die Nachricht.
     */
    override fun getItemViewType(position: Int): Int {
        return if (messages[position].incoming) VIEW_TYPE_INCOMING else VIEW_TYPE_OUTGOING
    }


    /**
     * Erstellt neue ViewHolder für eingehende oder ausgehende Nachrichten.
     *
     * @param parent Die ViewGroup, in der der neue ViewHolder gehalten wird.
     * @param viewType Der Typ der Ansicht, die erstellt werden soll.
     * @return Einen neuen ViewHolder für eingehende oder ausgehende Nachrichten.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        // LayoutInflater wird verwendet, um XML-Layouts in View-Objekte umzuwandeln.
        val layoutInflater = LayoutInflater.from(parent.context)

        // Überprüft den Typ der Nachricht (eingehend oder ausgehend) und wählt das entsprechende
        // Layout.
        return if (viewType == VIEW_TYPE_INCOMING) {

            // Lädt das Layout für eingehende Nachrichten und erstellt einen ViewHolder dafür.
            val view = layoutInflater.inflate(
                R.layout.item_message_incoming, parent,
                false
            )
            IncomingMessageViewHolder(view)
        } else {

            // Lädt das Layout für ausgehende Nachrichten und erstellt einen ViewHolder dafür.
            val view = layoutInflater.inflate(
                R.layout.item_message_outgoing, parent,
                false
            )
            OutgoingMessageViewHolder(view)
        }
    }

    /**
     * Bindet die Nachrichtendaten an den entsprechenden ViewHolder.
     *
     * @param holder Der ViewHolder, der die Nachrichtendaten halten soll.
     * @param position Die Position der Nachricht in der Liste.
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        // Holt die Nachricht an der gegebenen Position in der Liste.
        val message = messages[position]

        // Überprüft den Typ des ViewHolders und bindet die Nachrichtendaten daran.
        if (holder is IncomingMessageViewHolder) {
            // Für eingehende Nachrichten wird die bind-Methode des IncomingMessageViewHolder
            // aufgerufen.
            holder.bind(message)
        } else if (holder is OutgoingMessageViewHolder) {
            // Für ausgehende Nachrichten wird die bind-Methode des OutgoingMessageViewHolder
            // aufgerufen.
            holder.bind(message)
        }
    }

    /**
     * Gibt die Gesamtanzahl der Nachrichten in der Liste zurück.
     *
     * @return Die Anzahl der Nachrichten in der Liste.
     */
    override fun getItemCount() = messages.size


    /**
     * ViewHolder für eingehende Nachrichten.
     *
     * @param view Die Ansicht für eingehende Nachrichten.
     */
    class IncomingMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val messageTextView: TextView = view.findViewById(R.id.text_view_message_incoming)

        /**
         * Bindet eine eingehende Nachricht an die Ansicht.
         *
         * @param message Das Nachrichtenobjekt, das an die Ansicht gebunden werden soll.
         */
        fun bind(message: Message) {
            messageTextView.text = message.text
        }
    }

    /**
     * ViewHolder für ausgehende Nachrichten.
     *
     * @param view Die Ansicht für ausgehende Nachrichten.
     */
    class OutgoingMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val messageTextView: TextView = view.findViewById(R.id.text_view_message_outgoing)

        /**
         * Bindet eine ausgehende Nachricht an die Ansicht.
         *
         * @param message Das Nachrichtenobjekt, das an die Ansicht gebunden werden soll.
         */
        fun bind(message: Message) {
            messageTextView.text = message.text
        }
    }
}

/**
 * Zusammenfassung des MessageAdapter-Codes
 * Der MessageAdapter ist ein spezialisierter Adapter für die RecyclerView, der in deinem
 * ChatsDetailFragment verwendet wird, um Nachrichten anzuzeigen. Der Adapter unterscheidet zwischen
 * eingehenden und ausgehenden Nachrichten und zeigt sie entsprechend an. Die Schlüsselmethoden und
 * ihre Funktionen sind:
 *
 * getItemViewType: Bestimmt, ob eine Nachricht eingehend oder ausgehend ist, basierend auf ihrer
 *                  Position in der Nachrichtenliste.
 *
 * onCreateViewHolder: Erstellt neue ViewHolder für jede Nachricht, je nachdem, ob sie eingehend
 *                     oder ausgehend ist.
 *
 * onBindViewHolder: Bindet die Nachrichtendaten an den entsprechenden ViewHolder.
 *
 * getItemCount: Gibt die Gesamtzahl der Nachrichten in der Liste zurück.
 *
 * IncomingMessageViewHolder und OutgoingMessageViewHolder: Zwei interne Klassen, die die
 *                                                          Darstellung für eingehende bzw.
 *                                                          ausgehende Nachrichten definieren.
 *
 * Analogie zu jeder Methode
 * getItemViewType: Stell dir vor, du sortierst Briefe in deinem Postfach. Du prüfst jeden Brief
 *                 (Nachricht), um festzustellen, ob er von jemand anderem gesendet wurde
 *                 (eingehend) oder von dir selbst (ausgehend).
 *
 * onCreateViewHolder: Dies ist wie das Auswählen eines Briefumschlags für deine Briefe.
 *                     Abhängig davon, ob es ein eingehender oder ausgehender Brief ist,
 *                     wählst du einen blauen oder roten Umschlag (entsprechendes Layout).
 *
 * onBindViewHolder: Hier legst du den Brief (Nachricht) in den ausgewählten Umschlag.
 *                   Der Umschlag (ViewHolder) präsentiert den Inhalt des Briefes auf die
 *                   richtige Weise.
 *
 * getItemCount: Das ist, als würdest du zählen, wie viele Briefe du in deinem Postfach hast.
 *
 * IncomingMessageViewHolder und OutgoingMessageViewHolder: Diese sind vergleichbar mit
 *                                                          spezialisierten Briefträgern.
 *                                                          Einer kümmert sich nur um eingehende,
 *                                                          der andere nur um ausgehende Briefe,
 *                                                          und jeder weiß genau, wie er seinen
 *                                                          jeweiligen Brieftyp behandeln muss.
 *
 *  Was hat es mit dem Companion Objekt auf sich ?
 *
 *   Ein `Companion Object` ist ein spezieller Typ von Objekt, das innerhalb einer Klasse definiert
 *   wird und dessen Eigenschaften und Funktionen ohne eine Instanz dieser Klasse aufgerufen werden
 *   können.
 *
 *
 *   In deinem `MessageAdapter`-Code wurden Companion Objects folgendermaßen verwendet:
 *
 * ```kotlin
 * companion object {
 *     const val VIEW_TYPE_INCOMING = 1
 *     const val VIEW_TYPE_OUTGOING = 2
 * }
 * ```
 *
 * Hier definierst du zwei Konstanten (`VIEW_TYPE_INCOMING` und `VIEW_TYPE_OUTGOING`), die
 * verwendet werden, um zu bestimmen, ob eine Nachricht eingehend oder ausgehend ist. Da diese
 * Konstanten innerhalb eines Companion Objects definiert sind, können sie überall innerhalb
 * deiner Klasse ohne die Notwendigkeit einer Instanz der `MessageAdapter`-Klasse verwendet werden.
 *
 *  Vorteile von Companion Objects
 *
 * 1. Klassenweite Felder und Methoden: Companion Objects ermöglichen es dir, Felder und
 *                                          Methoden zu definieren, die auf Klassenebene und
 *                                          nicht auf Instanzebene vorhanden sind. Das bedeutet,
 *                                          sie gehören zur Klasse selbst und nicht zu einem
 *                                          bestimmten Objekt dieser Klasse.
 *
 * 2. Einfacher Zugriff: Werte und Funktionen innerhalb eines Companion Objects können direkt über
 *                       den Klassennamen aufgerufen werden, was den Zugriff vereinfacht und klarer
 *                       macht, dass es sich um klassenweite Eigenschaften handelt.
 *
 * 3. Implementierung von Interfaces: Ein Companion Object kann ein Interface implementieren,
 *                                    was bei statischen Methoden in Java nicht möglich ist.
 *                                    Das ermöglicht es Companion Objects, sich an bestimmte
 *                                    Schnittstellen zu halten und bietet mehr Flexibilität
 *                                    in der Verwendung.
 *
 * 4. **Singleton-Muster**: Da es von jedem Companion Object nur eine einzige Instanz gibt, eignen
 *                          sie sich gut für die Umsetzung des Singleton-Designmusters in Kotlin.
 *
 * In meinem speziellen Fall ist der Hauptvorteil der Verwendung des Companion Objects die
 * klare und saubere Organisation deiner Code-Basis. Die Konstanten "VIEW_TYPE_INCOMING" und
 * "VIEW_TYPE_OUTGOING" sind eng mit der "MessageAdapter"-Klasse verbunden, aber da sie allgemein
 * und unveränderlich sind, macht es Sinn, sie als Teil eines Companion Objects zu definieren.
 *
 */
