package c.s.w.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.data.model.Chat

class ItemAdapter(private val dataSet: List<Chat>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contactName: TextView = view.findViewById(R.id.textView_contact_name)
        val lastMessage: TextView = view.findViewById(R.id.textView_last_message)
        val profileImage: ImageView = view.findViewById(R.id.imageView_profile)

        fun bind(chat: Chat) {
            contactName.text = chat.contact.name
            lastMessage.text = chat.messages.last().text
            profileImage.setImageResource(chat.contact.image) // Hier das Profilbild setzen
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size
}
