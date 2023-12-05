package com.syntax_institut.whatssyntax

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class StatusDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_status_detail, container, false)

        val statusMessage = arguments?.getString("status_message")
        view.findViewById<TextView>(R.id.textView_status_message).text = statusMessage

        return view
    }
}
