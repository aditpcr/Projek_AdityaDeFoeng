package com.example.projek_adityadefoeng

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.projek_adityadefoeng.Explore.DetailFragment
import com.example.projek_adityadefoeng.Explore.ExploreFragment
import com.example.projek_adityadefoeng.Home.HomeFragment
import com.example.projek_adityadefoeng.More.MoreFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BaseActivity : AppCompatActivity() {

    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_base)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        bottomNavView = findViewById(R.id.bottom_nav_view)

        bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.navigation_explore -> {
                    loadFragment(ExploreFragment())
                    true
                }
                R.id.navigation_more -> {
                    loadFragment(MoreFragment())
                    true
                }
                else -> false
            }
        }

        if (savedInstanceState == null) {
            bottomNavView.selectedItemId = R.id.navigation_home
        }
    }

    fun selectExploreTab() {
        bottomNavView.selectedItemId = R.id.navigation_explore
    }

    fun selectHomeTab() {
        if (bottomNavView.selectedItemId == R.id.navigation_home) {
            loadFragment(HomeFragment())
        } else {
            bottomNavView.selectedItemId = R.id.navigation_home
        }
    }

    fun selectMoreTab() {
        bottomNavView.selectedItemId = R.id.navigation_more
    }

    fun openDetail(destinationId: Int) {
        val fragment = DetailFragment.newInstance(destinationId)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}