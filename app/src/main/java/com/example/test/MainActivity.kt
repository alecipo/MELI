package com.example.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //this.supportActionBar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        //supportActionBar!!.setDisplayShowCustomEnabled(true)
        //supportActionBar!!.setCustomView(R.layout.custom_action_bar)

        //val view = supportActionBar!!.customView
        //val name = view.findViewById(R.id.search_text)
    }

}
