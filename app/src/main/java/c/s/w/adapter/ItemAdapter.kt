package c.s.w.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.data.model.Chat


/**
 * Ein Adapter für die RecyclerView, der eine Liste von Chat-Objekten anzeigt.
 *
 * @property dataSet : Die Datenliste, die der Adapter verwaltet. Jedes Element der Liste
 * ist ein Chat-Objekt-
 */
class ItemAdapter(private val dataSet: List<Chat>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {


    /**
     * Ein ViewHolder stellt eine einzelne Zeile/Element in der RecyclerView dar.
     *
     * @param view : Das View Objekt, das die Zeile in der RecyclerView repräsentiert.
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contactName: TextView = view.findViewById(R.id.textView_contact_name)
        val lastMessage: TextView = view.findViewById(R.id.textView_last_message)
        val profileImage: ImageView = view.findViewById(R.id.imageView_profile)


        /**
         * Bindet ein Chat-Objekt an den ViewHolder , um Inhalte darzustellen.
         *
         * @param chat : Das Chat-Objekt , das an diesen ViewHolder gebunden wird.
         */
        fun bind(chat: Chat) {
            contactName.text = chat.contact.name
            lastMessage.text = chat.messages.last().text
            profileImage.setImageResource(chat.contact.image)
        }
    }


    /**
     * Wird aufgerufen, um einen neuen ViewHolder zu erstellen
     *
     * @param parent : Die ViewGroup, in dem die neue View eingefügt wird.
     * @param viewType : Der View-Typ der neuen View.
     * @return : Eine neue Instanz von ViewHolder, die das Layout für ein Element hält.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item, parent, false)
        return ViewHolder(view)
    }


    /**
     * Wird aufgerufen um die Daten an einen ViewHolder zu binden.
     *
     * @param holder : Der ViewHolder, der das Datenobjekt enthält.
     * @param position : Die Position des DatenObjekts in DataSet-Liste.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }


    /**
     * Gibt die Gesamtheit der Elemente in der Datenliste zurück.
     *
     * @return Die Größe der dataSet-Liste
     */
    override fun getItemCount() = dataSet.size
}
