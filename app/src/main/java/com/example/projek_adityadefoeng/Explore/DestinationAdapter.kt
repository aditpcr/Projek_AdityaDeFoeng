package com.example.projek_adityadefoeng.Explore

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.projek_adityadefoeng.Destination
import com.example.projek_adityadefoeng.R
import com.google.android.material.snackbar.Snackbar

class DestinationAdapter(
    context: Context,
    private val destinations: List<Destination>
) : ArrayAdapter<Destination>(context, 0, destinations) {

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(
            R.layout.item_destination,
            parent,
            false
        )

        val data = destinations[position]

        val avatarImg = view.findViewById<ImageView>(R.id.avatarImg)
        val textName = view.findViewById<TextView>(R.id.textName)
        val textLocation = view.findViewById<TextView>(R.id.textLocation)

        textName.text = data.name
        textLocation.text = data.location

        if (data.imageRes != 0) {
            Glide.with(context)
                .load(data.imageRes)
                .into(avatarImg)
        } else if (data.avatarUrl.isNotEmpty()) {
            Glide.with(context)
                .load(data.avatarUrl)
                .into(avatarImg)
        }

        view.setOnClickListener {
            Snackbar.make(
                parent,
                "${data.name} is clicked",
                Snackbar.LENGTH_SHORT
            ).show()

            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DESTINATION_ID, data.id)
            context.startActivity(intent)
        }

        return view
    }
}