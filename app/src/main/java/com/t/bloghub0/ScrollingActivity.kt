package com.t.bloghub0

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_scrolling.*
import android.content.Intent
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        val intent = Intent(this, Main2Activity::class.java)
        startActivity(intent)
        //setSupportActionBar(toolbar)
       /* fab.setOnClickListener { view ->
            Snackbar.make(view, "USERNAME", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()*/
        }
    }

