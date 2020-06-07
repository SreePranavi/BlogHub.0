package com.t.bloghub0.ui.slideshow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.t.bloghub0.Main2Activity
import com.t.bloghub0.R
import com.t.bloghub0.ui.login.SignupViewModel


class Newblog : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newblog)

        val title = findViewById<EditText>(R.id.editText)
        val content = findViewById<EditText>(R.id.editText2)
        val publish = findViewById<Button>(R.id.button2)

        /*
        publish.setOnClickListener{ val intent = Intent(this, SlideshowFragment::class.java)
            startActivity(intent)}*/

    }

}
