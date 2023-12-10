package c.s.w.adapter

// Import-Anweisungen für benötigte Klassen und Bibliotheken.
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.data.model.Call
import com.syntax_institut.whatssyntax.R


/**
 * Adapter für die RecyclerView, der Anrufdaten darstellt.
 *
 * @param callList: Liste von Anrufdaten, die angezeigt werden sollen.
 * @param clickListener: Lambda-Funktion, die bei einem Klick auf ein Item ausgelöst wird.
 */
class CallsAdapter(private val callList: List<Call>, private val clickListener: (Call) -> Unit) :
    RecyclerView.Adapter<CallsAdapter.ViewHolder>() {

    /**
     * ViewHolder-Klasse, die für das Halten der View-Referenzen verantwortlich ist und das
     * Binden der Daten an die Views übernimmt.
     *
     * @param view: Die View, in der die Anrufinformationen angezeigt werden.
     */

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val contactName: TextView = view.findViewById(R.id.textView_contact_name)
        private val callInfo: TextView = view.findViewById(R.id.textView_call_info)
        private val callIcon: ImageView = view.findViewById(R.id.imageView_call_status)

        /**
         * Bindet die Anrufdaten an die entsprechenden Views.
         *
         * @param call: Das Anruf-Objekt, das die darzustellenden Daten enthält.
         */
        fun bind(call: Call) {
            contactName.text = call.contact.name
            callInfo.text = call.time

            // Entscheidet, welches Icon basierend auf dem Anrufsstatus gesetzt werden soll.
            // Grün für angenommene Anrufe, Rot für verpasste.
            val icon = when {
                call.incoming && call.accepted -> R.drawable.icon_call_accepted
                call.incoming && !call.accepted -> R.drawable.icon_call_missed
                !call.incoming && call.accepted -> R.drawable.icon_call_accepted
                !call.incoming && !call.accepted -> R.drawable.icon_call_missed
                else -> R.drawable.icon_call_missed // oder irgendein Standard-Icon
            }

            // Setzt das Icon.
            callIcon.setImageResource(icon)
            // Wendet eine Drehung auf das Icon an , wenn nötig.
            if (call.incoming && call.accepted) {
                // Standardrotation für angenommene eingehende Anrufe
                callIcon.rotation = 0f // Keine Drehung für angenommene eingehende Anrufe
            } else if (!call.incoming && call.accepted) {
                // Rotiere den grünen Pfeil nach unten für angenommene ausgehende Anrufe
                callIcon.rotation = 180f // Umkehrung für angenommene ausgehende Anrufe
            } else {
                // Keine Rotation für verpasste Anrufe
                callIcon.rotation = 0f // Keine Drehung für verpasste Anrufe
            }
            //Setzt einen Klick-Listener auf das gesamte Item
            itemView.setOnClickListener {
                // Erstellen eines impliziten Intents mit der ACTION_DIAL-Aktion
                val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                    // Füge die Telefonnummer als Daten zum Intent hinzu.
                    // Verwende 'Uri.parse' um eine URI mit der Telefonnummer zu erstellen.
                    data = Uri.parse("tel:${call.contact.number}")
                }

                // Stellt sicher, dass eine App vorhanden ist, die den Intent verarbeiten kann,
                // bevor man versucht ihn zu starten.
                itemView.context.startActivity(dialIntent)
            }
        }
    }


    /**
     * Erstellt einen neuen ViewHolder, wenn der RecyclerView ein neues Item benötigt.
     *
     * @param parent: Die ViewGroup, in der neue View eingefügt wird.
     *
     * @param viewType: Der View-Typ des neuen Views.
     *
     * @return : Eine neue Instanz von ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.call_item, parent, false)
        return ViewHolder(view)
    }


    /**
     * Bindet die Daten an einen bestehenden ViewHolder.
     *
     * @param holder : Der ViewHolder, der die Daten halten soll.
     *
     * @param position : Die Position des Items im Adapter.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(callList[position])
    }


    /**
     * Gibt die Gesamtzahl der Items im Adapter zurück.
     *
     * @return : Die Größe der Anrufliste.
     */

    override fun getItemCount() = callList.size
}


/**
 *
 *
 * Erklärung des Codes:
 *
 * Der `CallsAdapter` ist eine Komponente in deiner Android-App, die als Mittler zwischen deiner
 * Anrufdatenliste und der visuellen Darstellung dieser Daten in einer Liste oder einem Gitter auf
 * dem Bildschirm fungiert. Er nimmt die Daten (Anrufe) und entscheidet, wie sie in jedem Element
 * (einer Zeile in deiner Liste) angezeigt werden sollen.
 *
 * Analogie:
 *
 * Jeder Teil des `CallsAdapter` trägt dazu bei, dass die Ausstellung (die Anrufliste in deiner App)
 * informativ und interaktiv gestaltet ist und die Besucher (Benutzer) eine angenehme Erfahrung
 * haben, während sie durch die Kunstwerke (Anrufliste) wandern.
 * Stelle dir den `CallsAdapter` wie einen Kurator in einem Museum vor:
 *
 * 1. Museums-Kurator (ViewHolder): Jeder `ViewHolder` ist wie ein Rahmen für ein Kunstwerk.
 *                                  Der Kurator (der `CallsAdapter`) wählt den passenden Rahmen
 *                                  (das Layout) für jedes Kunstwerk (jeden Anruf) aus und platziert
 *                                  es an der richtigen Stelle im Museum (deine RecyclerView).
 *
 * 2. Kunstwerke platzieren (bind-Methode): Der Prozess des "Bindens" ist wie das Aufhängen eines
 *                                          Kunstwerks im Rahmen. Für jedes Kunstwerk (Anruf) wählt
 *                                          der Kurator ein Bild (das Anruf-Icon) und eine
 *                                          Beschreibung (Name und Zeit des Anrufs) aus und
 *                                          arrangiert sie so, dass Besucher (Benutzer) alle
 *                                          wichtigen Informationen auf einen Blick erfassen können.
 *
 * 3. Bilder auswählen (Icon-Logik): Der Kurator entscheidet, welches Bild am besten zu dem
 *                                   Kunstwerk passt. Eingehende, angenommene Anrufe bekommen ein
 *                                   grünes Bild (icon_call_accepted), während verpasste Anrufe ein
 *                                   rotes Bild (icon_call_missed) erhalten. Falls ein Anruf
 *                                   ausgehend und angenommen ist, wird das grüne Bild "gedreht"
 *                                   (180 Grad rotiert), um anzuzeigen, dass es eine andere Art von
 *                                   Anruf darstellt.
 *
 * 4. Interaktion mit den Kunstwerken (OnClickListener): Wenn ein Besucher ein Kunstwerk
 *                                                       (Anruf-Element) auswählt, kann er mehr
 *                                                       darüber erfahren. Im Fall des
 *                                                       `CallsAdapter` wird durch das Tippen auf
 *                                                       das Kunstwerk
 *                                                       (das Antippen eines Anruf-Elements) ein
 *                                                       Telefonwähler geöffnet, mit dem der
 *                                                       Besucher (Benutzer) die Nummer direkt
 *                                                       wählen kann.
 *
 *  Zusammengefasste Erklärung des Codes:
 *
 * - onCreateViewHolder: Diese Methode ist wie das Vorbereiten eines leeren Rahmens,
 *                       bevor ein Kunstwerk platziert wird. Es schafft ein neues Element-Layout
 *                       für die kommenden Daten.
 *
 * - onBindViewHolder: Hier erhält jeder Rahmen (ViewHolder) tatsächlich ein Kunstwerk
 *                     (Daten eines Anrufs). Der Adapter füllt jedes Element mit Inhalten - er setzt
 *                     den Namen, die Zeit und das passende Bild für den Anruftyp.
 *
 * - getItemCount: Diese Methode sagt dem Kurator (Adapter), wie viele Kunstwerke (Anrufe) es
 *                 insgesamt gibt, sodass er weiß, wie viele Rahmen (ViewHolders) er vorbereiten
 *                 muss.
 *
 *
 */