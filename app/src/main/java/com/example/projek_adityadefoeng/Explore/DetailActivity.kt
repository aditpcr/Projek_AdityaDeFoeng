package com.example.projek_adityadefoeng.Explore

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projek_adityadefoeng.DestinationData
import com.example.projek_adityadefoeng.R
import com.example.projek_adityadefoeng.TopBarHelper

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DESTINATION_ID = "extra_destination_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        TopBarHelper.setup(this)

        val id = intent.getIntExtra(EXTRA_DESTINATION_ID, -1)
        val destination = DestinationData.findById(id)
        if (destination == null) {   // id tidak valid -> tutup halaman
            finish()
            return
        }

        findViewById<ImageView>(R.id.ivBackground).setImageResource(destination.imageRes)
        findViewById<TextView>(R.id.tvName).text = destination.name
        findViewById<TextView>(R.id.tvLocation).text = destination.location
        findViewById<RatingBar>(R.id.ratingBar).rating = destination.rating
        findViewById<TextView>(R.id.tvAbout).text = destination.about
        findViewById<TextView>(R.id.tvTips).text = destination.tips
        findViewById<TextView>(R.id.tvBestTime).text = destination.bestTime
    }
}