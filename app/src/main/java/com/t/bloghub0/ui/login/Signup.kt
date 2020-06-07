
package com.t.bloghub0.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.t.bloghub0.R
import android.app.Activity
import android.content.Intent
import android.provider.Settings.Global.getString
import androidx.annotation.StringRes
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.t.bloghub0.Main2Activity
import com.t.bloghub0.ScrollingActivity
import com.t.bloghub0.ui.login.afterTextChanged as afterTextChanged1

class signup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val semail = findViewById<EditText>(R.id.smail)
        val spassword = findViewById<EditText>(R.id.spword)
        val bio = findViewById<EditText>(R.id.sbio)
        val pname = findViewById<EditText>(R.id.sname)
        val signup = findViewById<Button>(R.id.signupbttn)
        val loading = findViewById<ProgressBar>(R.id.sloading)

        lateinit var signupViewModel: SignupViewModel

        signupViewModel = ViewModelProviders.of(this, SignupViewModelFactory())
            .get(SignupViewModel::class.java)

        signupViewModel.signupFormState.observe(this@signup, Observer {
            val signupState = it ?: return@Observer

            signup.isEnabled = signupState.isDataValid

            if (signupState.usernameError != null) {
                semail.error = getString(signupState.usernameError)
            }
            if (signupState.passwordError != null) {
                spassword.error = getString(signupState.passwordError)
            }

            if (signupState.nameError != null) {
                pname.error = getString(signupState.nameError)
            }

        })

        signupViewModel.signupResult.observe(this@signup, Observer {
            val signupResult = it ?: return@Observer

            loading.visibility = View.GONE

            if (signupResult.error != null) {
                showsignupFailed(signupResult.error)
            }
            if (signupResult.success != null) {
                updatesignup(signupResult.success)

                val intent = Intent(this, Main2Activity::class.java)
                startActivity(intent)
            }
            setResult(Activity.RESULT_OK)

            finish()
        })

        semail.TextChanged {
            signupViewModel.signupDataChanged(
                semail.text.toString(),
                spassword.text.toString(),
                        pname.text.toString()

            )
        }

        spassword.apply {
            TextChanged {
                signupViewModel.signupDataChanged(
                    semail.text.toString(),
                    spassword.text.toString(),
                            pname.text.toString()
                )
            }

         pname.apply{
             TextChanged {
                 signupViewModel.signupDataChanged(
                     semail.text.toString(),
                     spassword.text.toString(),
                             pname . text . toString ()

                 )
             }


             setOnEditorActionListener { _, actionId, _ ->
                 when (actionId) {
                     EditorInfo.IME_ACTION_DONE ->
                         signupViewModel.signup(
                             semail.text.toString(),
                             spassword.text.toString(),pname.text.toString()
                         )
                 }
                 false
             }

             signup.setOnClickListener {
                 loading.visibility = View.VISIBLE
                 loading.visibility = View.VISIBLE
                 signupViewModel.signup(semail.text.toString(), spassword.text.toString(),pname.text.toString())
             }
         }
        }

    }
     private fun updatesignup(model: SignedUpUserView) {
        val welcome = getString(R.string.welcome)
        val penName = model.penName

        Toast.makeText(
            applicationContext,
            "$welcome $penName",
            Toast.LENGTH_LONG
        ).show()
    }

     private fun showsignupFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext,  errorString, Toast.LENGTH_SHORT).show()
    }
}

 fun EditText.TextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}







