package com.t.bloghub0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
/*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
*/
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.t.bloghub0.ui.login.LoginActivity
import com.t.bloghub0.ui.login.signup


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sgin: Button = this.findViewById(R.id.sin)
        sgin.setOnClickListener { signin() }
        val sgup: Button = findViewById(R.id.sup)
        sgup.setOnClickListener { signupfunc() }

    }

    fun signin(){
        //Toast.makeText(this, "Navigates to signin activity",
          //  Toast.LENGTH_SHORT).show()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    fun signupfunc(){
        //Toast.makeText(this, "Navigates to signup activity",
          //  Toast.LENGTH_SHORT).show()
        val intent = Intent(this, signup::class.java)
        startActivity(intent)
    }

}

