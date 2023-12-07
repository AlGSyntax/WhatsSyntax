package c.s.w.adapter

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.data.model.Chat
import com.syntax_institut.whatssyntax.data.model.Contact


// ...

class ItemAdapter(
    private val dataSet: List<Chat>,
    private val isStatusFragment: Boolean,
    private val chatClickListener: ((contact: Contact) -> Unit)? // Nehme an, dass der Listener die chatId als Parameter erwartet
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contactName: TextView = view.findViewById(R.id.textView_contact_name)
        val lastMessage: TextView = view.findViewById(R.id.textView_last_message)
        val profileImage: ImageView = view.findViewById(R.id.imageView_profile)

        init {
            if (!isStatusFragment) {
                view.setOnClickListener {
                    // Der Klick-Listener wird nur im ChatsFragment verwendet, daher ist dies sicher
                    chatClickListener?.invoke(dataSet[adapterPosition].contact) // Angenommen, Chat hat eine id-Eigenschaft
                }
            }
        }

        fun bind(chat: Chat) {
            contactName.text = chat.contact.name
            profileImage.setImageResource(chat.contact.image)

            if (chat.messages.isNotEmpty()) {
                lastMessage.text = chat.messages.last().text
                lastMessage.visibility = View.VISIBLE
            } else {
                lastMessage.visibility = View.GONE
                if (isStatusFragment) {
                    profileImage.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY) // Für Status ohne Nachrichten
                }
            }

            if (isStatusFragment && chat.contact.status != null) {
                itemView.setOnClickListener {
                    // Hier wird der StatusFragment-spezifische Klick-Listener aufgerufen
                    // Es wird angenommen, dass der StatusFragment-Listener keinen Parameter erwartet
                    chatClickListener?.invoke(chat.contact) // Angenommen, Chat hat eine id-Eigenschaft
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size
}


/**
 *
 *
 * Erklärung des ItemAdapter-Codes:
 *
 * Der `ItemAdapter` in deiner App ist wie ein spezialisierter Aussteller in einem Laden,
 * der verschiedene Produkte (hier Chats und Kontakte) in Regalen anzeigt. Er nimmt eine Liste
 * von Objekten und zeigt sie in einer strukturierten und interaktiven Weise an.
 *
 *
 *
 * Analogie:
 *
 * Stelle dir vor, der `ItemAdapter` ist wie ein Schaufenster in einem modernen Geschäft.
 * In dieser Analogie ist der `ItemAdapter` wie ein geschickter Schaufensterdekorateur,
 * der genau weiß, wie man Produkte ansprechend präsentiert und auf die Interaktion der Kunden
 * vorbereitet. Jeder Teil des Codes spielt eine Rolle dabei, wie die Produkte (Chats und Kontakte)
 * im Schaufenster deiner App angezeigt und behandelt werden.
 *
 * 1.Konstruktion des Schaufensters (ItemAdapter): Der `ItemAdapter` ist das Schaufenster selbst.
 *                                                 Es hat verschiedene Abschnitte (ViewHolder) für
 *                                                 verschiedene Arten von Produkten
 *                                                 (Chats und Kontakte). Die Parameter (`dataSet`,
 *                                                 `isStatusFragment`, `clickListener`) sind wie die
 *                                                 Anweisungen, die du bekommst, um das Schaufenster
 *                                                 einzurichten: Welche Produkte sollst du zeigen?
 *                                                 Wie sollen sie präsentiert werden? Was passiert,
 *                                                 wenn ein Kunde ein Produkt auswählt?
 *
 * 2.Einrichten der Produkte (ViewHolder und bind-Methode): Jedes Produkt wird sorgfältig auf einem
 *                                                          eigenen Podest (ViewHolder) platziert.
 *                                                          Die `bind`-Methode im `ViewHolder` ist,
 *                                                          als würdest du jedes Produkt
 *                                                          (jeden Chat/Kontakt) arrangieren,
 *                                                          sodass es ansprechend aussieht.
 *                                                          Du stellst den Namen des Produkts
 *                                                          (Kontaktname), ein Bild (Profilbild)
 *                                                          und eine kurze Beschreibung
 *                                                          (letzte Nachricht) aus.
 *
 * 3.Interaktion mit den Produkten: Wenn ein Kunde (Benutzer) ein Produkt (Kontakt) im Schaufenster
 *                                 (RecyclerView) auswählt, wird eine Aktion ausgelöst, z.B. das
 *                                 Öffnen einer Detailansicht des Produkts. Dies wird durch den
 *                                 `clickListener` ermöglicht, der wie ein Sensor im Schaufenster
 *                                 ist, der auf die Auswahl eines Kunden reagiert.
 *
 * 4.Anpassung je nach Schaufenster (StatusFragment vs. ChatFragment): Abhängig davon, ob du im
 *                                                                     StatusFragment oder
 *                                                                     ChatFragment bist, ändert
 *                                                                     sich die Art, wie die
 *                                                                     Produkte präsentiert werden.
 *                                                                     Im StatusFragment könnten
 *                                                                     einige Produkte
 *                                                                     (Kontakte ohne Status) mit
 *                                                                     einem Graufilter versehen
 *                                                                     sein, um zu zeigen, dass sie
 *                                                                     momentan weniger relevant
 *                                                                     sind.
 *
 * 5.Erstellen neuer Podeste (onCreateViewHolder): Wenn ein neues Produkt ins Schaufenster muss,
 *                                                 baust du ein neues Podest (ViewHolder). Das ist,
 *                                                 als würdest du ein neues Regal oder einen neuen
 *                                                 Ständer im Schaufenster aufbauen,
 *                                                 um das Produkt darauf zu platzieren.
 *
 * 6.Platzieren der Produkte (onBindViewHolder): Hier legst du jedes Produkt auf sein Podest. Du
 *                                               nimmst ein Produkt aus deinem Lager (dataSet), und
 *                                               platzierst es an der richtigen Stelle im
 *                                               Schaufenster.
 *
 *
 *
 *Zusammengefasste Erklärung des Codes:
 *  *
 *  * - onCreateViewHolder: Diese Methode ist wie das Vorbereiten eines leeren Rahmens, bevor ein
 *                          Kunstwerk platziert wird. Es schafft ein neues Element-Layout für die
 *                          kommenden Daten.
 *  *
 *  * - onBindViewHolder: Hier erhält jeder Rahmen (ViewHolder) tatsächlich ein Kunstwerk
 *                        (Daten eines Anrufs). Der Adapter füllt jedes Element mit Inhalten -
 *                        er setzt den Namen, die Zeit und das passende Bild für den Anruftyp.
 *  *
 *  * - getItemCount: Diese Methode sagt dem Kurator (Adapter),wie viele Kunstwerke (Anrufe) es
 *                    insgesamt gibt, sodass er weiß, wie viele Rahmen (ViewHolders) er vorbereiten
 *                    muss.
 *
 *
 *
 *
 * Erklärung eines spezifischen Code-Abschnitts der durch Eigenrecherche entstanden ist:
 *
 * Dieser Teil des Codes in meinem `ItemAdapter` betrifft die Darstellung der Profilbilder in meiner
 * App, je nachdem, ob ein Kontakt einen Status hat oder nicht.
 *
 *
 * if (chat.contact.status == null) {
 *     profileImage.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY)
 * } else {
 *}
 *
 *
 * 1.if (chat.contact.status == null): Hier wird überprüft, ob der Kontakt, der dem Chat zugeordnet
 *                                     ist, einen Status hat. Das `== null` bedeutet,
 *                                     dass du prüfst, ob kein Status vorhanden ist.
 *
 * 2.profileImage.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY): Wenn der Kontakt keinen
 *                                                                      Status hat, wird ein
 *                                                                      Graufilter auf das
 *                                                                      Profilbild des Kontakts
 *                                                                      angewendet. Dies ändert die
 *                                                                      Darstellung des Bildes,
 *                                                                      indem es in Grautönen
 *                                                                      angezeigt wird, was
 *                                                                      symbolisiert, dass kein
 *                                                                      Status vorhanden ist.
 *
 * Analogie:
 *
 * Stell dir vor, du bist in einer Kunstgalerie, und jedes Kunstwerk (Profilbild) repräsentiert
 * einen Künstler (Kontakt). Jedes Kunstwerk hat neben sich eine kleine Lampe.
 * Diese Analogie hilft zu veranschaulichen, wie der Code die visuelle Darstellung von Kontakten in
 * deiner App steuert, basierend darauf, ob sie aktive Statusmeldungen haben oder nicht.
 * Es ist eine subtile, aber effektive Weise, dem Nutzer visuelles Feedback über den Status eines
 * Kontakts zu geben.
 *
 * -Wenn ein Künstler aktuell keine Ausstellung hat (kein Status): Die Lampe über dem Kunstwerk
 *                                                                 schaltet auf ein gedämpftes,
 *                                                                 graues Licht um.
 *                                                                 Das symbolisiert, dass der
 *                                                                 Künstler momentan nichts Neues zu
 *                                                                 zeigen hat.
 *                                                                 In deiner App entspricht das dem
 *                                                                 Anwenden des Graufilters auf das
 *                                                                 Profilbild.
 *
 * -Wenn der Künstler eine laufende Ausstellung hat (Status vorhanden): Die Lampe bleibt hell und
 *                                                                      farbig, was zeigt, dass der
 *                                                                      Künstler aktiv und seine
 *                                                                      Werke von besonderem
 *                                                                      Interesse sind. In deiner
 *                                                                      App bedeutet das, dass kein
 *                                                                      Graufilter angewendet wird,
 *                                                                      und das Profilbild bleibt
 *                                                                      in seinen normalen Farben.
 *
 *
 *
 */