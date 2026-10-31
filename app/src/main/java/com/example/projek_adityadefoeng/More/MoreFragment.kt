package com.example.projek_adityadefoeng.More

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.projek_adityadefoeng.BaseActivity
import com.example.projek_adityadefoeng.R
import com.example.projek_adityadefoeng.TopBarHelper

class MoreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_more, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TopBarHelper.setup(view, requireActivity())

        view.findViewById<Button>(R.id.btnMenuHome)?.setOnClickListener {
            (activity as? BaseActivity)?.selectHomeTab()
        }

        view.findViewById<Button>(R.id.btnMenuExplore)?.setOnClickListener {
            (activity as? BaseActivity)?.selectExploreTab()
        }

        view.findViewById<Button>(R.id.btnMenuMore)?.setOnClickListener {
            (activity as? BaseActivity)?.selectMoreTab()
        }

        view.findViewById<Button>(R.id.btnMenuOrder)?.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.traveloka.com"))
                startActivity(intent)
            } catch (_: Exception) {
            }
        }
    }
}