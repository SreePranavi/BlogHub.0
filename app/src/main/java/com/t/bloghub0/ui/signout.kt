package com.t.bloghub0.ui

import android.content.Intent
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.t.bloghub0.MainActivity

import com.t.bloghub0.R
import com.t.bloghub0.ui.gallery.GalleryViewModel
import com.t.bloghub0.ui.gallery.SignoutViewModel
import com.t.bloghub0.ui.login.LoginActivity
import android.content.Intent as Intent1
import java.util.Observer as Observer


class signout : Fragment() {

    private lateinit var signoutViewModel: SignoutViewModel


    override fun onCreateView(
           inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        signoutViewModel =
            ViewModelProviders.of(this).get(SignoutViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_signout, container, false)

    val start : Button = root.findViewById(R.id.button3)
        start.setOnClickListener{ startfresh()}



        return root

  }
    fun startfresh()
    {
        val intent = Intent(this@signout.context, MainActivity::class.java)
        startActivity(intent)
    }

}