package com.t.bloghub0.ui.slideshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.t.bloghub0.MainActivity
import com.t.bloghub0.R

class SlideshowFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProviders.of(this).get(SlideshowViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        slideshowViewModel.text.observe(this, Observer {
            textView.text = it
        })

        val newpublish : FloatingActionButton = root.findViewById(R.id.plus)
        newpublish.setOnClickListener{ newpublishfunc()}

        return root
    }

    private fun newpublishfunc()
    {
        val intent = Intent(this@SlideshowFragment.context, Newblog::class.java)
        startActivity(intent)
    }

}