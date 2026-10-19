package com.example.projek_adityadefoeng

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.ImageView
import android.widget.PopupMenu

object TopBarHelper {

    fun setup(activity: Activity) {
        val ivLogo = activity.findViewById<ImageView>(R.id.ivLogoSmall)
        val ivMenu = activity.findViewById<ImageView>(R.id.ivMenu)

        ivLogo.setOnClickListener {
            if (activity is HomeActivity) return@setOnClickListener // sudah di Home
            val intent = Intent(activity, HomeActivity::class.java).apply {
                // Tutup halaman di atas Home (Explore/Detail), jangan buat Home baru
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
            activity.startActivity(intent)
        }

        ivMenu.setOnClickListener { anchor ->
            val popup = PopupMenu(activity, anchor)
            popup.menuInflater.inflate(R.menu.menu_top_bar, popup.menu)
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_logout -> {
                        logout(activity)
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }
    }

    private fun logout(activity: Activity) {
        // Hapus sesi login. Sesuaikan dengan cara kamu menyimpan login.
        activity.getSharedPreferences("user_pref", Context.MODE_PRIVATE)
            .edit()
            .clear()
            .apply()

        val intent = Intent(activity, LoginActivity::class.java).apply {
            // Kosongkan back stack supaya tombol Back tidak kembali ke halaman sebelumnya
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        activity.startActivity(intent)
        activity.finish()
    }
}