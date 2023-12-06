package com.syntax_institut.whatssyntax

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import c.s.w.adapter.CallsAdapter
import com.syntax_institut.whatssyntax.data.Datasource

class CallFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var callsAdapter: CallsAdapter  // Hier musst du sicherstellen, dass du einen CallsAdapter hast.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_call, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view_calls)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Retrieve the list of calls from your Datasource
        val dataSource = Datasource()
        val callList = dataSource.getCalls()

        // Initialize the adapter with the list of calls and set it to the RecyclerView
        callsAdapter = CallsAdapter(callList) { call ->
            // Implement your click listener logic here
            // For example, you might want to open a dialer app or show call details
        }
        recyclerView.adapter = callsAdapter

        return view
    }

    // Add any other methods you might need to update the data, handle user interaction, etc.
}
