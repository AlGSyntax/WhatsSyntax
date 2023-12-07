package com.syntax_institut.whatssyntax.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.data.model.Message

class MessageAdapter(private val messages: MutableList<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun addMessage(message: Message) {
        messages.add(message)
        notifyItemInserted(messages.size - 1)
    }

    companion object {
        const val VIEW_TYPE_INCOMING = 1
        const val VIEW_TYPE_OUTGOING = 2
    }

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].incoming) VIEW_TYPE_INCOMING else VIEW_TYPE_OUTGOING
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_TYPE_INCOMING) {
            val view = layoutInflater.inflate(R.layout.item_message_incoming, parent, false)
            IncomingMessageViewHolder(view)
        } else {
            val view = layoutInflater.inflate(R.layout.item_message_outgoing, parent, false)
            OutgoingMessageViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messages[position]
        if (holder is IncomingMessageViewHolder) {
            holder.bind(message)
        } else if (holder is OutgoingMessageViewHolder) {
            holder.bind(message)
        }
    }

    override fun getItemCount() = messages.size

    class IncomingMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val messageTextView: TextView = view.findViewById(R.id.text_view_message_incoming)

        fun bind(message: Message) {
            messageTextView.text = message.text
        }
    }

    class OutgoingMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val messageTextView: TextView = view.findViewById(R.id.text_view_message_outgoing)

        fun bind(message: Message) {
            messageTextView.text = message.text
        }
    }
}
