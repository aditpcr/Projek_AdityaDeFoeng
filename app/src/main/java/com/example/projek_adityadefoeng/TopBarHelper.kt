package com.example.projek_adityadefoeng

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.appcompat.app.AlertDialog

object TopBarHelper {

    private const val TRAVELOKA_URL =
        "https://www.traveloka.com/en-id?id=14035715123755047605&adloc=en-id&kw=traveloka&gmt=e&gn=g&gd=c&gdm=&gcid=705639865085&gdp=&gdt=&gap=&pc=1&aid=167430873511&wid=kwd-51659214310&fid=&gid=1007727&utm_id=T4iqtkR9&ad_id=705639865085&target_id=kwd-51659214310&click_id=Cj0KCQjwrvHWBhDKARIsABmp7h0U9HnoyHApBlekuIm3BzNG_QAz_5xD1wYNtNep0xgxL_RWUf58veYaAq1EEALw_wcB&group_id=167430873511&gad_source=1&gad_campaignid=21466202329&gbraid=0AAAAADi60Ukg4Xy9KKv9LCkGbxZ2Ohadk&gclid=Cj0KCQjwrvHWBhDKARIsABmp7h0U9HnoyHApBlekuIm3BzNG_QAz_5xD1wYNtNep0xgxL_RWUf58veYaAq1EEALw_wcB"

    fun setup(activity: Activity) {
        val root = activity.findViewById<View>(android.R.id.content) ?: return
        setup(root, activity)
    }

    fun setup(view: View, activity: Activity) {
        val ivLogo = view.findViewById<ImageView>(R.id.ivLogoSmall)
        val ivMenu = view.findViewById<ImageView>(R.id.ivMenu)
        val btnOrder = view.findViewById<View>(R.id.btnOrder)

        btnOrder?.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TRAVELOKA_URL))
            activity.startActivity(intent)
        }

        ivLogo?.setOnClickListener {
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
            val popup = PopupMenu(activity, anchor)
            popup.menuInflater.inflate(R.menu.menu_top_bar, popup.menu)
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
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