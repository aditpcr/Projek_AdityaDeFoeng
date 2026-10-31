package com.example.projek_adityadefoeng

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.PopupMenu
import com.example.projek_adityadefoeng.Tutorial.TutorialMessageActivity

object TopBarHelper {

    private const val TRAVELOKA_URL = "https://www.traveloka.com"

    fun setup(activity: Activity) {
        val root = activity.findViewById<View>(R.id.main)
            ?: activity.findViewById<View>(android.R.id.content)
            ?: activity.window.decorView
        setup(root, activity)
    }

    fun setup(view: View, activity: Activity) {
        val container = view.findViewById<View>(R.id.topBar) ?: view
        container.bringToFront()

        val ivLogo = container.findViewById<ImageView>(R.id.ivLogoSmall)
        val ivMenu = container.findViewById<ImageView>(R.id.ivMenu)
        val btnOrder = container.findViewById<View>(R.id.btnOrder)

        btnOrder?.setOnClickListener {
            Toast.makeText(activity, "Opening Traveloka...", Toast.LENGTH_SHORT).show()
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TRAVELOKA_URL))
                activity.startActivity(intent)
            } catch (_: Exception) {
                Toast.makeText(activity, "Unable to open browser", Toast.LENGTH_SHORT).show()
            }
        }

        ivLogo?.setOnClickListener {
            Toast.makeText(activity, "Going Home...", Toast.LENGTH_SHORT).show()
            if (activity is BaseActivity) {
                activity.selectHomeTab()
            } else {
                val intent = Intent(activity, BaseActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                }
                activity.startActivity(intent)
            }
        }

        ivMenu?.setOnClickListener { anchor ->
            val contextWrapper = ContextThemeWrapper(activity, R.style.Theme_Projek_AdityaDeFoeng)
            val popup = PopupMenu(contextWrapper, anchor)
            popup.menuInflater.inflate(R.menu.menu_top_bar, popup.menu)
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_tutorial -> {
                        val intent = Intent(activity, TutorialMessageActivity::class.java)
                        activity.startActivity(intent)
                        true
                    }
                    R.id.action_logout -> {
                        showLogoutConfirmationDialog(activity)
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }
    }

    private fun showLogoutConfirmationDialog(activity: Activity) {
        AlertDialog.Builder(activity)
            .setTitle("Logout")
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton("Yes") { _, _ ->
                logout(activity)
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun logout(activity: Activity) {
        activity.getSharedPreferences("user_pref", Context.MODE_PRIVATE)
            .edit()
            .clear()
            .apply()

        val intent = Intent(activity, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        activity.startActivity(intent)
        activity.finish()
    }
}