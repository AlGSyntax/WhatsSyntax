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

class ItemAdapter(private val dataSet: List<Chat>, private val isStatusFragment: Boolean) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contactName: TextView = view.findViewById(R.id.textView_contact_name)
        val lastMessage: TextView = view.findViewById(R.id.textView_last_message)
        val profileImage: ImageView = view.findViewById(R.id.imageView_profile)

        fun bind(chat: Chat, isStatusFragment: Boolean) {
            contactName.text = chat.contact.name
            profileImage.setImageResource(chat.contact.image)

            if (chat.messages.isNotEmpty()) {
                lastMessage.text = chat.messages.last().text
                lastMessage.visibility = View.VISIBLE
                profileImage.clearColorFilter() // Entferne den Graufilter für Chats mit Nachrichten
            } else {
                lastMessage.visibility = View.GONE
                if (isStatusFragment) {
                    // Wende einen Graufilter an, wenn im StatusFragment und kein Status vorhanden ist
                    if (chat.contact.status == null) {
                        profileImage.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY)
                    } else {
                        profileImage.clearColorFilter()
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position], isStatusFragment)
    }

    override fun getItemCount() = dataSet.size
}
