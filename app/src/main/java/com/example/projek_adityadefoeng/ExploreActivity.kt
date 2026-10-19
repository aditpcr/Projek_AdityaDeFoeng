package com.example.projek_adityadefoeng

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class ExploreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_explore)

        TopBarHelper.setup(this)

        val rv = findViewById<RecyclerView>(R.id.rvDestinations)

        rv.adapter = DestinationAdapter(DestinationData.list) { destination ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DESTINATION_ID, destination.id)
            startActivity(intent)
        }
    }
}