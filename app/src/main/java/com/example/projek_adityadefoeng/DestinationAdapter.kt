package com.example.projek_adityadefoeng

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DestinationAdapter(
    private val items: List<Destination>,
    private val onItemClick: (Destination) -> Unit
) : RecyclerView.Adapter<DestinationAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivDestination: ImageView = view.findViewById(R.id.ivDestination)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvLocation: TextView = view.findViewById(R.id.tvLocation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_destination, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.ivDestination.setImageResource(item.imageRes)
        holder.tvName.text = item.name
        holder.tvLocation.text = item.location
        holder.itemView.setOnClickListener { onItemClick(item) }
    }

    override fun getItemCount(): Int = items.size
}