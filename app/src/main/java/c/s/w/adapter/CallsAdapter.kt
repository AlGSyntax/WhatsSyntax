package c.s.w.adapter

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

class CallsAdapter(private val callList: List<Call>, private val clickListener: (Call) -> Unit) :
    RecyclerView.Adapter<CallsAdapter.ViewHolder>() {

    // ViewHolder und die anderen notwendigen Methoden

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val contactName: TextView = view.findViewById(R.id.textView_contact_name)
        private val callInfo: TextView = view.findViewById(R.id.textView_call_info)
        private val callIcon: ImageView = view.findViewById(R.id.imageView_call_status)

        fun bind(call: Call) {
            contactName.text = call.contact.name
            callInfo.text = call.time

            // Logik für die Anzeige des richtigen Icons
            val icon = when {
                call.incoming && call.accepted -> R.drawable.icon_call_accepted
                call.incoming && !call.accepted -> R.drawable.icon_call_missed
                !call.incoming && call.accepted -> R.drawable.icon_call_accepted
                !call.incoming && !call.accepted -> R.drawable.icon_call_missed
                else -> R.drawable.icon_call_missed // oder irgendein Standard-Icon
            }

            // Setze das Icon und rotiere es gegebenenfalls
            callIcon.setImageResource(icon)
            if (call.incoming && call.accepted) {
                // Standardrotation für angenommene eingehende Anrufe
                callIcon.rotation = 0f
            } else if (!call.incoming && call.accepted) {
                // Rotiere den grünen Pfeil nach unten für angenommene ausgehende Anrufe
                callIcon.rotation = 180f
            } else {
                // Keine Rotation für verpasste Anrufe
                callIcon.rotation = 0f
            }

            itemView.setOnClickListener {
                // Erstellen eines impliziten Intents mit der ACTION_DIAL-Aktion
                val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                    // Füge die Telefonnummer als Daten zum Intent hinzu.
                    // Verwende 'Uri.parse' um eine URI mit der Telefonnummer zu erstellen.
                    data = Uri.parse("tel:${call.contact.number}")
                }

                // Stelle sicher, dass eine App vorhanden ist, die den Intent verarbeiten kann,
                // bevor du versuchst, ihn zu starten.
                itemView.context.startActivity(dialIntent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.call_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(callList[position])
    }


    // onCreateViewHolder und onBindViewHolder Methoden

    override fun getItemCount() = callList.size
}
