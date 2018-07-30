package com.omarea.vtools

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_adv_settings.*

class ActivityAdvSettings : AppCompatActivity() {
    private lateinit var spf: SharedPreferences
    private var myHandler = Handler()

    override fun onPostResume() {
        super.onPostResume()
        delegate.onPostResume()

    }

    @SuppressLint("ApplySharedPref")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adv_settings)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        spf = getSharedPreferences("adv", Context.MODE_PRIVATE)

        adv_retrieve_window.setOnClickListener {
            spf.edit().putBoolean("adv_retrieve_window", (it as Switch).isChecked).commit()
        }
        adv_keyevent.setOnClickListener {
            spf.edit().putBoolean("adv_keyevent", (it as Switch).isChecked).commit()
        }
        adv_find_viewid.setOnClickListener {
            spf.edit().putBoolean("adv_find_viewid", (it as Switch).isChecked).commit()
        }
        adv_event_window_state.setOnClickListener {
            spf.edit().putBoolean("adv_event_window_state", (it as Switch).isChecked).commit()
        }
        adv_event_content_change.setOnClickListener {
            spf.edit().putBoolean("adv_event_content_change", (it as Switch).isChecked).commit()
        }
        adv_event_view_click.setOnClickListener {
            spf.edit().putBoolean("adv_event_view_click", (it as Switch).isChecked).commit()
        }
    }

    override fun onResume() {
        super.onResume()

        adv_retrieve_window.isChecked = spf.getBoolean("adv_retrieve_window", true)
        adv_keyevent.isChecked = spf.getBoolean("adv_keyevent", true)
        adv_find_viewid.isChecked = spf.getBoolean("adv_find_viewid", true)
        adv_event_window_state.isChecked = spf.getBoolean("adv_event_window_state", true)
        adv_event_content_change.isChecked = spf.getBoolean("adv_event_content_change", false)
        adv_event_view_click.isChecked = spf.getBoolean("adv_event_view_click", false)
    }

    public override fun onPause() {
        super.onPause()
    }
}
